import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

class Row {
    private BigDecimal x;

    public Row (){}

    public Row (BigDecimal value) throws Exception {
        if (value.doubleValue() <= -1 || value.doubleValue() >= 1){
            throw new Exception("Exeption, please check \"x\" which you entered !!!");
        }
        this.x = value;
    }

    public BigDecimal rowSum (BigDecimal e, BigInteger k){
        BigDecimal sum = new BigDecimal("0");
        BigInteger n = BigInteger.ONE;
        BigDecimal row = new BigDecimal(n.multiply(n.add(BigInteger.ONE))).multiply(x.pow(n.add(BigInteger.ONE.negate()).intValue()).divide(BigDecimal.valueOf(2), k.add(BigInteger.ONE).intValue(), RoundingMode.HALF_EVEN));
        while (row.abs().compareTo(e) > 0){
            sum = sum.add(row);
            n = n.add(BigInteger.ONE);
            row = new BigDecimal(n.multiply(n.add(BigInteger.ONE))).multiply(x.pow(n.add(BigInteger.ONE.negate()).intValue()).divide(BigDecimal.valueOf(2), k.add(BigInteger.ONE).intValue(), RoundingMode.HALF_EVEN));
        }
        return new BigDecimal(sum.toString(), new MathContext(k.add(BigInteger.ONE).intValue()));
    }
    public BigDecimal standartFunc (BigInteger k){
        x = x.multiply(new BigDecimal(-1));
        BigDecimal sum = new BigDecimal(1/Math.pow(1+x.doubleValue(),3));
        return new BigDecimal(sum.toString(), new MathContext(k.add(BigInteger.ONE).intValue()));
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter \"k\": ");
        BigInteger k = in.nextBigInteger();

        System.out.print("Please, enter \"x\": ");
        BigDecimal x = in.nextBigDecimal();
        x = x.multiply( new BigDecimal(-1));
        try {
            Row myRow = new Row(x);
            in.close();
            BigDecimal dem = BigDecimal.TEN.pow(k.intValue());
            final BigDecimal EPSILON = new BigDecimal(1).divide(dem, k.intValue(), RoundingMode.HALF_EVEN);

            System.out.print("Received value: " + myRow.rowSum(EPSILON,k) + "\n");
            System.out.print("Correct value: " + myRow.standartFunc(k) + "\n");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}