import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter your line: ");
        String line = String.format("%s", in.nextLine());
        System.out.println("\nPlease, enter your separator line: ");
        String separators = String.format("%s", in.nextLine());
        System.out.println("\nEnter, please, number for search index: ");
        Integer P = in.nextInt();
        in.close();
        StringTokenizer st = new StringTokenizer(line, separators);
        Integer[] tmpNumsArray = new Integer[st.countTokens()];
        String[] tmpWordArray = new String[st.countTokens()];
        Integer numCounter = 0;
        Integer wordCounter = 0;
        Integer pInd = null;
        Integer num = null;
        Integer pIndLen = null;

        while(st.hasMoreTokens()) {
            var val = st.nextToken();
            try {
                num = Integer.parseInt(val,8);
                tmpNumsArray[numCounter] = num;
                numCounter++;
            }
            catch (NumberFormatException e ) {
               if (!val.chars().allMatch( Character::isDigit )) {
                    tmpWordArray[wordCounter] = val;
                    wordCounter++;
                }

                if (val.equals(P.toString())) {
                    pInd = line.indexOf(val);
                    pIndLen = val.length();
                }
                continue;
            }

            if (val.equals(P.toString())) {
                pInd = line.indexOf(val);
                pIndLen = val.length();
            }
        }
        Integer[] numbArray = Arrays.copyOf(tmpNumsArray, numCounter);
        System.out.println("\nNumb array: ");
        for (Integer n : numbArray)
            System.out.println(n);
        String[]  wordArray = Arrays.copyOf(tmpWordArray, wordCounter);

        //P-index
        if (pInd != null)
            System.out.println("\nP - index in line: " + pInd);
        else
            System.out.println("\nThe P - number is not found in the entered line! ");

        //Not polyndromes
        System.out.println("\nLexemes that are not polyndromes:");
        for(String str : wordArray){
            if (!str.equals(new StringBuffer(str).reverse().toString())) {
                System.out.println(str);
            }
        }

        //Adding a random number to a string
        StringBuffer bufLine = new StringBuffer(line);
        Random randNumber = new Random();
        if (pInd != null)
            bufLine.insert(pInd + pIndLen,randNumber.nextInt(15));
        else
            bufLine.insert(bufLine.length()/2 ,randNumber.nextInt(15));

        //Substring removal
        Integer indexStart = null;
        Integer indexEnd = null;
        String digits = "1234567890";
        for (var substr : wordArray) {
            for (var digit : digits.toCharArray()) {
                if (substr.charAt(0) == digit) {
                    indexStart = bufLine.indexOf(substr);
                    indexEnd = indexStart + substr.length();
                    bufLine.delete(indexStart,indexEnd + 1);
                }
            }

        }
        if (indexStart == null && indexEnd == null)
            System.out.println("\nNo words starting with a digit in a line!");

        line = bufLine.toString();
        System.out.println("\nNew line: " + line);
    }

}
