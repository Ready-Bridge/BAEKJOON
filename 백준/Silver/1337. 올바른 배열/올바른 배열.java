import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> list;
    static int cnt = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int i = 0; i < N; i++) {
            cnt = 0;

            for(int k = 1; k < 5; k++) {
                // 값이 일치하면 cnt + 1을 해줌

                if(list.contains(list.get(i) + k)) {
                    cnt ++;
                }
            }

            if(cnt > max) {
                max = cnt;
            }
        }

        System.out.println(4 - max);
    }
}