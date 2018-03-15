
import java.io.*;

import java.text.DecimalFormat;
import java.util.Scanner;

//##############################################################################
/**
 * The user input class facilitates simple output and input methods in Java that
 * utilise the command line.<br><br>
 * This class facilitates the following fuctions<br><br>
 * <ul>
 * <li>Output to screen
 * <li>Output to file
 * <li>Read from keyboard
 * <li>Read from file
 * <li>Format the output of integer, double and float types (alignment, decimal
 * places).
 * </ul>
 *
 * <b>Version: 1.0</b> -  Andrew Scott 2008
 */
//#############################################################################
public class UserInput {



    private static Scanner kbInput =  new Scanner(System.in);
    private static Scanner input;
    private static File fileInput;
    private static File outputFile;

    private static  FileWriter fw;
    private static PrintWriter pw;

    public UserInput() { };


    //==========================================================================

    //==========================================================================
    private static Scanner createInput()
    {
        if (input == null)
            input = new Scanner(System.in);
        return input;
    }//end create input=========================================================


    //==========================================================================
    /**
     * Prompts the specified String to the screen, without end-of-line
     * @param s The string to be output.
     */
    //==========================================================================
    public static void prompt (String s)
    {

        System.out.print(s + " ");
        System.out.flush();

    } // end prompt()===========================================================

    //==========================================================================
    /**
     * Prints the specified String to the screen or a file, without end-of-line.
     * <br><br>
     * If the outputFile has been created and the PrintWriter and FileWriter
     * initialised by the openOutputFile(String name) method then this method
     * write to the file specified.
     * <br><br>
     * If the outputFile, printWriter and fileWriter objects are null the print
     * method will output to the screen.
     * @param s The string to be output.
     */
    //==========================================================================
    public static void print (String s)
    {
        if (pw == null || fw == null || outputFile == null)
        {
            System.out.print(s);
            System.out.flush();
        }//end if
        else if (pw != null && fw != null && outputFile != null)
        {
            pw.print(s);
        }//end else if
    } // end prompt()===========================================================

    //==========================================================================
    /**
     * Prints the specified String to the screen or a file, with an end-of-line.
     * <br><br>
     * If the outputFile has been created and the PrintWriter and FileWriter
     * initialised by the openOutputFile(String name) method then this method
     * write to the file specified.
     * <br><br>
     * If the outputFile, printWriter and fileWriter objects are null the print
     * method will output to the screen.
     * @param s The string to be output.
     */
    //==========================================================================
    public static void println (String s)
    {
        if (pw == null || fw == null || outputFile == null)
        {
            System.out.println(s);
            System.out.flush();
        }//end if
        else if (pw != null && fw != null && outputFile != null)
        {
            pw.println(s);
        }//end else if
    } // end prompt()===========================================================

    /**
     * Prints an int to the screen or file with newLine.
     * @param i the data to be printed
     * @see println(String s)
     */
    public static void println(int i)  {  println( new Integer(i).toString()); }

    /**
     * Prints a long to the screen or file with newLine.
     * @param l the data to be printed
     * @see println(String s)
     */
    public static void println(long l) { println(new Long(l).toString());}

    /**
     * Prints a short to the screen or file with newLine.
     * @param s the data to be printed
     * @see println(String s)
     */
    public static void println(short s) { println(new Short(s).toString());}

    /**
     * Prints a double to the screen or file with newLine.
     * @param d the data to be printed
     * @see println(String s)
     */
    public static void println(double d) { println(new Double(d).toString());}

    /**
     * Prints a float to the screen or file with newLine.
     * @param f the data to be printed
     * @see println(String s)
     */
    public static void println(float f) { println(new Float(f).toString()); }

    /**
     * Prints a char to the screen or file with newLine.
     * @param c the data to be printed
     * @see println(String s)
     */
    public static void println( char c)  { println(new String(""+ c));}

    /**
     * Prints a boolean to the screen or file with newLine.
     * @param b the data to be printed
     * @see println(String s)
     */
    public static void println(boolean b) { println(new Boolean(b).toString());}

    /**
     * Prints an integer to the screen or file without newLine.
     * @param i the data to be printed
     * @see print(String s)
     */
    public static void print(int i)  { print( new Integer(i).toString());}

    /**
     * Prints a long to the screen or file without newLine.
     * @param l the data to be printed
     * @see print(String s)
     */
    public static void print(long l) { print(new Long(l).toString());}

    /**
     * Prints an short to the screen or file without newLine.
     * @param s the data to be printed
     * @see print(String s)
     */
    public static void print(short s) { print(new Short(s).toString());}

    /**
     * Prints an double to the screen or file without newLine.
     * @param d the data to be printed
     * @see print(String s)
     */
    public static void print(double d) { print(new Double(d).toString());}

    /**
     * Prints an float to the screen or file without newLine.
     * @param f the data to be printed
     * @see print(String s)
     */
    public static void print(float f) { print(new Float(f).toString());}

    /**
     * Prints an char to the screen or file without newLine.
     * @param c the data to be printed
     * @see print(String s)
     */
    public static void print( char c)  { print(new String(""+ c));}

    /**
     * Prints an boolean to the screen or file without newLine.
     * @param b the data to be printed
     * @see print(String s)
     */
    public static void print(boolean b) { print(new Boolean(b).toString());}


    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as a char
     * @return The user input value
     */
    //==========================================================================
    public static char readChar()
    {
        char returnValue = ' ';
        createInput();//Sets up Scanner object

        try
        {
            String userInput = new String(input.nextLine());
            returnValue = userInput.charAt(0); //return just the first character
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as a char");
        }//end catch

        return returnValue;
    } // end readChar()=========================================================

    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as a String
     * @return The user input value
     */
    //==========================================================================
    public static String readString()
    {
        createInput();//Sets up Scanner object
        String userInput = null;

        try
        {
            userInput = new String(input.nextLine());
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as a " +
                    "String");
        }//end catch

        return userInput;
    } // end readString()=======================================================


    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as a short
     * @return The user input value
     */
    //==========================================================================
    public static short readShort()
    {
        short returnValue = 0;
        createInput();//Sets up Scanner object
        try
        {
            String userInput = new String(input.nextLine());
            returnValue = (java.lang.Short.valueOf(userInput)).shortValue();
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as a short");
        }//end catch

        return returnValue;
    } // end readShort()========================================================

    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as an int
     * @return The user input value
     */
    //==========================================================================
    public static int readInt()
    {
        int returnValue = 0;
        createInput();//Sets up Scanner object
        try
        {
            String userInput = new String(input.nextLine());
            returnValue = new Integer(userInput).intValue();
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as an int");
            e.printStackTrace();
        }//end catch

        return returnValue;
    } // end readInt()==========================================================

    //==========================================================================
    /**
     *  Reads input from the keyboard or file and returns it as a float
     * @return The user input value
     */
    //==========================================================================
    public static float readFloat()
    {
        float returnValue = 0;
        createInput();//Sets up Scanner object
        try
        {
            String userInput = new String(input.nextLine());
            returnValue = (java.lang.Float.valueOf(userInput)).floatValue();
        }//end try
        catch(Exception e) {
            System.out.println("Exception while reading user's input as a " +
                    "float");
            e.printStackTrace();
        }//end catch

        return returnValue;
    } // end readFloat()========================================================


    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as a double
     * @return The user input value
     */
    //==========================================================================
    public static double readDouble()
    {
        double returnValue = 0;
        createInput();//Sets up Scanner object
        try
        {
            String userInput = new String(input.nextLine());
            returnValue = (java.lang.Double.valueOf(userInput)).doubleValue();
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as a " +
                    "double");
        }//end catch

        return returnValue;
    } // end readDouble()=======================================================



    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as a long
     * @return The user input value
     */
    //==========================================================================
    public static long readLong()
    {
        long returnValue = 0;
        createInput();//Sets up Scanner object
        try
        {
            String userInput = new String(input.nextLine());
            returnValue = (java.lang.Long.valueOf(userInput)).longValue();
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as a " +
                    "long");
        }//end catch

        return returnValue;
    } // end readLong()=========================================================


    //==========================================================================
    /**
     * Reads input from the keyboard or file and returns it as a boolean
     * @return the user input value
     */
    //==========================================================================
    public static boolean readBoolean()
    {
        boolean returnValue = false;
        createInput();//Sets up Scanner object
        try
        {
            String userInput = new String(input.nextLine());
            returnValue = (java.lang.Boolean.valueOf(userInput)).booleanValue();
        }//end try
        catch(Exception e)
        {
            System.out.println("Exception while reading user's input as a" +
                    "boolean");
        }//end catch

        return returnValue;
    } // end readLong()=========================================================


    //==========================================================================
    /**
     * Formats an int and returns it as a String.
     * @param number The int number to be formated.
     * @param align The number of spaces to place before the value.
     * 0 is minimum left aligned. 20 is maximum.<br>
     * @return
     */
    //==========================================================================
    public static String formatInt (int number, int align)
    {
        DecimalFormat N = new DecimalFormat();
        String spaces = "                    ";
        N.setGroupingUsed(false);
        N.setMaximumFractionDigits(0);
        String num = N.format(number);
        if (align < 0) // true implies left-justify
        {
            if (num.length() < -align)
            {
                // add trailing spaces
                num = num + spaces.substring(0,-align-num.length());
            }//end if
        }//end if
        else
        {
            if (num.length() < align)
                num = spaces.substring(0,align-num.length()) + num;
        }//end else
        return num;
    }//end formatInt ===========================================================


    //============================================================================
    /**
     * Reformats a double data type and returns  it as a String.
     * @return The double value represented as formated String output
     * @param frac the number of decimal places after the point.
     * @param align The number of spaces to place before the value.
     * 0 is minimum left aligned. 20 is maximum.<br>
     * @param number The double value to be formated.
     */
    //============================================================================
    public static String formatDouble (double number, int align, int frac)
    {
        DecimalFormat N = new DecimalFormat();
        String spaces = "                    ";

        N.setGroupingUsed(false);
        N.setMaximumFractionDigits(frac);
        N.setMinimumFractionDigits(frac);
        String num = N.format(number);
        if (align < 0) // true implies left-justify
        {
            if (num.length() < -align)
            {
                // add trailing spaces
                num = num + spaces.substring(0,-align-num.length());
            }
        }
        else
        {
            if (num.length() < align)
                num = spaces.substring(0,align-num.length()) + num;
        }
        return num;
    }//end formatDouble===========================================================


    //============================================================================
    /**
     * Reformats a float data type and returns  it as a String.
     * @return The double value represented as formated String output
     * @param frac the number of decimal places after the point.
     * @param align The number of spaces to place before the value.
     * 0 is minimum left aligned. 20 is maximum.<br>
     * @param number The float value to be formated.
     */
    //============================================================================
    public static String formatFloat (float number, int align, int frac)
    {
        DecimalFormat N = new DecimalFormat();
        String spaces = "                    ";

        N.setGroupingUsed(false);
        N.setMaximumFractionDigits(frac);
        N.setMinimumFractionDigits(frac);
        String num = N.format(number);
        if (align < 0) // true implies left-justify
        {
            if (num.length() < -align)
            {
                // add trailing spaces
                num = num + spaces.substring(0,-align-num.length());
            }
        }
        else
        {
            if (num.length() < align)
                num = spaces.substring(0,align-num.length()) + num;
        }
        return num;
    }//end formatDouble===========================================================


    //===========================================================================
    /**
     * Opens the specified text file for input. This allows redirects input,
     * allowing the read commands to read from a file rather than the keyboard.
     * <br>
     * When the <b>closeInputFile</b>< method is caled the keyboard input can
     * then again be used with the various read methods.
     * @param fileName The name and location of the file, i.e.
     * c://folder/file.txt
     * @throws IOException Thrown when a IO exception happens.
     * @see closeInputFile()
     */
    //===========================================================================
    public static void openInputFile(String fileName)
    {
        try
        {
            if (fileInput != null)
                fileInput = null;

            if (input != null)
                input = null;

            fileInput = new File(fileName);
            input = new Scanner(fileInput);//Sets up Scanner object
        }//end try
        catch (IOException e)
        {
            System.out.println("There was an error opening the input file.");
            e.printStackTrace();
        }//end if


    }//===========================================================================

    //============================================================================
    /**
     * Closes the input from the text file. Once closed the input methods then can
     *  return to reading in from the keyboard.
     *  @see openInputFile(String fileName)
     */
    //============================================================================
    public static void closeInputFile ()
    {
        input.close();
        input = null;
    }//===========================================================================


    //============================================================================
    /**
     * Opens the specified file for output.
     * @param name The file name
     * @throws IOException Thrown when an error occours.
     */
    //============================================================================
    public static void openOutputFile(String name)
    {
        try
        {
            outputFile = new File(name);
            fw= new FileWriter(outputFile);
            pw = new PrintWriter(fw);
        }//end if
        catch (IOException e)
        {
            System.out.println("There was an error opening the output file.");
            e.printStackTrace();
        }//end if
    }//===========================================================================

    //============================================================================
    /**
     * Use this to close the output file and return the print methods from file
     * printing to screen printing.
     * @throws IOException
     */
    //============================================================================
    public static void closeOutputFile ()
    {
        try
        {
            fw.close();
            pw.close();
            outputFile = null;
            pw = null;
            fw = null;
        }//end try
        catch (IOException e)
        {
            System.out.println("There was an error closing the output file.");
            e.printStackTrace();
        }//end if
    }//===========================================================================


    //##########################################################################
    // main class, used to test the various methods
    //##########################################################################
    public static void main(String[] argv)
    {
     /*
        //##############################################################
        //print data to the screen using Println
        //##############################################################
         println("===== READ INPUT FROM KEYBOARD AND OUTPUT TO SCREEN TEST ======");
         prompt("Enter int: ");
         int tempint = readInt();
         println("Read int: " + tempint);

         prompt("Enter double: ");
         double tempdouble = readDouble();
         println("Read double: " + tempdouble);

         prompt("Enter char: ");
         char tempchar = readChar();
         println("Read char: " + tempchar);

         prompt("Enter String: ");
         String tempString = readString();
         println("Read String: " + tempString);

         prompt("Enter short: ");
         short tempshort = readShort();
         println("Read short: " + tempshort);

         prompt("Enter long: ");
         long templong = readLong();
         println("Read long: " + templong);

         prompt("Enter float: ");
         float tempfloat = readFloat();
         println("Read float: " + tempfloat);

         prompt("Enter boolean: ");
         boolean tempBoolean = readBoolean();
         println ("read boolean: " + tempBoolean);


         //#############################################################
         //Create a new file and redirect print and println to new file
         //#############################################################
         println("===== READ INPUT FROM KEYBOARD AND OUTPUT TO FILE TEST ======");

        //Create file for output and redirect print and println to file
        openOutputFile("test1.txt");

        //output data to the  file.
        prompt("Enter int: ");
        int tempint1 = readInt();
        println(tempint1);

        prompt("Enter double: ");
        double tempdouble1 = readDouble();
        println(tempdouble1);

        prompt("Enter char: ");
        char tempchar1 = readChar();
        println(tempchar1);

        prompt("Enter String: ");
        String tempString1 = readString();
        println(tempString1);

        prompt("Enter short: ");
        short tempshort1 = readShort();
        println(tempshort1);

        prompt("Enter long: ");
        long templong1 = readLong();
        println(templong1);

        prompt("Enter float: ");
        float tempfloat1 = readFloat();
        println(tempfloat1);

        prompt("Enter boolean: ");
        boolean tempBoolean1 = readBoolean();
        println(tempBoolean1);

        closeOutputFile();//redirect println output back to the screen
      /*
        //##############################################################
        //Read data from the input file and store in the computer
        //##############################################################
        println("===== READ INPUT FROM FILE AND OUTPUT TO SCREEN TEST ======");

        openInputFile("test1.txt");

        int tempInt2 = readInt();
        println("Int from file: " + tempInt2);

        double tempDouble2 = readDouble();
        println("double from file: " + tempDouble2);

        char tempChar2 = readChar();
        println("char from file: " + tempChar2);

        String tempString2 = readString();
        println("String from file: " + tempString2);

        short tempShort2 = readShort();
        println("short from file: " + tempShort2);

        long tempLong2 = readLong();
        println("long from file: " + tempLong2);

        float tempFloat2 = readFloat();
        println("float from file: " + tempFloat2);

        boolean tempBoolean2 = readBoolean();
        println("boolean from file: " + tempBoolean2);

       //close input file and redirect input back to the keyboard
        closeInputFile();
        */


    } // end main()


} // end class
