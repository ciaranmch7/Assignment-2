import processing.core.PApplet;
import processing.core.PImage;

public class Enemey extends PApplet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("enemey");
	}
	
  
	int x;
	int y;
	int speed;
	PImage img;
	
	public Enemey( int x, int y, int speed, PImage img ) {
	    this.x = x;
	    this.y = y;
	    this.speed = speed;
	    this.img = img;
}
	 public void draw() {
		    pushMatrix();
		    translate ( x, y );
		    image( img, -img.width/2, -img.height/2 );
		    popMatrix();
		  }
}
