import java.io.File;
import java.io.IOException;
import java.util.*;

// abstract class can't be instantiated by other classes
public abstract class Import
{
    public static String[] importFile(String importFileName) // string[] can receive this return values
    {
        // set file path specified in command line argument as file to read from
        String fileName = importFileName;

        // if no filepath specified in command line arguments, ask for filepath in console
        if(importFileName == null)
        {
            // set up console input
            Scanner console = new Scanner(System.in);

            // read in process list from file
            System.out.println("What's the name of the file you want to read from? ");
            fileName = console.nextLine();
        }

        // prepare to extract import values
        String[] parts = null; // this is going back to main
        Scanner importStream = null;
        String dots = ""; // this add all values in one line

        try //try to read the line
        {
            importStream = new Scanner(new File(fileName));

            while(importStream.hasNextLine())
            {
                try
                {
                    dots += importStream.nextLine(); // concatenate all values into 1 line
                    // P 4 0 0 0 2 2 2 2 0 P 4 1 1 1 3 3 3 3 1P 6 4 0 4 8 7 8 7 3 9 0 7 1    P 4 -3.0 0.9 2.23 4.8 3.0 1.00001 -4.2 -3.9...
                } //end of try to read

                catch(NoSuchElementException | NullPointerException n)
                {
                    System.err.println(n.getMessage()); // print line (red line)
                }
            } // end of while loop

        } // end of try to access the files

        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        finally //finally done to store the values from the text file
        {
            if(importStream != null)
            {
                importStream.close(); //closing import stream for the next
            }
        }

        // splitting by P and 1 space
        parts = dots.split("P");
        return parts; // return the value to Main Class
    }

}
