public class Polygon implements ComparePoly
{
     private Point[] pointer;
     public int size;

    public Polygon() // for Node class (sentinel, current are does not need data)
     {

     }

     public Polygon(String data)
     {
         try // Block of code to try
         {
             String[] line = data.split(" "); // split() function for the string that needs to provide and divided the separator argument
             size = Integer.parseInt(line[0]); // line[0] is pairs of number
             pointer = new Point[size]; // create a point class
             int index = 0; // number of pointer class
             for (int i = 1; i < line.length; i += 2) // store for X values (line[i]) and Y values (line[i+1])
             {
                 pointer[index] = new Point(Float.parseFloat(line[i]), Float.parseFloat(line[i + 1])); // convert string to float
                 index++;
             }
         }
         catch(NumberFormatException nm) // Block of  code to handle errors
         {
            System.out.println(nm.getMessage());  // error message
         }
     }
     // setter and getter
    public void setSize(int size) {this.size = size;}

    public int getSize() {return size;}

    public String toString() // toString() method returns the String representation of the object. so overriding the toString() method, returns the desired output.
    {
        String poly = "[";
        for( int i = 0; i < size; i++)
        {
            poly += pointer[i].toString();
        }
        poly += "]: " + String.format("%5.2f", calculation());
        return poly;
    }

    public double calculation() // polygon area calculation
    {
        double area;
        double sum = 0.0;
        int n = pointer.length-1;

        for(int i = 0; i < pointer.length; i++)
        {
            sum += ((pointer[n].getX() + pointer[i].getX()) * (pointer[n].getY() - pointer[i].getY()));
            n = i;
        }
        area = Math.abs(0.5 * sum);
        return area;
    }

    public double distance() // for sorted list
    {
        double dis = 0;
        // if origin of the point(0,0)  find the distance between all the points
        // the Polygon with the lower minimum vertex distance from the origin
        for(int j = 0; j < size-2; j++)
        {
            double a = ((pointer[j].getX() - pointer[0].getX()) * (pointer[j].getX() - pointer[0].getX()));
            double b = ((pointer[j].getY() - pointer[0].getY()) * (pointer[j].getY() - pointer[0].getY()));
            double values = Math.sqrt(a + b);
            if (values < dis) // check the distance (smaller)
            {
                dis = values;
            }
        }
        return dis;
    }

    // Overriding ComesBefore() method
    @Override
    public boolean ComesBefore(Object o)//It is used to compare the current object with the specified object
    {
        Polygon diffPoly = (Polygon) o;
        double a = this.calculation();
        double b = diffPoly.calculation();
        double gap =Math.abs((a-b)/((a+b)/2)) ;  // difference between two values(a-b),average of two numbers ((a+b)/2), ratio og the difference and the average


        if (a < b) // a is smaller
        {
            if (gap <= 0.05) // if their area difference is within 0.05% == same area
            {
                if (this.distance() < diffPoly.distance()) // compare the distances
                {
                    return true;
                }
            }
            return true;
        }
        if (a > b)
        {
            if (gap <= 0.05) // just in cases
            {
                if (this.distance() < diffPoly.distance())
                {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

}
