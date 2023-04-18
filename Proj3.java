import java.util.*;

public class Proj3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String enteredText;

        //Prompts the user to enter input. Ends the program if the user enters "stop"
        while (true) {
            System.out.print("Enter your input, be sure to use delimiters properly. If you want to exit the program, enter 'stop': ");
            enteredText = input.nextLine();
            
            if (enteredText.equalsIgnoreCase("stop")) {
                System.out.println("Exiting...");
                break;
            }
            
            //Message displayed depending on if the delimiters are balanced or not
            if (checkDelimiters(enteredText)) {
                System.out.println("The delimiters you entered were balanced.");
            } else {
                System.out.println("The delimiters you entered were not balanced.");
            }
        }
    }
    
    //Creation of method to check if delimiters were used properly
    public static boolean checkDelimiters(String enteredText) {
        Stack<Character> stack = new Stack<>();
        for (char c : enteredText.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
