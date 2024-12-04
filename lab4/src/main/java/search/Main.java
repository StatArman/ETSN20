package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Not enough arguments!\nUsage: search <pattern> <file>");
            System.exit(1);
        }
        if (!"search".equals(args[0])) {
            return;
        }
        Pattern regex = Pattern.compile(args[1]);
        try {
            String filetext = Files.readString(Path.of(args[2]));
            filetext.lines().filter(regex.asPredicate()).forEachOrdered(System.out::println);
        } catch (IOException e) {
            System.err.println("File " + args[2] + " could not be found.");
            System.exit(1);
        }
    }
}
