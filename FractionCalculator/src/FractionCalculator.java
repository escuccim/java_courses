import java.util.Scanner;

public class FractionCalculator {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        char operation = ' ';

        while(operation != 'q' && operation != 'Q'){
            operation = getOperation();
            if(operation != 'q' && operation != 'Q'){
                System.out.println("You entered " + operation);

                Fraction fraction1 = getFraction();
                Fraction fraction2 = getFraction();
                Fraction result = new Fraction();

                if(operation == '+'){
                    result = fraction1.add(fraction2);
                    printResult(fraction1, fraction2, result, operation);
                } else if(operation == '-'){
                    result = fraction1.subtract(fraction2);
                    printResult(fraction1, fraction2, result, operation);
                } else if(operation == '*'){
                    result = fraction1.multiply(fraction2);
                    printResult(fraction1, fraction2, result, operation);
                } else if(operation == '/'){
                    result = fraction1.divide(fraction2);
                    printResult(fraction1, fraction2, result, operation);
                } else if(operation == '='){
                    System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " = " + fraction1.equals(fraction2));
                }
            }
        }
    }

    public static void printResult(Fraction fraction1, Fraction fraction2, Fraction result, char operation){
        System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " = " + result.toString());
    }

    public static boolean isNumber(String str){
        return str.replaceAll("[0-9]","").length() == 0;
    }

    public static Fraction getFraction(){
        boolean valid_fraction = false;
        while(!valid_fraction) {
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String number = input.next();

            // if there is a "/" split and create the fraction
            int index = number.indexOf('/');
            if(index > 0){
                String[] parts = number.split("/");

                // make sure that there are no more than two parts
                if(parts.length == 2){
                    if(isNumber(parts[0]) && isNumber(parts[1])){
                        valid_fraction = true;
                        Fraction fraction = new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

                        return fraction;
                    }
                }
            }
            // else if there is no "/" all chars should be numbers and this is an int
            else if (isNumber(number)){
                    Fraction fraction = new Fraction(Integer.parseInt(number));
                    valid_fraction = true;
                    return fraction;
            }
        }

        // this is just here to avoid compile errors, it should never actually be executed
        Fraction fraction = new Fraction();
        return fraction;
    }

    public static char getOperation(){
        char operator = ' ';

        while(operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '=' && operator != 'q' && operator != 'Q') {
            System.out.print("Please enter an operation (+, -, *, /, = or Q to quit) ");
            String operation = input.next();

            operator = operation.charAt(0);
        }

        return operator;
    }
}
