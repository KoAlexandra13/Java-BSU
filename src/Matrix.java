import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Matrix {

    private int matrixSize;
    private Float[][] matrix;

    public Matrix(int n) throws ArrayIndexOutOfBoundsException {
       if (n < 0){ throw new ArrayIndexOutOfBoundsException("Exception, matrix size < 0!");}
        matrixSize = n;
        matrix = new Float [matrixSize][matrixSize];
    }

   public Matrix (){
        matrix = new Float [2][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0.f;
            }
        }
    }
   public Matrix (Float[][] matrix){
       this.matrixSize = matrix.length;
       this.matrix = Arrays.copyOf(matrix, matrixSize);
   }

    public void filling(){
        Random randNumber = new Random();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = randNumber.nextFloat() + 1;
            }
        }
    }
    public int size(){
        return matrixSize;
    }


    public final void outWithInDecimalFormat(){
        final String pattern = "%###,###.###";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        final String pattern2 = "¤###,###.###";
        DecimalFormat myFormatter2 = new DecimalFormat(pattern2);
        final String pattern3 = "";
        DecimalFormat myFormatter3 = new DecimalFormat(pattern3);
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                switch (i){
                    case(0):
                        String output = myFormatter.format(matrix[i][j]);
                        System.out.print(output + "\t");
                        break;
                    case(1):
                        String output2 = myFormatter2.format(matrix[i][j]);
                        System.out.print(output2 + "\t");
                        break;
                    default:
                        String output3 = myFormatter3.format(matrix[i][j]);
                        System.out.print(output3 + "\t");
                }
            }
            System.out.println();
        }
    }

    public final void out(){
        System.out.println(Arrays.deepToString(matrix));
    }

    public Float rowMultiply(int colonNumber){
        Float element = 1.f;
        for (int i = 0; i < matrixSize; i++) {
              element *= matrix[colonNumber][i];
        }
        return element;
    }
    public void getRowMultiply(){
        for (int i = 0; i < matrixSize; i++) {
            final String pattern = "";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            String output3 = myFormatter.format(rowMultiply(i));
            System.out.println("For row №" + (i+1) + ": " +output3);
        }
    }

    public Matrix newMatrix (Matrix matrix2) throws ArrayIndexOutOfBoundsException{
        if (matrix2.size() < matrixSize || matrix2.size() > matrixSize){
            throw new ArrayIndexOutOfBoundsException("Exception, matrix have different sizes!");}
            Float[][] matrix1 = new Float[matrixSize][matrixSize];
            matrix1 = Arrays.copyOf(matrix, matrixSize);
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                matrix1[j][i] += matrix2.rowMultiply(i);
                }
            }
            return new Matrix(matrix1);
        }
    public void rowCopy(int rowNumber, int from, int to){
        to++;
       Float[] array = Arrays.copyOfRange(matrix[rowNumber], from, to);
       System.out.println(Arrays.toString(array));
    }
    public void sort(int from, int to) throws ArrayIndexOutOfBoundsException{
        to++;
        if (to < 1 || to > matrixSize)throw new ArrayIndexOutOfBoundsException("'to' index out of Bounds!!!");
        if (from < 0 || from > matrixSize)throw new ArrayIndexOutOfBoundsException("'from' index out of bounds!!!");
        if (to < from) throw new ArrayIndexOutOfBoundsException("'to' index < 'from'  index!!!");
        Arrays.sort(matrix[0], from, to , new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2)
            {
                return -o1.compareTo(o2);
            }
        });
 }
}

