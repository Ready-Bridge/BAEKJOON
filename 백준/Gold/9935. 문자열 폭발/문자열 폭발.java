import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Stack<Character> stack;
    static char[] arr;
    static String explosion;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();

        arr = temp.toCharArray();
        stack = new Stack<>();

        explosion = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);

            if(sb.length() >= explosion.length()) {

                StringBuilder tempSb = new StringBuilder();

                for(int k = 0; k < explosion.length(); k++) {
                    tempSb.append(sb.charAt(sb.length() - 1 - k));
                }

                temp = tempSb.reverse().toString();

                if(temp.equals(explosion)) {
                    sb.setLength(sb.length() - explosion.length());
                }
            }
        }

        String answer = sb.toString();

        if(answer.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }
    }
}