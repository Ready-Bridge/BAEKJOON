import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();

        for(int i = N - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.add(new int[] {arr[i], i});
            } else {
                while(!stack.isEmpty()){
                    if(stack.peek()[0] <= arr[i]) {
                        answer[stack.pop()[1]] = i + 1;
                    } else {
                        break;
                    }
                }
                stack.add(new int[] {arr[i], i});
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}