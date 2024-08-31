import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger answer = BigInteger.ZERO;  // BigInteger로 변경

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long result = find(n).mod(BigInteger.valueOf(10007)).longValue();  // BigInteger 결과를 long으로 변환

        System.out.println(result);
    }

    public static BigInteger find(int n) {
        answer = BigInteger.ZERO;  // answer 초기화

        // 짝수일 경우
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2 - 1; i++) {
                answer = answer.add(combination(n - i, i));  // BigInteger 덧셈
            }

            return answer.add(BigInteger.valueOf(2));  // + 2
        }
        // 홀수일 경우
        else {
            for (int i = 1; i <= n / 2; i++) {
                answer = answer.add(combination(n - i, i));  // BigInteger 덧셈
            }

            return answer.add(BigInteger.ONE);  // + 1
        }
    }

    public static BigInteger combination(int n, int k) {
        BigInteger result = BigInteger.ONE;
        BigInteger divide = BigInteger.ONE;

        if (n - k < k) {
            k = n - k;
        }

        for (int i = n; i >= (n - k + 1); i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        for (int i = 1; i <= k; i++) {
            divide = divide.multiply(BigInteger.valueOf(i));
        }

        return result.divide(divide);
    }
}
