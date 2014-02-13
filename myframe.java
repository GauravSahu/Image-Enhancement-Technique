//V
import java.awt.*;
import java.awt.event.*;

abstract class myframe extends Frame implements ActionListener,WindowListener
{
MenuItem op,cls;
MenuItem org,lp,hp,hb,bh,bl,ih,il,mf,mef,maxf,minf,rf,mmsef;

public myframe()
{
super("Image Filters");
MenuBar mb1=new MenuBar();
setMenuBar(mb1);
Menu file=new Menu("File");
Menu image=new Menu("Filters");
Menu hpf=new Menu("High Pass Filters");
Menu lpf=new Menu("Low Pass Filters");
//Menu test=new Menu("Tests");

mb1.add(file);
mb1.add(image);
//mb1.add(hpf);
//mb1.add(lpf);
//mb1.add(test);

file.add(op=new MenuItem("Open"));
file.add(org=new MenuItem("Original Image"));
file.add(cls=new MenuItem("Exit"));
//image.add(hb=new MenuItem("High Boost Filter"));
image.add(mf=new MenuItem("Mean Filter"));
image.add(mef=new MenuItem("Median Filter"));
image.add(maxf=new MenuItem("Max Filter"));
image.add(minf=new MenuItem("Min Filter"));
//image.add(rf=new MenuItem("Rank Filter"));
//image.add(mmsef=new MenuItem("MMSE Filter"));
lpf.add(lp=new MenuItem("Low Pass Filter"));
hpf.add(hp=new MenuItem("High Pass Filter"));
hpf.add(bh=new MenuItem("Butter Worth High Pass Filter"));
lpf.add(bl=new MenuItem("Butter Worth Low Pass Filter"));
hpf.add(ih=new MenuItem("Ideal High Pass Filter"));
lpf.add(il=new MenuItem("Ideal Low Pass Filter"));
//test.add(mt=new MenuItem("Mean Test"));
//test.add(met=new MenuItem("Median Test"));
op.addActionListener(this);
cls.addActionListener(this);
org.addActionListener(this);
lp.addActionListener(this);
//hb.addActionListener(this);
bh.addActionListener(this);
bl.addActionListener(this);
ih.addActionListener(this);
il.addActionListener(this);
mf.addActionListener(this);
mef.addActionListener(this);
maxf.addActionListener(this);
minf.addActionListener(this);
//rf.addActionListener(this);
//mmsef.addActionListener(this);
//mt.addActionListener(this);
//met.addActionListener(this);
addWindowListener(this);
}

public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();

if(ae.getSource() instanceof MenuItem)
{
if(s.equals("Exit"))
System.exit(0);

else

if(s.equals("Open"))
open();

else

if(s.equals("Original Image"))
org();

else

if(s.equals("Low Pass Filter"))
lp();

else

if(s.equals("High Pass Filter"))
hp();

else

if(s.equals("High Boost Filter"))
hb();
else

if(s.equals("Butter Worth High Pass Filter")) 
bh();

else

if(s.equals("Butter Worth Low Pass Filter"))
bl();

else
if(s.equals("Ideal Low Pass Filter"))
ilp();

else
if(s.equals("Ideal High Pass Filter"))
ihp();

else
if(s.equals("Mean Filter"))
mf();

else
if(s.equals("Median Filter"))
med();

else
if(s.equals("Max Filter"))
max();

else
if(s.equals("Min Filter"))
min();

else
if(s.equals("Rank Filter"))
rank();

else
if(s.equals("MMSE Filter"))
mmse();
}
}

public void windowClosed(WindowEvent we)
{}
public void windowDeiconified(WindowEvent we)
{}
public void windowIconified(WindowEvent we)
{}
public void windowActivated(WindowEvent we)
{}
public void windowDeactivated(WindowEvent we)
{}
public void windowOpened(WindowEvent we)
{}
public void windowClosing(WindowEvent we)
{
dispose();
System.exit(0);
}

abstract void open();
abstract void org();
abstract void lp();
abstract void hp();
abstract void hb();
abstract void bh();
abstract void bl();
abstract void ilp();
abstract void ihp();
abstract void mf();
abstract void med();
abstract void max();
abstract void min();
abstract void rank();
abstract void mmse();
}

