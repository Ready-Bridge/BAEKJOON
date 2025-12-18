import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int k = 0; k < N; k++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(list);

        System.out.println(list.get(list.size() - N));
        
    }
}