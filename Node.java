
public class Node
{
    private Polygon data; // create Polygon class
    private Node next;
    private Node prev;

    // constructor
    public Node() // Just create empty Node class
    {
        next = null;
        prev = null;
        data = new Polygon();
    }

    public Node(String new_data) // only handling data
    {
        next = null;
        prev = null;
        data = new Polygon(new_data);
    }


    public Node(Node new_next, Node new_prev, String new_data)
    {
        next = new_next;
        prev = new_prev;
        data = new Polygon(new_data);
    }

    //setter
    public void setNext(Node next) {this.next = next;}

    public void setPrev(Node prev) {this.prev = prev;}

    public void setData(String new_data) {this.data = new Polygon(new_data);}

    //getter
    public Node getNext() {return this.next;}

    public Node getPrev() {return this.prev;}

    public Polygon getData() {return this.data;}

    public void print() // for MyPolygon class
    {
        System.out.println(this.data.toString());
    }
}
