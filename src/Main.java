import java.util.Scanner;
import java.io.Console;

public class Main {
    public static class DiaryEntry {
        public static void main(String[] args) {
            // Create a Scanner object to read input from the terminal

            try (Scanner scanner = new Scanner(System.in)) {
                // Prompt the user to enter a string
                System.out.print("How was your day? ");

                // Read the entered string
                String inputString = scanner.nextLine();

                // Display the entered string
                System.out.println("Your answer: " + inputString);
            }

            Console console = System.console();

            if (console == null) {
                // Console is not available, handle it as needed
                System.out.println("Console is not available. Cannot securely read input.");
                return;
            }

            try {
                // Prompt the user to enter a password
                char[] passwordChars = console.readPassword("How was your day? ");

                try {
                    // Convert the char array to a String if needed
                    String entry = new String(passwordChars);

                    // Do something with the password (in this case, just printing it)
                    System.out.println("Your answer: " + entry);
                } finally {
                    // Clear the password from memory immediately after use
                    java.util.Arrays.fill(passwordChars, ' ');
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}