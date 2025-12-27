import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;

    static void dfs(String T, String S) {

        if(T.equals(S)) {
            answer = 1;
            return;
        }

        if(T.length() == 1) {
            return;
        }

        if(T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T);
            sb.deleteCharAt(0);
            sb.reverse();
            dfs(sb.toString(), S);
        }

        if(T.charAt(T.length() - 1) == 'A') {
            StringBuilder sb = new StringBuilder(T);
            sb.deleteCharAt(sb.length() - 1);
            dfs(sb.toString(), S);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        dfs(T, S);

        System.out.println(answer);
        
    }
}