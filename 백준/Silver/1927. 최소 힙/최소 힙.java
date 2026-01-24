import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> q = new PriorityQueue<>();;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {

            int now = Integer.parseInt(br.readLine());

            if(now != 0) {
                q.offer(now);

            } else {

                if(!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }

        }
    }
}