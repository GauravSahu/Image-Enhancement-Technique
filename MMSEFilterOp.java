import java.awt.image.*;
public class MMSEFilterOp extends NeighbourhoodOp {


  private float noiseVariance;
  private float[] neighbourhood;


  public MMSEFilterOp(float variance) {
    this(variance, 3, 3, NO_BORDER_OP);
  }


  public MMSEFilterOp(float variance, int w, int h) {
    this(variance, w, h, NO_BORDER_OP);
  }


  public MMSEFilterOp(float variance, int w, int h, int strategy) {
    super(w, h, strategy);
    if (variance <= 0.0f)
      throw new ImagingOpException("noise variance must be greater than zero");
    noiseVariance = variance;
    neighbourhood = new float[size];
  }

 
  public BufferedImage filter(BufferedImage src, BufferedImage dest) {

    checkImage(src);
    if (dest == null)
      dest = createCompatibleDestImage(src, null);

    int w = src.getWidth();
    int h = src.getHeight();
    Raster srcRaster = src.getRaster();
    WritableRaster destRaster = dest.getRaster();

    int m = width/2;
    int n = height/2;
    switch (borderStrategy) {

      case REFLECTED_INDEXING:
        for (int y = 0; y < h; ++y)
          for (int x = 0; x < w; ++x) {
            int i = 0;
            for (int k = -n; k <= n; ++k)
              for (int j = -m; j <= m; ++j, ++i)
                neighbourhood[i] =
                 srcRaster.getSample(refIndex(x+j, w), refIndex(y+k, h), 0);
            destRaster.setSample(x, y, 0, filterValue());
          }
        break;

      case CIRCULAR_INDEXING:
        for (int y = 0; y < h; ++y)
          for (int x = 0; x < w; ++x) {
            int i = 0;
            for (int k = -n; k <= n; ++k)
              for (int j = -m; j <= m; ++j, ++i)
                neighbourhood[i] =
                 srcRaster.getSample(circIndex(x+j, w), circIndex(y+k, h), 0);
            destRaster.setSample(x, y, 0, filterValue());
          }
        break;

      case COPY_BORDER_PIXELS:
        copyBorders(srcRaster, destRaster);
        // fall through

      default:
        for (int y = n; y < h-n; ++y)
          for (int x = m; x < w-m; ++x) {
            int i = 0;
            for (int k = -n; k <= n; ++k)
              for (int j = -m; j <= m; ++j, ++i)
                neighbourhood[i] = srcRaster.getSample(x+j, y+k, 0);
            destRaster.setSample(x, y, 0, filterValue());
          }
        break;

    }

    return dest;

  }


 
  private int filterValue() {

    // Compute local mean

    float sum = 0.0f;
    for (int i = 0; i < size; ++i)
      sum += neighbourhood[i];
    float mean = sum/size;

    // Compute local variance

    sum = 0.0f;
    for (int i = 0; i < size; ++i)
      sum += (neighbourhood[i]-mean)*(neighbourhood[i]-mean);
    float variance = sum/size;

    // Compute filter value

    try {
      float ratio = noiseVariance / variance;
      if (ratio > 1.0f)
        return Math.round(mean);
      else {
        int result =
         Math.round((1.0f-ratio)*neighbourhood[size/2] + ratio*mean);
        return Math.max(0, Math.min(255, result));
      }
    }
    catch (ArithmeticException e) {
      return Math.round(mean);
    }

  }


}
