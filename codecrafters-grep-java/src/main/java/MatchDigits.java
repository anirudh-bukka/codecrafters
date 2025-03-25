import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatchDigits {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].equals("-E")) {
            System.out.println("Example Usage: echo -n \"apple123\" | java Main -E <pattern> \necho $?\n");
            System.exit(1);
        }

        String pattern = args[1];
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        System.err.println("Logs from your program will appear here!");

        Pattern compiledPattern = Pattern.compile(pattern);

        if (matchPattern(inputLine, compiledPattern)) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

    public static boolean matchPattern(String inputLine, Pattern compiledPattern) {
        Matcher matcher = compiledPattern.matcher(inputLine);
        return matcher.find();
    }
}