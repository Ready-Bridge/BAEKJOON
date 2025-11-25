import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){

            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];

            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> list = new ArrayList<>();

            for(int number : arr) {

                int len = list.size();
                list.add(number);

                Collections.sort(list);
                int pos = list.indexOf(number);

                cnt += (len - pos);
            }

            System.out.println(n + " " + cnt);

        }

    }
}
