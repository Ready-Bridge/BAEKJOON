import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static ArrayList<Integer> crain;
    static ArrayList<Integer> box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 크레인을 저장할 배열
        crain = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            crain.add(Integer.parseInt(st1.nextToken()));
        }

        m = Integer.parseInt(br.readLine());

        // 박스들을 저장할 배열
        box = new ArrayList<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st2.nextToken()));
        }

        // 두개의 배열 내림차순 정렬

        crain.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        // 박스의 가장 큰 크기가 가장 큰 크레인으로도 못 옮기면 -1 출력
        if (crain.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        while(!box.isEmpty()){
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    if (crain.get(i) >= box.get(k)) {
                        box.remove(k);
                        m -= 1;
                        break;
                    }
                }
            }
            ans ++;
        }
        System.out.println(ans);
    }
}