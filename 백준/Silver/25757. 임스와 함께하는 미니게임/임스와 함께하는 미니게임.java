import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        int need = 0;

        switch(type) {
            case "Y" : 
                need = 1;
                break;
            case "F" : 
                need = 2;
                break;
            case "O" : 
                need = 3;
                break;
        }

        Set<String> set = new HashSet<>();

        for(int i = 1; i <= n; i++){
            set.add(br.readLine());
        }

        int answer = set.size() / need;

        System.out.println(answer);

    }
}
