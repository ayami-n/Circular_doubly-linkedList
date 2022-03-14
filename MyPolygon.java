public class MyPolygon {
    private Node sentinel, current;  // create a Node class
    private int size = 0;

    // create a class constructor for the MyPolygon class
    public MyPolygon() {
        sentinel = new Node(); // create a Node class -> make empty Polygon class()
        sentinel.setNext(sentinel); // this is circular linked list  (point at self)
        sentinel.setPrev(sentinel);
        current = new Node();
        current = sentinel;
    }

    public void add(String[] data) // received importfile from Main class
    {
        for (String i : data) // check the importfile (data) values
        {
            String x = i.trim(); // Remove whitespace from both sides of a string: like "     hello      " -> "hello"
            if (x != "")  // first line is empty so do this
            {
                append(x); // call append function
            }
        }
    }


    public void sortAdd(String[] data) // received importfile from Main class
    {
        for (String i : data) // check the importfile (data) values
        {
            String x = i.trim(); // Remove whitespace from both sides of a string: like "     hello      " -> "hello"
            if (x != "")  // first line is empty so do this
            {
                insertInOrder(x); // call append function
            }
        }
    }

    // Add at current
    public void insert(String data) {linkedlist(data, current);}

    // Add at head
    public void prepend(String data) {linkedlist(data, current.getNext());} // get data and call linkedlist function

    // Add at tail
    public void append(String data) {
        linkedlist(data, sentinel);
    }

    // Add at new Node
    public void linkedlist(String data, Node NextorPrev) // create circular double-linked list
    {
        Node temp = new Node(data); // create new Node

        NextorPrev.getPrev().setNext(temp);
        temp.setPrev(NextorPrev.getPrev());
        NextorPrev.setPrev(temp);
        temp.setNext(NextorPrev);
        reset(); // call reset() function
        size++; // increasing size
    }

    public void reset() {
        current = sentinel;
    }

    public void next() {
        current = current.getNext();
    }

    public void removeNode()
    {
        reset();
        next();
        while (size != 0)
        {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current.setNext(null);
            current.setPrev(null);
            size--;
            reset();
            next();
        }
    }

    public void insertInOrder(String data)
    {
        if (size == 0) //
        {
            insert(data); // call insert function
            return; // ture
        }
        if (size > 0) // current point at sentinel.getNext()
        {
            current = sentinel.getNext();
        }

        Polygon temp = new Polygon(data);
        while (temp.ComesBefore(current.getData())) // if compare all current.getData() finish wile loop
        {
            next();
            if (current == sentinel)
            {
                insert(data);
                return;
            }
        }
        insert(data);
    }

    public void printlist()
    {
        reset(); // use for set right position
        next(); // point to a Node for all node checks
        if (size == 0) // this is empty check (this time did not get happen it)
        {
            System.out.println("Empty....");
            return;
        }
        while (current != sentinel) {
            current.print();   // call print function (node class getData -> Polygon.toString())
            next(); // move to next
        }
    }

}




