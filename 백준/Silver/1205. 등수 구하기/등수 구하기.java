import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newNumber = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(1);
        } else {

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cntBig = 0;
            int cntSame = 0;

            for(int i = 0; i < N; i++) {
                if(newNumber < arr[i]) {
                    cntBig++;
                }

                if(newNumber <= arr[i]) {
                    cntSame++;
                }
            }

            if(cntSame == P) {
                System.out.println(-1);
            } else {
                if(cntBig >= P) {
                    System.out.println(-1);
                } else {
                    System.out.println(cntBig + 1);
                }
            }
        }
    }
}