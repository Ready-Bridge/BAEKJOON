import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int num = 0;
        char[] arr = br.readLine().toCharArray();

        while(cnt < arr.length) {

            num++;

            String temp = String.valueOf(num);

            for(int i = 0; i < temp.length(); i++) {

                if(cnt == arr.length) break;

                if(temp.charAt(i) == arr[cnt]) {
                    cnt++;
                }
            }
        }

        System.out.println(num);

    }
}