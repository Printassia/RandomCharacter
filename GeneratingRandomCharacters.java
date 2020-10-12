package Horsy.com.company.Ch06;

public class GeneratingRandomCharacters {
    /** Generate a random character between ch1 and ch2 */
    public static char getRandomCharacter(char ch1, char ch2){
        return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    /** Generate a random lowercase letter */
    public static char getRandomLowerCaseLetter(){
        return getRandomCharacter('a' , 'z');
    }

    /** Generate a random uppercase letter */
    public static char getRandomUpperCaseLetter(){
        return getRandomCharacter('A', 'Z');
    }

    /**Generate a random digit character */
    public static char getRandomDigitCharacter(){
        return getRandomCharacter('0', '9');
    }

    /**Generate a random character */
    public static char getRandomCharacter(){
        return getRandomCharacter('\u0000', '\uFFFF');
    }

    public static void main(String[] args) {
        int number = 3;
        //Display output n(number) times
        while (number > 0) {
            System.out.println("A random lowercase letter: "
                    + getRandomLowerCaseLetter());

            System.out.println("A random uppercase letter: "
                    + getRandomUpperCaseLetter());

            System.out.println("A random digit character: "
                    + getRandomDigitCharacter());

            System.out.println("A random character: "
                    + getRandomCharacter());

            //Decrease the number of loops
            number--;
            //Put a space between each set
            System.out.println();
        }
    }
}
