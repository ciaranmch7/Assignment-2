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
  int speed;
  
  public Ship( int x, int y, int speed, PImage img ) {
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
  void up() {
	    y -= speed;
	    if ( y < img.height/2 ) { y = img.height/2; }
	  }
	  
	  void down() {
	    y += speed;
	    if ( y > height - img.height/2 ) { y = height - img.height/2; }
	  }
}
