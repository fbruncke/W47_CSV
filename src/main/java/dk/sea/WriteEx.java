package dk.sea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEx {


    static void main() {
        write();
        readDifferentDatatypes();
    }
    /**
     * Simple example of using the printwriter
     */
    public static void write()  {

        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter("calories.txt");
            pw.println("Cola 200 calories");
            pw.println("Milk 100 calories");
            pw.println("Beer 150 calories");
            pw.println("Wine 400 calories");
            pw.println("true");
            pw.println("false");

        }
        catch ( FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            pw.close();
        }

    }

    private static void readDifferentDatatypes() {

        File iFile = new File("calories.txt");
        Scanner in = null;

        try {
            in = new Scanner(iFile);//.useDelimiter("calories");
            int cnt = 0;

            while (in.hasNext()) {
                if(in.hasNextInt())
                {
                    System.out.println("Int: " + in.nextInt() );
                }
                else if(in.hasNextBoolean())
                {
                    System.out.println("Boolean: " + in.nextBoolean() );
                }
                else {
                    System.out.println("String: " + in.next() );
                }

                cnt++;

            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            in.close();
        }

    }
}
