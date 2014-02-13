import java.awt.image.*;
public class MMSEFilter {
public double mmsef(String in,String out,int w,int h,float variance) {
double time=0;
      try {
        ImageDecoder input = ImageFile.createImageDecoder(in);
        ImageEncoder output = ImageFile.createImageEncoder(out);
        BufferedImage inputImage = input.decodeAsBufferedImage();
        BufferedImageOp op = new MMSEFilterOp(variance, w, h);
        IntervalTimer timer = new IntervalTimer();
        timer.start();
        BufferedImage outputImage = op.filter(inputImage, null);
    time=timer.stop();
        output.encode(outputImage);
      }
      catch (Exception e) {
        System.err.println(e);
              }
return time;
  }
}
