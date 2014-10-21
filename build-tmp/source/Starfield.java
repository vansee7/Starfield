import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle [] bob;

public void setup()
{
  size(500,500);
  background(0);

  bob = new Particle[75];
  for(int nI=0; nI<bob.length-1;nI++)
    {
      bob[nI] = new NormalParticle();
    }
  bob[5] = new OddballParticle();
  bob[4] = new JumboParticle();
  for(int nI=0;nI < 10; nI++)
    {
      bob[nI].show();
      bob[nI].move();
    }
}

public void draw()
{
  for(int nI=0; nI<bob.length-1;nI++)
  {
    bob[nI].move();
    bob[nI].show();
  }
}

interface Particle
{
  public void move();
  public void show();
}

class NormalParticle implements Particle
{
  double dX, dY, dTheta, dSpeed, dSize;

  NormalParticle()
  {
    dX = 250;
    dY = 250;
    dTheta = Math.PI*2*Math.random();
    dSpeed = Math.random()*10;
    dSize = 10;
  }

  public void show()
  {
    noStroke();
    fill((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    ellipse((float)dX,(float)dY,(float)dSize,(float)dSize);
  }

  public void move()
  {
    dX = Math.cos(dTheta)*dSpeed + dX;
    dY = Math.sin(dTheta)*dSpeed +dY;
    dTheta = dTheta + .1f;
  }
}

class OddballParticle implements Particle
{
  double eX, eY, eTheta, eSpeed, eSize;

  OddballParticle()
  {
    eX = 250;
    eY = 250;
    eTheta = Math.PI*2*Math.random();
    eSpeed = Math.random()*5;
    eSize = 30;
  }

  public void show()
  {
    noStroke();
    fill(255);
    ellipse((float)eX,(float)eY,(float)eSize,(float)eSize);
  }

  public void move()
  {
    eX = Math.cos(eTheta)*eSpeed + eX;
    eY = Math.sin(eTheta)*eSpeed + eY;
    eTheta = eTheta + .1f;
  }
}

class JumboParticle extends NormalParticle
{
	JumboParticle()
	{
		dSize = 50;
	}

	public void show()
    {
    	noStroke();
    	fill(255);
    	ellipse((float)dX,(float)dY,(float)dSize,(float)dSize);
    }
}


public void mousePressed()
{
  background((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
  bob = new Particle[75];
  for(int nI=0; nI<bob.length-1;nI++)
    {
      bob[nI] = new NormalParticle();
    }
    bob[5] = new OddballParticle();
    bob[4] = new JumboParticle();
  for(int nI=0;nI < 10; nI++)
    {
      bob[nI].show();
      bob[nI].move();
    }
  for(int nI=0; nI<bob.length-1;nI++)
  {
    bob[nI].move();
    bob[nI].show();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
