import processing.core.PApplet;
import processing.core.PImage;

public class Ship extends PApplet{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Ship");
	}
  PImage img;
  
  int x;
  int y;
  
  public Ship( int x, int y, PImage img ) {
    this.x = x;
    this.y = y;
    this.img = img;
  }
  
  
  public void draw() {

	  pushMatrix();
	    translate ( x, y );
	    image( img, -img.width/2, -img.height/2 );
	    popMatrix();

    
    
  }
}
