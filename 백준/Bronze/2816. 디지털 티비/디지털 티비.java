import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int pos = 0; // 화살표
        int k1 = 0;
        int k2 = 0;

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();

            if(temp.equals("KBS1")) {
                arr[i] = 1;
                k1 = i;
            } else if(temp.equals("KBS2")) {
                arr[i] = 2;
                k2 = i;
            } else {
                arr[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(k1 < k2) {

            for(int i = 0; i < k1; i++) {
                sb.append(1);
                pos++;
            }

            for(int i = pos; i > 0; i--) {
                sb.append(4);
                pos--;
            }

            for(int i = pos; i < k2; i++) {
                sb.append(1);
                pos++;
            }

            for(int i = pos; i > 1; i--) {
                sb.append(4);
                pos--;
            }

        } else if(k1 > k2) {

            for(int i = 0; i < k1; i++) {
                sb.append(1);
                pos++;
            }

            for(int i = pos; i > 0; i--) {
                sb.append(4);
                pos--;
            }

            k2++;

            for(int i = 0; i < k2; i++) {
                sb.append(1);
                pos++;
            }

            for(int i = pos; i > 1; i--) {
                sb.append(4);
                pos--;
            }
        }

        System.out.println(sb.toString());
    }
}
