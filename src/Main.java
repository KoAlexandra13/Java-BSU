import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Please, enter matrix size: ");
            int n = in.nextInt();
            Matrix matrix1 = new Matrix();
            try {
                matrix1 = new Matrix(n);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            matrix1.filling();
            System.out.println("\nMatrix 1: ");
            matrix1.out();

            Matrix matrix2 = new Matrix(0);
            try{
                matrix2 = new Matrix(n);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            matrix2.filling();
            System.out.println("\nMatrix 2: ");
            matrix2.out();

            System.out.println("\nMultiply: ");
            matrix2.getRowMultiply();

            try {
                System.out.println("\nNew matrix 1: ");
                matrix1.newMatrix(matrix2).out();
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }

            System.out.println("\nPlease, enter index 'from' and 'to' for sort and copy!");
            int i = in.nextInt();
            int j = in.nextInt();
            try {
                matrix1.sort(i, j);
                System.out.println("\nRow copy: ");
                matrix1.rowCopy(2, i, j);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }

            System.out.println("\nPrint with DecimalFormat: ");
            matrix1.outWithInDecimalFormat();
            in.close();


    }
}
