public class Point // set, get , store the values
{
   private float x;
   private float y;

// constructor
   public Point()
   {
       x = -9999;
       y = -9999;
   }

   public Point(float new_x, float new_y)
   {
       x = new_x;
       y = new_y;
   }

    //setter
    public void setX(float x) {this.x = x;}

    public void setY(float y) {this.y = y;}

    // getter
    public float getX() {return x;}

    public float getY() {return y;}

    // When object is passed in print() method as an argument then compiler internally call toString() method on the object.
    public String toString() // It returns object representation as classname@hexadecimal representation of hash code of the object.
    {
        String pointer = String.format("(%3.2f,%3.2f)", x, y);
        return pointer;
    }

}


