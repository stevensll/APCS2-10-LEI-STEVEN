public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }

  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    stroke(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);

  }
  private double distance (double x1, double x2, double y1, double y2){
      double xComp = x1-x2;
      double yComp = y1-y2;
    return Math.sqrt(Math.pow(xComp,2)+Math.pow(yComp,2));
  }
  void click(){
    if(distance(this.x,mouseX,this.y,mouseY) <= this.radius){
      //this.radius+=3;
      if(selected){
        selected = false;
      }else {
        selected = true;
      }
    }
  }

  void collide(ArrayList<Cow>others){
    for(Cow cow: others){
      if(distance(this.x,cow.x,this.y,cow.y) <=(this.radius+cow.radius)){
        colliding = true;
      } else colliding = false;
    }
  }
}