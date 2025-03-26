import java.util.Scanner;

public class MatchNegativeCharacterGroups {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].equals("-E")) {
            System.out.println("Example Usage: echo -n \"apple123\" | java MatchNegativeCharacterGroups -E \"[^abc]\" \necho $?\n");
            System.exit(1);
        }

        String pattern = args[1];
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        System.err.println("Program logs will appear here.");

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
        } else if("\\w".equals(pattern)) {
//            return inputLine.matches(".*\\w.*");
            for(int i = 0; i < pattern.length(); i++) {
                if(Character.isAlphabetic(inputLine.charAt(i)))
                    return true;
            }
            return false;
        } else if(pattern.startsWith("[^") && pattern.endsWith("]")) {
            String subStr = pattern.substring(2, pattern.length()-1);
            for(int i = 0; i < inputLine.length(); i++) {
                if(subStr.indexOf(inputLine.charAt(i)) != -1)
                    return false;
            }
            return true;
        } else {
            throw new RuntimeException("Unhandled pattern: " + pattern);
        }
    }
}