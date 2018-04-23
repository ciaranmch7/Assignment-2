import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	Starfield starfield;
	
	Ship ship;
	public void settings() {
		size(1000,1000);
	}
	public void setup() {
	  starfield = new Starfield( 100 );


	  PImage simg = loadImage( "player.jpg" );
	  ship = new Ship( 100, height/2, simg );
	  
	  frameRate( 25 );
	  smooth();
	}

	public void draw() {
	  background(0);
	  starfield.draw();
	  ship.draw();
	}

}
