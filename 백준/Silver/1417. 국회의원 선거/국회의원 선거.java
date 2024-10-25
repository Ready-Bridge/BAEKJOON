import java.io.*;
import java.util.*;

public class Main {

    static int cnt = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n = 다솜이를 제외한 후보 수
        int n = Integer.parseInt(br.readLine());
        n -= 1;

        // 다솜이의 첫 득표수
        int dasom = Integer.parseInt(br.readLine());

        // 다솜이를 제외한 나머지 후보들의 득표수 (다솜이보다 득표수가 적은 사람은 제외)
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if(tmp >= dasom) {
                arr.add(tmp);
            }
        }

        if(arr.isEmpty()) {
            System.out.println(0);
        } else {

            int compare = arr.indexOf(Collections.max(arr));

            while(true) {

                if(dasom > arr.get(compare)) {
                    System.out.println(cnt);
                    break;
                } else {
                    dasom += 1;
                    arr.set(compare, arr.get(compare) - 1);
                    cnt += 1;
                    compare = arr.indexOf(Collections.max(arr));
                }
            }
        }
    }
}