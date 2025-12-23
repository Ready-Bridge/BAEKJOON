import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();

        char[] arr = new char[temp.length()];
        int cnt = 0;
        int answer = 1001;

        for(int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i);

            if(arr[i] == 'a') {
                cnt++;
            }
        }

        for(int i = 0; i < arr.length; i++) {

            int change = 0;

            for(int k = 0; k < cnt; k++) {
                if(arr[(i + k) % arr.length] == 'b') change++;
            }

            answer = Math.min(answer, change);
        }

        System.out.println(answer);
    }
}