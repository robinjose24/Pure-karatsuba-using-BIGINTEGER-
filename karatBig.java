import java.util.Scanner;
import java.math.BigInteger;

public class karatBig {

    // Helper function to compute powers of 10 safely
    public static BigInteger powerOf10(int exp) {
        return BigInteger.TEN.pow(exp);
    }

    // Karatsuba multiplication
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        if (x.compareTo(BigInteger.TEN) < 0 || y.compareTo(BigInteger.TEN) < 0) {
            return x.multiply(y);
        }

        int size = Math.max(x.toString().length(), y.toString().length());
        int half = size / 2;

        BigInteger pow = powerOf10(half);

        BigInteger high1 = x.divide(pow);
        BigInteger low1 = x.mod(pow);
        BigInteger high2 = y.divide(pow);
        BigInteger low2 = y.mod(pow);

        BigInteger z0 = karatsuba(low1, low2);
        BigInteger z1 = karatsuba(low1.add(high1), low2.add(high2));
        BigInteger z2 = karatsuba(high1, high2);

        return (z2.multiply(powerOf10(2 * half)))
                .add((z1.subtract(z2).subtract(z0)).multiply(pow))
                .add(z0);
    }

    // Normal multiplication
    public static BigInteger normalMulti(BigInteger x, BigInteger y) {
    String num1 = x.toString();
    String num2 = y.toString();
    
    int m = num1.length();
    int n = num2.length();
    int[] result = new int[m + n];

    for (int i = m - 1; i >= 0; i--) {
        int digit1 = num1.charAt(i) - '0';
        for (int j = n - 1; j >= 0; j--) {
            int digit2 = num2.charAt(j) - '0';
            int mul = digit1 * digit2;
            int sum = mul + result[i + j + 1];
            
            result[i + j + 1] = sum % 10;
            result[i + j] += sum / 10;
        }
    }

    // Convert result array to string
    StringBuilder sb = new StringBuilder();
    for (int num : result) {
        if (sb.length() == 0 && num == 0) continue; // skip leading zeros
        sb.append(num);
    }

    return sb.length() == 0 ? BigInteger.ZERO : new BigInteger(sb.toString());
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger num1 = new BigInteger(sc.nextLine());
        BigInteger num2 = new BigInteger(sc.nextLine());

        // Karatsuba
        long startTime = System.nanoTime();
        BigInteger result = karatsuba(num1, num2);
        long endTime = System.nanoTime();
        double milliduration = (endTime - startTime) / 1_000_000.0;

        // Normal Multiply
        long startTime2 = System.nanoTime();
        BigInteger result2 = normalMulti(num1, num2);
        long endTime2 = System.nanoTime();
        double milliduration2 = (endTime2 - startTime2) / 1_000_000.0;

        System.out.println();

        // karatsuba multi
        System.out.println("Karatsuba Multiply Result:");
        System.out.println(result);
        System.out.println("Time taken: " + milliduration + " milliseconds");

        System.out.println();

        // normal multi
        System.out.println("Normal Multiply Result:");
        System.out.println(result2);
        System.out.println("Time taken: " + milliduration2 + " milliseconds");
    }
}
