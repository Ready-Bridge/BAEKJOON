import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int left = 0;
        int right = s.length() - 1;
        boolean isTrue = true;

        while(left <= right) {
            char leftS = s.charAt(left);
            char rightS = s.charAt(right);

            if(leftS != rightS) {
                isTrue = false;
                break;
            }

            left++;
            right--;
        }

        if(isTrue) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}