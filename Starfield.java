import processing.core.PApplet;
import processing.core.PImage;
public class Starfield extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Starfield");
	}
	Star stars[];
	int STARS = 100;
	
	PImage img;
	  
	  int x;
	  int y;
	  int speed;
	  
	  public void Ship( int x, int y, PImage img ) {
		    this.x = x;
		    this.y = y;
		    this.img = img;
		    this.speed = speed;
		  }
	public void settings() {
		size(1000,1000);
	}
	public void setup() {
		
		img = loadImage("player.jpg");
		frameRate( 25 );
		  smooth();
		 
	}

	public void draw() {
		
		 stars = new Star[STARS];
		  for ( int i =0; i < STARS; i++) {
		    stars[i] = new Star( random( width ), random( height ), random( 10 ));
		  }
		  
	  background(0);
	  strokeWeight( 2 );
	  for ( int i =0; i < STARS; i++) {
	    stroke( stars[i].z * 25 );
	    point( stars[i].x, stars[i].y );
	    stars[i].x -= stars[i].z;
	    if (stars[i].x < 0) { 
	      stars[i] = new Star( width, random( height ), sqrt(random( 100 )));
	    }
	      image(img, 0,300,width/8,height/8);
	      if ( keyPressed == true && key == CODED ) {
	    	     if ( keyCode == UP ) {
	    	       up();
	    	     } else if ( keyCode == DOWN ) {
	    	      down();
	    	     }
	    	  }  
	      pushMatrix();
		    translate ( x, y );
		    
		    popMatrix();

	    
	  }
	}

	

	class Star {
	  float x, y, z;
	  Star( float x, float y, float z ) {
	    this.x = x;
	    this.y = y;
    this.z = z;
	  }
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



