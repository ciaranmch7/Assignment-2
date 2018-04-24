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
	 PImage eimg;
	 
	 
	  
	  int x;
	  int y;
	  int speed;
	Ship ship;
	
	  
	  public void Ship( int x, int y, int speed, PImage img ) {
	    this.x = x;
	    this.y = y;
	    this.speed = speed;
	    this.img = img;
	  }
	  
	 
	  
	 
	public void settings() {
		size(1000,1000);
	}
	public void setup() {
		eimg = loadImage("Feature.png");
		 img = loadImage("player.jpg");
		 ship = new Ship( 100, height/2, 3, img );
		
			frameRate( 25 );
			  smooth();
			 
		}

	public void draw() {
		background(0);
		 stars = new Star[STARS];
		  for ( int i =0; i < STARS; i++) {
		    stars[i] = new Star( random( width ), random( height ), random( 10 ));
		  }
	  strokeWeight( 2 );
	  for ( int i =0; i < STARS; i++) {
	    stroke( stars[i].z * 25 );
	    point( stars[i].x, stars[i].y );
	    stars[i].x -= stars[i].z;
	    if (stars[i].x < 0) { 
	      stars[i] = new Star( width, random( height ), sqrt(random( 100 )));
	    }
	  }
	      
	      if ( keyPressed == true && key == CODED ) {
	    	     if ( keyCode == UP ) {
	    	       up();
	    	     } else if ( keyCode == DOWN ) {
	    	      down();
	    	     }
	    	  }  
	      pushMatrix();
		    translate ( x, y );
		    image( img, 0,300,width/8,height/8 );
		    image(eimg,850,300,width/10,height/9);
		    
		    popMatrix();

	    

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
