import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int T, n;
    static int [] arr = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 0; i < T; i++) {
            n = sc.nextInt();
            System.out.println(find(n));
        }
    }

    private static int find(int n) {
        if(arr[n] != 0) {
            return arr[n];
        }

        arr[n] = find(n - 1) + find(n - 2) + find(n - 3);

        return arr[n];
    }
}
