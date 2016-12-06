import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.lang.Integer;

/**
 * Java program which matches the functionality of SRPN, which is a reverse polish notation calculator with the extra feature
 * that all arithmetic is saturated (when it reaches the maximum value that can be stored in a variable, it stays at the
 * maximum rather than wrapping around).
 *
 * @author Adam Jaamour
 * @version 1.0
 * @release 01/12/2015
 * @See SRPNRandom.java
 */

public class SRPN {
    public static void main(String[] args) throws IOException {

        long number_1;  //first number entered by the user
        long number_2;  //second number entered by the user
        SRPNRandom random = new SRPNRandom();   //object allowing us to use the method listSRPNRandom in our main method
        Stack<String> stack = new Stack<>();    //stack in which the input and calculation results are stored
        BufferedReader read_line = new BufferedReader(new InputStreamReader(System.in, "ascii"));

        while(true){

            String read = read_line.readLine();  //input

            /*
            * tries all the characters which have functions, and if none are recognised will print an error message
            * in the catch (line ...) saying the character is not recognized.
            */
            try{

                /**
                 * handles EOF
                 */
                if(read == null){
                    return;
                }

                /**
                 * If the character is a number (between 0 and 9) it will be analysed to check if it has to be treated as
                 * octal (if there is a 0 in front of it) or decimal, and it will also be analysed for saturation and
                 * stack overflow.
                 */
                for (String input: read.split("\\n+|\\s+")){    //splits the string if there is a return \\n or a white space \\s
                    if (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/") && !input.equals("%") && !input.equals("^") && !input.contains("#") && !input.equals("=") && !input.equals("d") && !input.equals("r") && !input.equals("rachid")){
                        boolean stackOverflow = stackOverflow(stack);
                        if (!stackOverflow){    //if stack overflow is false
                            long octal_number;
                            if (input.startsWith("0") || input.startsWith("-0")){   //checks if it is an octal number
                                if (input.contains("8") || input.contains("9")){
                                    break;  //ignores everything after the 8 and 9, which are not part of the octal numeral system
                                }
                                else if (Long.parseLong(input, 8) > Integer.MAX_VALUE){
                                    stack.push((String.valueOf(Integer.MAX_VALUE)));
                                }
                                else if (Long.parseLong(input, 8) < Integer.MIN_VALUE){
                                    stack.push(String.valueOf(Integer.MIN_VALUE));
                                }
                                else{
                                    octal_number = Long.parseLong(input, 8);
                                    stack.push(String.valueOf(octal_number));   //pushes the octal number to stack if it is not saturated
                                }
                            }
                            else{
                                if (Long.parseLong(input, 10) > Integer.MAX_VALUE){
                                    stack.push((String.valueOf(Integer.MAX_VALUE)));
                                }
                                else if (Long.parseLong(input, 10) < Integer.MIN_VALUE){
                                    stack.push(String.valueOf(Integer.MIN_VALUE));
                                }
                                else{
                                    stack.push(input);  //pushes decimal number to stack if it is not saturated
                                }
                            }
                        }
                        else{
                            System.err.println("Stack overflow.");  //prints a stack overflow error if the boolean value is true for the stackOverflow method
                        }
                    }

                    /**
                     * "Else if" statements for all calculations ('+', '-', '*', '/', '%', '^').
                     *
                     * Handles the calculations by checking if the boolean from the stackUnderflow method is true or false. If
                     * it is false, then there is no stack underflow and the operations are carried out by popping the two
                     * last number which have been entered as input by the user and pushing them back in the stack if they
                     * are between the max value and min value of integers such as -2147483648 < number < 2147483647. If they
                     * are not between these two values, then the max/min values are pushed back into the stack and will be printed
                     * to the screen when the "=" string is entered by the user (saturation), and if they are between these
                     * two values, then the result of the calculation is pushed back onto the stack and is printed. If the
                     * boolean is true, then there is a situation of stack underflow (empty stack) and an error is printed to
                     * the screen.
                     */
                    else if(input.equals("+")){ //addition
                        boolean stackUnderflow = stackUnderflow(stack);
                        if (!stackUnderflow){
                            input = stack.pop();
                            number_1 = Long.parseLong(input);
                            input = stack.pop();
                            number_2 = Long.parseLong(input);
                            if (number_2 + number_1 > Integer.MAX_VALUE){
                                stack.push((String.valueOf(Integer.MAX_VALUE)));
                            }
                            else if (number_2 + number_1 < Integer.MIN_VALUE){
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else{
                                stack.push(String.valueOf(number_2 + number_1));
                            }
                        }
                        else{
                            System.err.println("Stack underflow.");
                        }
                    }
                    else if(input.equals("-")){ //substraction
                        boolean stackUnderflow = stackUnderflow(stack);
                        if (!stackUnderflow){
                            input = stack.pop();
                            number_1 = Long.parseLong(input);
                            input = stack.pop();
                            number_2 = Long.parseLong(input);
                            if (number_2 - number_1 > Integer.MAX_VALUE){
                                stack.push((String.valueOf(Integer.MAX_VALUE)));
                            }
                            else if (number_2 - number_1 < Integer.MIN_VALUE){
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else{
                                stack.push(String.valueOf(number_2 - number_1));
                            }
                        }
                        else{
                            System.err.println("Stack underflow.");
                        }
                    }
                    else if(input.equals("*")){ //multiplication
                        boolean stackUnderflow = stackUnderflow(stack);
                        if (!stackUnderflow){
                            input = stack.pop();
                            number_1 = Long.parseLong(input);
                            input = stack.pop();
                            number_2 = Long.parseLong(input);
                            if (number_2 * number_1 > Integer.MAX_VALUE){
                                stack.push((String.valueOf(Integer.MAX_VALUE)));  //MAX_VALUE = 2147483647
                            }
                            else if (number_2 * number_1 < Integer.MIN_VALUE){
                                stack.push(String.valueOf(Integer.MIN_VALUE));  //MIN_VALUE = -2147483648
                            }
                            else{
                                stack.push(String.valueOf(number_2 * number_1));
                            }
                        }
                        else{
                            System.err.println("Stack underflow.");
                        }
                    }
                    else if(input.equals("/")){ //division
                        boolean stackUnderflow = stackUnderflow(stack);
                        if (!stackUnderflow){
                            input = stack.pop();
                            number_1 = Long.parseLong(input);
                            input = stack.pop();
                            number_2 = Long.parseLong(input);
                            if (number_1 !=0){  //checks if the divisor is not equal to 0 (which causes an error)
                                if (number_2 / number_1 > Integer.MAX_VALUE){
                                    stack.push((String.valueOf(Integer.MAX_VALUE)));  //2147483647
                                }
                                else if (number_2 / number_1 < Integer.MIN_VALUE){
                                    stack.push(String.valueOf(Integer.MIN_VALUE));
                                }
                                else{
                                    stack.push(String.valueOf(number_2 / number_1));
                                }
                            }
                            else{
                                System.err.println("Divide by 0."); //prints an error if the divisor is equal to 0
                            }
                        }
                        else{
                            System.err.println("Stack underflow.");
                        }
                    }
                    else if(input.equals("%")){ //modulo
                        boolean stackUnderflow = stackUnderflow(stack);
                        if (!stackUnderflow){
                            input = stack.pop();
                            number_1 = Long.parseLong(input);
                            input = stack.pop();
                            number_2 = Long.parseLong(input);
                            if (number_2 % number_1 > Integer.MAX_VALUE){
                                stack.push((String.valueOf(Integer.MAX_VALUE)));
                            }
                            else if (number_2 % number_1 < Integer.MIN_VALUE){
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else{
                                stack.push(String.valueOf(number_2 % number_1));
                            }
                        }
                        else{
                            System.err.println("Stack underflow.");
                        }
                    }
                    else if(input.equals("^")){ //power
                        boolean stackUnderflow = stackUnderflow(stack);
                        if (!stackUnderflow){
                            input = stack.pop();
                            number_1 = Long.parseLong(input);
                            input = stack.pop();
                            number_2 = Long.parseLong(input);
                            if (number_1 < 0){  //checks if the exponent is not inferior to 0 (which causes an error if it is)
                                System.err.println("Negative power.");  //if the the exponent is equal to 0 it prints an error
                                stack.push(String.valueOf(number_2));
                                stack.push(String.valueOf(number_1));
                            }
                            else{
                                if (number_2 / number_1 > Integer.MAX_VALUE){
                                    stack.push((String.valueOf(Integer.MAX_VALUE)));
                                }
                                else if (number_2 / number_1 < Integer.MIN_VALUE){
                                    stack.push(String.valueOf(Integer.MIN_VALUE));
                                }
                                else{
                                    stack.push(String.valueOf((int)Math.pow(number_2, number_1)));  //makes Math.pow return an int instead of a double
                                }
                            }
                        }
                        else{
                            System.err.println("Stack underflow.");
                        }
                    }


                    /**
                     * handles the printing of the result by popping the result of one of the previous calculations,
                     * and printing out the result only if the boolean from the stackOverflow method is false, meaning
                     * there is no stack overflow. If the boolean is true, then the result is not printed to the screen
                     * and a stack overflow error is printed to the screen instead.
                     */
                    else if(input.equals("=")){
                        String result = stack.pop();
                        boolean stackOverflow = stackOverflow(stack);
                        if(!stackOverflow){
                            System.out.println(result);
                            stack.push(result); //pushes back the result so the user can see the all the results when typing d
                        }
                        else{
                            System.err.println("Stack overflow.");
                        }
                    }


                    /**
                     *prints out the entire stack by looping though each of the stack elements and printing all of them.
                     */
                    else if(input.equals("d")){
                        for (String value : stack){
                            System.out.println(value);
                        }
                    }


                    /**
                     * Ignores everything after a '#'.
                     */
                    else if(input.contains("#")){
                        break;
                    }


                    /**
                     *Easter egg.
                     */
                    else if(input.equals("rachid")){
                        System.out.println("Rachid is the best unit lecturer.");
                    }


                    /**
                     *pushes one of the random number onto the stack, then pops it to check if there is a stack overflow
                     * using the boolean from the stackOverflow method. If the the boolean is true, then it prints a stack
                     * overflow error message, and if the boolean is false, it checks the random number for saturation
                     * (which is used when performing calculations on the random numbers) and pushes it back to the
                     * stack so it can be printed when typing d or =.
                     */
                    else if(input.equals("r")){
                        String current_random = Integer.toString(random.listSRPNRandom());
                        stack.push(current_random);
                        boolean stackOverflow = stackOverflow(stack);
                        if (!stackOverflow){
                            stack.pop();
                            if (Integer.parseInt(current_random) > Integer.MAX_VALUE){
                                stack.push((String.valueOf(Integer.MAX_VALUE)));  //2147483647
                            }
                            else if (Integer.parseInt(current_random) < Integer.MIN_VALUE){
                                stack.push(String.valueOf(Integer.MIN_VALUE));
                            }
                            else{
                                stack.push(current_random);
                            }
                        }
                        else{
                            System.err.println("Stack overflow.");
                        }
                    }
                }
            }
            /*
            code in the catch{} is run if none of the characters are recognised in the try{}
             */
            catch(Exception e){
                char quote = '"';
                System.err.println("Unrecognised operator or operand " + quote + read + quote + ".");
            }
        }
    }


    /**
     * Method which allows to check for stack underflow.
     *
     * @param stack
     * @return boolean true if stack is empty, boolean false if stack isn't empty.
     */
    public static boolean stackUnderflow(Stack stack){
        if (stack.size() <= 1){  //if stack = 0 or if stack = 1
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Method which allows to check for stack overflow.
     *
     * @param stack
     * @return boolean true if stack is full, boolean false if stack isn't full.
     */
    public static boolean stackOverflow(Stack stack){
        if (stack.size() >= 23){
            return true;
        }
        else{
            return false;
        }
    }
}