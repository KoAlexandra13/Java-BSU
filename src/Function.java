import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {

    public static boolean test(String testString){
        Pattern p = Pattern.compile("^([0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12})$|" +
                "(^\\{[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}})$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static void fileWriter (List<String> lines, String fileName) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false)))
        {
            writer.write("Right lines: "+ System.lineSeparator());
            for (String buf : lines)
                writer.write(buf + System.lineSeparator());
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void fileReader(List<String> listToLines, String fileName){
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            while ((line = reader.readLine()) != null) {
                listToLines.add(line);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}