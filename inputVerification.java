import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class purpose is to make sure player input is consistent with what the game asks
 * through a series of tests to ensure that input is either an Integer or String.
 * All methods MUST be passed a Scanner in order to input information.
 */
public class inputVerification {

    public static int VERIFY_INT_CONST = -1;
    public static String VERIFY_STRING_CONST = "";
    public Scanner input;

    /**
     * Method will call another helper method to verify the player.
     * Method will verify the input of the player for integers. MUST have player input be positive integers. 
     * MUST accept the argument of a prompt to ask the player. Example: "Guess a number between 1-100".
     * @param input Is a Scanner that the method MUST accept in order to receive information.
     * @return Will ultimately return either a -1 or the verified input that the player gave.
     */
    public static int verifyInt(Scanner input){
        int temp = -1;
        while(VERIFY_INT_CONST == -1){
            verifyIntHelper(input);
        }
        temp = VERIFY_INT_CONST;
        VERIFY_INT_CONST = -1;
        return temp;
    }


    /**
     * Method will call another helper method to verify the player input for integers.
     * Method will verify the input of the player for integers. MUST have player input be positive integers. 
     * MUST accept the argument of a prompt to ask the player. Example: "Guess a number between 1-100".
     * @param input Is a Scanner that the method MUST accept in order to receive information.
     * @param message Is a String that is displayed to the player as a prompt.
     * @return Will ultimately return either a -1 or the verified input that the player gave.
     */
    public static int verifyInt(Scanner input, String message){
        int temp = -1;
        while(VERIFY_INT_CONST == -1){
            System.out.println(message);
            verifyIntHelper(input);
        }
        temp = VERIFY_INT_CONST;
        VERIFY_INT_CONST = -1;
        return temp;
    }

    /**
     * Method will verify the input of the player for integers. MUST have player input be positive integers. 
     * MUST accept the argument of a prompt to ask the player. Example: "Guess a number between 1-100". 
     * @param input Is a Scanner that the method MUST accept in order to receive information.
     * @throws IndexOutOfBoundsException If the player input an integer below 0.
     * @return Will either return a -1 if the user input anything other than an integer or an integer below 0.
     */
    private static int verifyIntHelper(Scanner input){
        int response = VERIFY_INT_CONST;
        try{
           response = input.nextInt();
            if(response < 0){
                throw new IndexOutOfBoundsException("You input an integer below 0!");
            }
            VERIFY_INT_CONST = response; // Changes state of VERIF_INT_CONST
        } catch(NumberFormatException e) {
            System.out.println("Sorry, you entered in wrong input. Write only a number this time.\nTry again!\n");
        }
        return VERIFY_INT_CONST;
    }

    /**
     * Method will call another helper method to verify the player input for valid Strings.
     * Does not need a message to be passed as a parameter. 
     * Method will call another helper method to verify the player.
     * Method will verify the input of the player for integers. MUST have player input be positive integers. 
     * MUST accept the argument of a prompt to ask the player. Example: "Guess a number between 1-100".
     * @param input Is a Scanner that the method MUST accept in order to receive information.
     * @param message This is a message that is shown to the player of what kind of input is needed.
     * @return Will ultimately return either an empty String ("") or the verified String the player gave.
     */
    public static String verifyString(Scanner input, String message){
        String temp;
        System.out.println(message);
        while(VERIFY_STRING_CONST.equals("")){
            try{
                VERIFY_STRING_CONST = verifyStringHelper(input);
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        temp = VERIFY_STRING_CONST;
        VERIFY_STRING_CONST = "";
        return temp;
    }

    /**
     * Method will call another helper method to verify the player input for valid Strings.
     * Does not need a message to be passed as a parameter. 
     * Method will call another helper method to verify the player.
     * Method will verify the input of the player for integers. MUST have player input be positive integers. 
     * MUST accept the argument of a prompt to ask the player. Example: "Guess a number between 1-100".
     * @param input Is a Scanner that the method MUST accept in order to receive information.
     * @return Will ultimately return either a -1 or the verified input that the player gave.
     */
    public static String verifyString(Scanner input){
        String temp;
        while(VERIFY_STRING_CONST.equals("")){
            try{
                VERIFY_STRING_CONST = verifyStringHelper(input);
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        temp = VERIFY_STRING_CONST;
        VERIFY_STRING_CONST = "";
        return temp;
    }

    /**
     * Method will verify if the input the player gave does NOT have any numbers or more than one "." inside.
     * @param input Is a Scanner that the method MUST accept in order to receive information.
     * @throws InputMismatchException Will be thrown if the player inputs a number or more than one "." .
     * @return Will return the string the player gave.
     */
    private static String verifyStringHelper(Scanner input){
        String response = input.nextLine();
        String temp = "";
        // Needs to have a ParseInt test on this line
        if(!response.matches("^\\d+(\\.\\d+)?")){
            temp = response;
        } else{
            throw new InputMismatchException("Input contains a number and/or \".\"!\nTry again!\n");
        }
        return temp;
    }
}