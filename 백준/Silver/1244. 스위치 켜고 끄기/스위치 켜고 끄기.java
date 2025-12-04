import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int student = Integer.parseInt(br.readLine());

        for(int i = 0; i < student; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 남학생이면
            if(gender == 1) {

                for(int k = number; k <= n; k += number) {
                    if(arr[k - 1] == 1) {
                        arr[k - 1] = 0;
                    } else {
                        arr[k - 1] = 1;
                    }
                }

            } else { // 여학생이면
                int start = number - 1;
                int end = number - 1;

                while(start > 0 && end < n - 1) {
                    if(arr[start - 1] == arr[end + 1]) {
                        start--;
                        end++;
                    } else {
                        break;
                    }
                }

                for(int k = start; k <= end; k++) {
                    if(arr[k] == 1) {
                        arr[k] = 0;
                    } else {
                        arr[k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            sb.append(arr[i]);
            sb.append(" ");
            cnt++;

            if(cnt % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}