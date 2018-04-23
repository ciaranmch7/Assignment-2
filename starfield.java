import processing.core.PApplet;
public class Starfield  extends PApplet{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Starfield");
	}
	Star stars[];
	int STARS = 100;
	
	public void settings() {
		size(1000,1000)	;
			
		}

	public void setup() {
	 
	  stars = new Star[STARS];
	  for ( int i =0; i < STARS; i++) {
	    stars[i] = new Star( random( width ), random( height ), random( 10 ));
	  }
	  frameRate( 25 );
	  smooth();
	}

	public void draw() {
	  background(0);
	  starfield();
	}

	void starfield() {
	  strokeWeight( 2 );
	  for ( int i =0; i < STARS; i++) {
	    stroke( stars[i].z * 25 );
	    point( stars[i].x, stars[i].y );
	    
	    stars[i].x -= stars[i].z;
	    if (stars[i].x < 0) { 
	      stars[i] = new Star( width, random( height ), sqrt(random( 100 )));
	    }
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


}
