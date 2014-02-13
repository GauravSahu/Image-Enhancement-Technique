//V
//MAIN PROGRAM

import java.applet.*;
import java.awt.*;
import java.awt.Event;
import java.awt.image.*;

public class pck extends myframe
{
Insets insets;
Image src,dst;
ImageProducer filtered;
String filename=null;
double time;
String msg=" ";
public pck()
{}

public void paint(Graphics g)
{
if(filename!=null)
g.drawImage(dst,insets.left,insets.top,this);
g.drawString(msg,300,60);
}

public static void main(String a[])
{
pck f=new pck();
f.show();
}
public void view(String out)
{
Image im=Toolkit.getDefaultToolkit().getImage(out);
MediaTracker m=new MediaTracker(this);
m.addImage(im,0);
try{
m.waitForID(0);
}catch(Exception e)
{
System.out.println("Image Loading Error!"+e);
System.exit(0);
}
dst=im;
repaint();
}
public void abc()
{
if(filename!=null)
{
src=Toolkit.getDefaultToolkit().getImage(filename);
MediaTracker mt=new MediaTracker(this);
mt.addImage(src,0);
try
{
mt.waitForID(0);
}catch(Exception e)
{
System.out.println("Image Loading Error!"+e);
System.exit(0);
}
dst=src;
msg=" ";
repaint();
}
}



public void addNotify()
{
super.addNotify();
insets=getInsets();
setBounds(50,50,750+insets.left,500+insets.top);
}

public void open()
{
FileDialog fd=new FileDialog(this,"Open",FileDialog.LOAD);
fd.setVisible(true);
String dir=fd.getDirectory();
String fname=fd.getFile();
filename=dir+fname;
abc();
}

public void org()
{
if(filename!=null)
{
dst=src;
msg=" ";
repaint();
}
}



public void lp()
{
if(filename!=null)
{
int[] filter={1,1,1,
                 1,1,1,
				     1,1,1};
double multiplier=0.11111;
convfilter cv=new convfilter(filter);
filtered=cv.filteredImage(dst,multiplier);
dst=createImage(filtered);
msg=" ";
repaint();
}
}
public void bh()
{
  if(filename!=null)
  {

int errflag=0;
   String in=filename;
try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
  String save="d:\\bw.jpg";
   int order,bias;
   float rad;
       mydialog md=new mydialog(this,"Butter Worth High Pass",true,1); 
     md.setSize(250,180); 
     md.setVisible(true);
System.out.println("b4 values");   
   if((md.val1!=null)&&(md.val2!=null)&&(md.val3!=null))
    {
     order=Integer.parseInt(md.val1);
     bias=Integer.parseInt(md.val2);
     rad= Float.valueOf(md.val3).floatValue();
System.out.println("order,bias,rad");         
     if(errflag==0)
    {
System.out.println("order,bias,rad2");         
      Bwhp bw=new Bwhp();
      time=bw.bw(in,save,order,rad,bias);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}
public void bl()
{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
 String save="d:\\bw1.jpg";
   int order;
   float rad;
       mydialog md=new mydialog(this,"Butter Worth Low Pass",true,2); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null))
    {
     order=Integer.parseInt(md.val1);
     rad= Float.valueOf(md.val2).floatValue();
         
     if(errflag==0)
    {
      bwlp bw=new bwlp();
      time=bw.bl(in,save,order,rad);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}
public void hp()
{
if(filename!=null)
{
int[] filter={-1,-1,-1,
                  -1,8,-1,
				      -1,-1,-1};
double multiplier=1;
convfilter cv=new convfilter(filter);
filtered=cv.filteredImage(dst,multiplier);
dst=createImage(filtered);
msg=" ";
repaint();
}
}

public void hb()
{
if(filename!=null)
{
int[] filter={-1,-1,-1,
					-1,9,-1,
							-1,-1,-1};
double multiplier=1;
convfilter cv=new convfilter(filter);
filtered=cv.filteredImage(dst,multiplier);
dst=createImage(filtered);
msg=" ";
repaint();
}
}
public void ilp()
{
  if(filename!=null)
  {
    int errflag=0;
   String in=filename;
  try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
   String save="d:\\bw2.jpg";
    float rad;
    mydialog md=new mydialog(this,"Ideal Low Pass",true,3); 
     md.setSize(250,180); 
     md.setVisible(true);

   if(md.val1!=null)
    {
        rad= Float.valueOf(md.val1).floatValue();
         
     if(errflag==0)
    {
      ilp bw=new ilp();
      time=bw.il(in,save,rad);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}
public void ihp()
{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
  try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
 String save="d:\\bw3.jpg";
   int bias;
   float rad;
       mydialog md=new mydialog(this,"Ideal High Pass",true,4); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null))
    {
     bias=Integer.parseInt(md.val1);
     rad= Float.valueOf(md.val2).floatValue();
         
     if(errflag==0)
    {
      ihp bw=new ihp();
      time=bw.ih(in,save,rad,bias);
         msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}
public void mf()
{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
 String save="d:\\bw4.jpg";
   int width,height;
       mydialog md=new mydialog(this,"Mean Filter",true,5); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null))
    {
     width=Integer.parseInt(md.val1);
     height=Integer.parseInt(md.val2);
         
     if(errflag==0)
    {
      MeanFilter bw=new MeanFilter();
      time=bw.mf(in,save,width,height);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}

public void med()
{
try{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
  try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
 String save="d:\\bw5.jpg";
   int width,height;
       mydialog md=new mydialog(this,"Median Filter",true,6); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null))
    {
     width=Integer.parseInt(md.val1);
     height=Integer.parseInt(md.val2);
         
     if(errflag==0)
    {
      MedianFilter bw=new MedianFilter();
      time=bw.mf(in,save,width,height);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}catch(ImagingOpException e){
}
}

public void max()
{
  if(filename!=null)
  {
int errflag=0;
   
try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
String in=filename;
   String save="d:\\bw6.jpg";
   int width,height;
       mydialog md=new mydialog(this,"Max Filter",true,7); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null))
    {
     width=Integer.parseInt(md.val1);
     height=Integer.parseInt(md.val2);
     
     if(errflag==0)
    {
      MaxFilter bw=new MaxFilter();
     time=bw.max(in,save,width,height);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
}
repaint();
}    
}

public void min()
{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
try{
   pck p=new pck();
    check();
   }catch (Exception e){ }
 String save="d:\\bw7.jpg";
   int width,height;
       mydialog md=new mydialog(this,"Min Filter",true,8); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null))
    {
     width=Integer.parseInt(md.val1);
     height=Integer.parseInt(md.val2);
         
     if(errflag==0)
    {
      MinFilter bw=new MinFilter();
      time=bw.min(in,save,width,height);
      msg="Filtering finished in "+time+" seconds.";
      view(save);
    }
}
repaint();
}    
}
public void rank()
{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
 String save="d:\\bw8.jpg";
   int n1,n2,r;
       mydialog md=new mydialog(this,"Rank Filter",true,9); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null)&&(md.val3!=null))
    {
     n1=Integer.parseInt(md.val1);
     n2=Integer.parseInt(md.val2);
     r=Integer.parseInt(md.val3);         
    if(r<1 || r>9)
      errflag=1;
     if(errflag==0)
    {
      RankFilter bw=new RankFilter();
      time=bw.rn(in,save,n1,n2,r);
      msg="Filtering finished in "+time+" seconds.";
       view(save);
    }
else
{
errdialog ed=new errdialog(this,"Error!",true,0);
ed.setSize(200,100);
ed.setVisible(true);
}
}
repaint();
}    
}
public void mmse()
{
  if(filename!=null)
  {
int errflag=0;
   String in=filename;
   try{
           ImageDecoder input = ImageFile.createImageDecoder(in);
            BufferedImage inputImage = input.decodeAsBufferedImage();
             if (inputImage.getType() != BufferedImage.TYPE_BYTE_GRAY) {
                    errdialog ed=new errdialog(this,"Error!",true,1);
                   ed.setSize(200,100);
                  ed.setVisible(true);}
    }catch(Exception e){}

 String save="d:\\bw9.jpg";
   int n1,n2;
   float nv;
       mydialog md=new mydialog(this,"MMSE Filter",true,10); 
     md.setSize(250,180); 
     md.setVisible(true);

   if((md.val1!=null)&&(md.val2!=null)&&(md.val3!=null))
    {
     n1=Integer.parseInt(md.val1);
     n2=Integer.parseInt(md.val2);
     nv=Float.valueOf(md.val3).floatValue();         
     if(errflag==0)
    {
      MMSEFilter bw=new MMSEFilter();
      time=bw.mmsef(in,save,n1,n2,nv);
      msg="Filtering finished in "+time+" seconds.";
         view(save);
    }
}
repaint();
}    
}
public void check()throws Exception
{
             ImageDecoder input = ImageFile.createImageDecoder(filename);
                  System.out.println("check");
                BufferedImage inputImage = input.decodeAsBufferedImage();
                  System.out.println("check1");
             if (inputImage.getType() != BufferedImage.TYPE_BYTE_GRAY) {
                           System.out.println("check");
                    errdialog ed=new errdialog(this,"Error!",true,1);
                   ed.setSize(200,100);
                  ed.setVisible(true);}
}
}