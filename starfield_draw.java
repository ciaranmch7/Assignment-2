import processing.core.PApplet;

public class starfield_draw {
	PApplet parent;
	Starfield starfield;
	
	void settings() {
		
		size(1000,1000);
	}
	
	void setup(PApplet p) {
	  parent = p;
	  starfield = new Starfield( 100 );
	  frameRate( 25 );
	  smooth();
	}

	void draw() {
	  background(0);
	  starfield.draw();
	}
	
}
