import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/home/nadia/IdeaProjects/ekz2-updated/src/main/resources/Test.txt"));
        String fullText = "";
        while (sc.hasNextLine()) {
            String oneStr = sc.nextLine();
            fullText = fullText + oneStr;
        }
        List<String> arr = Arrays.asList(fullText.split("\\."));
        return arr;
    }
}
