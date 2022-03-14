import java.util.ArrayList;

public class Main
{
    MyPolygon mypol = new MyPolygon();  // create a MyPolygon class
    MyPolygon mypol2 = new MyPolygon(); // create for sorted list
    private String[] aList;

    private void run(String data)
   {
       aList = Import.importFile(data); // import class importFile function (data) stored in aList
       mypol.add(aList); // call MyPolygon app (aList) function
       mypol2.sortAdd(aList);
       System.out.println("Unsorted list"); // make title
       mypol.printlist();  // call printlist() function (Main -> MyPolygon -> Node -> Polygon)
       System.out.println("Sorted list"); // make title
       mypol2.printlist();
   }

    public static void main(String[] args)
    {
        Main main = new Main(); // Create an object of class Main (This will call the constructor)
        main.run(args[0]);
    }
}
