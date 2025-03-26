import java.util.Scanner;

public class MatchPositiveCharacterGroups {
    public static void main (String[] args) {
        if(args.length != 2 || !args[0].equals("-E")) {
            System.out.println("Example Usage: echo -n \"apple123\" | java Main -E \"[abc]\" \necho $?\n");
            System.exit(1);
        }

        String pattern = args[1];
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        System.err.println("Logs from your program will appear here!");

        if(matchPattern(inputLine, pattern))
            System.exit(0);
        else
            System.exit(1);
    }

    public static boolean matchPattern(String inputLine, String pattern) {
        if("\\d".equals(pattern)) {
            for(int i = 0; i < inputLine.length(); i++) {
                if(Character.isDigit(inputLine.charAt(i)))
                    return true;
            }
            return false;
        } else if ("\\w".equals(pattern)) {
//            return inputLine.matches(".*\\w.*");

//            OR CAN ALSO DO THIS:
            for(int i = 0; i < inputLine.length(); i++) {
                if(Character.isAlphabetic(inputLine.charAt(i))) {
//                    System.err.println("Iterating till pattern.length().");
                    return true;
                }
            }
            return false;

        } else if (pattern.startsWith("[") && pattern.endsWith("]")) {
            String subStr = pattern.substring(1, pattern.length()-1);
            for(int i = 0; i < inputLine.length(); i++) {
                if (subStr.indexOf(inputLine.charAt(i)) != -1)
                    return true;
            }
            return false;
        } else if (pattern.length() == 1)
            return inputLine.contains(pattern);
        else
            throw new RuntimeException ("Unhandled pattern: " + pattern);
    }
}
