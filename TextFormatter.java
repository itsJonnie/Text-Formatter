import java.util.Scanner;

public class TextFormatter {

    public static void main(String[] args) {
        System.out.println("Welcome to the simple text formatter.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line width: ");
        int lineWidth = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        System.out.print("Enter the text to be formatted:\n");
        String inputText = scanner.nextLine();
        System.out.print("Select a format: (L)eft-justified or, (R)ight-justified, or (Q)uit\n");
        String formatOption = scanner.nextLine().toUpperCase();

        while (!formatOption.equals("Q")) {
            if (formatOption.equals("L")) {
                leftJustify(inputText, lineWidth);
            } else if (formatOption.equals("R")) {
                rightJustify(inputText, lineWidth);
            } else {
                System.out.println("Invalid format option, please try again.");
            }

            System.out.print("Select a format: (L)eft-justified or, (R)ight-justified, or (Q)uit\n");
            formatOption = scanner.nextLine().toUpperCase();
        }

        scanner.close();
        System.out.println("Exiting the text formatter.");
    }

    public static void leftJustify(String inputText, int lineWidth) {
        String[] words = inputText.split("\\s+");
        int currentWidth = 0;
        for (String word : words) {
            if (currentWidth + word.length() + 1 > lineWidth) {
                System.out.print("\n");
                currentWidth = 0;
            }
            System.out.print(word + " ");
            currentWidth += word.length() + 1;
        }
        System.out.print("\n");
    }

    public static void rightJustify(String inputText, int lineWidth) {
        String[] words = inputText.split("\\s+");
        int currentWidth = 0;
        for (String word : words) {
            if (currentWidth + word.length() + 1 > lineWidth) {
                System.out.print("\n");
                currentWidth = 0;
            }
            currentWidth += word.length() + 1;
        }

        currentWidth = 0;
        for (String word : words) {
            if (currentWidth + word.length() + 1 > lineWidth) {
                System.out.print("\n");
                currentWidth = 0;
            }
            int padding = lineWidth - currentWidth - word.length();
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            System.out.print(word + " ");
            currentWidth += word.length() + 1;
        }
        System.out.print("\n");
    }
}

