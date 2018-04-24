import processing.core.PApplet;

public class starfield_draw<starfield> extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("starfield_draw");
	}
	Starfield starfield;
	public void settings() {
		size(640,480);
	}
	public void setup() {
	  
	  starfield = new Starfield();
	  frameRate( 25 );
	  smooth();
	}

	public void draw() {
	  background(0);
	  starfield.draw();
	}

}
