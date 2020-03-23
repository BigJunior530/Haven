import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class inputTester {

    public static boolean stage1 = true;
    public static boolean stage2 = true;
    public static boolean stage3 = true;
    public static boolean stage4 = true;
    public static String message = "Input some certain number here";

    public static Scanner input;
    public static File template;
    public static void main(String[] args) {

        //  Links a file to read from and connects a Scanner to it
        template = new File("input.txt");
        try{
            input = new Scanner(template);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file" + template.getName());
            return;
        }

        System.out.println("\n_______________________________________\n");
        System.out.println("Testing numbers");
        checkInts();

        System.out.println("________________________________________\n");
        System.out.println("Testing strings");
        checkStrings();


        //  Links a file to read from and connects a Scanner to it
        template = new File("input02.txt");
        try{
            input = new Scanner(template);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file" + template.getName());
            return;
        }

        stage1 = true;
        stage2 = true;
        stage3 = true;
        stage4 = true;
        System.out.println("\n_______________________________________");
        System.out.println("Testing numbers\n");
        checkInts();

        System.out.println("________________________________________\n");
        System.out.println("Testing strings");
        checkStrings();


        input.close();
    }

    /**
     * Method returns a String whether the boolean passed is true or not.
     * @param arg Is the boolean to be checked.
     * @return A String to be output to a Sysout.
     */
    public static String ifTrue(boolean arg){
        if(arg){
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    /**
     * Method checks 2 lines from input.txt and passes them to inputVerification.java
     */
    public static void checkInts(){
        try {
            inputVerification.verifyInt(input, message);
        } catch (Exception e){
            System.out.println("Stage one 1 fault: " + e.getMessage());
            stage1 = false;
        }
        System.out.println("Stage 1: " + ifTrue(stage1));

        try {
            inputVerification.verifyInt(input);
        } catch (Exception e){
            System.out.println("Stage one 2 fault: " + e.fillInStackTrace());
            stage2 = false;
        }
        System.out.println("Stage 2: " + ifTrue(stage2));
    }

    /**
     * Method checks 2 lines from input.txt and passes them to inputVerification.java
     */
    public static void checkStrings(){
        try {
            inputVerification.verifyString(input, message);
        } catch (Exception e){
            System.out.println("Stage 3 fault: " + e.getMessage());
            stage3 = false;
        }
        System.out.println("Stage 3: " + ifTrue(stage3));

        try{
            inputVerification.verifyString(input);
        } catch (Exception e) {
            System.out.println("Stage 4 fault: " + e.getMessage());
            stage4 = false;
        }
        System.out.println("Stage 4: " + ifTrue(stage4));
    }

    
}