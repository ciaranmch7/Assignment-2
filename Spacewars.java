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
	 PImage boom;
	 
	 
	  
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
	  boom = loadImage( "boom.jpg" );
	  
	  
	  
	}
	
	int boom_count = 0;
	
	public void draw() {
	  background(0);
	  enemey.update();
	  starfield();
	  if ( boom_count == 0 ) {
	  	  if ( keyPressed == true && key == CODED ) {
		     if ( keyCode == UP ) {
		       ship.up();
		     } else if ( keyCode == DOWN ) {
		       ship.down();
		     }
		  } 
	  	ship.draw();
	  }
	 else {
	    image( boom, ship.getBox().x1, ship.getBox().y1 );
	    boom_count--;
	  }
	 if ( ship.getBox().isOverlap( enemey.getBox())) {
		    boom_count = 25;
		  }  
		 
	  
	 
	  	
	  	  
	  enemey.draw();
	  
	 
	  
	  
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
			    if ( y < img.height/8 ) { y = img.height/8;}
			  }
			  
			  void down() {
			    y += speed;
			    if ( y > height - img.height/8 ) { y = height - img.height/8; }
			  }
			  public Box getBox() {
				    return new Box( x - img.width/6, y-img.height/6, x+img.height/6, y+img.height/6);
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
		  public Box getBox() {
			    return new Box( x - img.width/6, y-img.height/6, x+img.height/6, y+img.height/6);
			  }
		  
	 
}
	  public class Box {
		  int x1, x2;
		  int y1, y2;
		  
		  Box( int x1, int y1, int x2, int y2 ) {
		    this.x1 = x1;
		    this.y1 = y1;
		    
		    this.x2 = x2;
		    this.y2 = y2;
		  }
		  
		  boolean isOverlap( Box b ) {
		    if ((( x1 <= b.x1 && b.x1 <= x2 ) || ( x1 <= b.x2 && b.x2 <= x2 ))
		     && (( y1 <= b.y1 && b.y1 <= y2 ) || ( y1 <= b.y2 && b.y2 <= y2 ))) {
		      return true; 
		    }
		    return false;
		  }  
		}
	  

	  
}


