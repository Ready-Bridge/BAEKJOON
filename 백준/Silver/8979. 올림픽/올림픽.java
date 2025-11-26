import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken()) - 1;
        int[][] arr = new int[N][3];

        for(int i = 1; i <= N; i++){

            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken()) - 1;
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[idx][0] = gold;
            arr[idx][1] = silver;
            arr[idx][2] = bronze;
        }

        int targetGold = arr[target][0];
        int targetSilver = arr[target][1];
        int targetBronze = arr[target][2];
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            if(i == target) continue;

            if(targetGold > arr[i][0]) {
                cnt++;
            } else if(targetGold == arr[i][0]) {
                if(targetSilver > arr[i][1]) {
                    cnt++;
                } else if(targetSilver == arr[i][1]) {
                    if(targetBronze >= arr[i][2]) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(N - cnt);
    }
}