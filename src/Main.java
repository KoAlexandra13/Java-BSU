import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> allLines = new ArrayList<String>();
        List<String> rightLines = new ArrayList<String>();
        Function.fileReader(allLines,"input.txt");
        for (String buf : allLines) {
            if (Function.test(buf))
                rightLines.add(buf);
        }
        Function.fileWriter(rightLines,"output.txt");
    }
}
