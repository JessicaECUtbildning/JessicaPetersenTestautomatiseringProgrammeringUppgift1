package morseCodeTranslator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        Scanner scan = new Scanner(System.in);
        String menu = """
                1. Text to Morse Code
                2. Morse Code to Text
                0. Exit""";

        System.out.println("MORSE CODE TRANSLATOR\n-- --- .-. ... . / -.-. --- -.. . / - .-. .- -. ... .-.. .- - --- .-." +
                "\nSelect one of the following options:\n" + menu);

        boolean exit = false;
        while (!exit) {
            try {
                switch (Integer.parseInt(scan.nextLine().trim())) {
                    case 1:
                        System.out.print("\nEnter text to translate: ");
                        System.out.println("Translation: " + translator.getMorse(scan.nextLine()) + "\n");
                        System.out.println("What do you want to do next?\n" + menu);
                        break;
                    case 2:
                        System.out.print("""
                                Type your Morse Code using dots (.) and dashes (-)
                                Use single space to separate characters and double space to separate words
                                \nEnter Morse Code to translate:\s""");
                        System.out.println("Translation: " + translator.getText(scan.nextLine()) + "\n");
                        System.out.println("What do you want to do next?\n" + menu);
                        break;
                    case 0:
                        System.out.println("EXITING\n. -..- .. - .. -. --.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid selection. Please enter 1, 2 or 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please enter 1, 2 or 0.");
            }
        }
    }
}