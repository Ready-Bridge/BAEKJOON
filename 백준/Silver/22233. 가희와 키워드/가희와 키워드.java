import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        HashSet<String> set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(",");

            for(String s : arr) {
                if(set.contains(s)) {
                    set.remove(s);
                }
            }

            System.out.println(set.size());
        }
    }
}