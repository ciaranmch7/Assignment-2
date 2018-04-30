import processing.core.PApplet;
import processing.core.PImage;
public class Spacewars  extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Spacewars");	}
	Star stars[];
	int STARS = 100;
	Ship ship;
	Enemey enemey;

	 PImage img;
	 
	 
	 
	  
	  int x;
	  int y;
	
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
	PImage simg = loadImage( "player.jpg" );
	  ship = new Ship( 100, 100,3, simg );
	  PImage eimg = loadImage("Feature.png");
	  enemey = new Enemey(500,100, 4, eimg);

	  
	  
	  
	  
	}
	
	
	
	public void draw() {
	  background(0);
	  
	  starfield();
	 
	  	  if ( keyPressed == true && key == CODED ) {
		     if ( keyCode == UP ) {
		       ship.up();
		     } else if ( keyCode == DOWN ) {
		       ship.down();
		     }
		  } 
	  
	  
	  enemey.update();
	  enemey.draw();
	  ship.draw();
	  
	 
	  
	  
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
	  class Ship {
		  
		  void draw() {
				pushMatrix();
			    translate ( x, y );
			    image( img, 0,300,width/8,height/8);
			    popMatrix();
			}
		 
		  int x, y,speed;
		PImage img;
		  public  Ship(int x, int y,int speed, PImage img ){
		    this.x = x;
		    this.y = y;
		    this.speed = speed;
		    this.img = img;
		  }
		    void up() {
				y -= speed;
			    if ( y < img.height/8) { y = img.height/8;}
			  }
			  
			  void down() {
			    y += speed;
			    if ( y > height - img.height/2 ) { y = height - img.height/2; }
			  }
			 
			 
	

}
	  class Enemey {
		  void draw() {
				 pushMatrix();
				    translate ( x, y );
				    image( img, 250,300,width/9,height/9 );
				    popMatrix();
				
			}
		  
		  int x, speed, y;
		  
		  public void update() {
		   
		    x -= speed;
		    if ( x < - img.width/2 ) {
		      x = width + img.width/2;
		      y = (int) ( random( height - img.width ) + img.width/2);
		    }
		  }
		 
		  
		  PImage img;
		  Enemey(int x, int y, int speed, PImage img){
		    this.x = x;
		    this.y = y;
		    this.speed = speed;
		    this.img = img;
		    
		  }
		  
		  
	 
}
	  
	  

	  
}


