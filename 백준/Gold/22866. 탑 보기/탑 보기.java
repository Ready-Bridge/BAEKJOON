import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        Stack<int[]> stack = new Stack<>();

        // 왼쪽 확인
        for(int i = 0; i < N; i++){
            if(stack.isEmpty()){
                left.add(new int[] {0, 100_000_000});
                stack.push(new int[] {i + 1, arr[i]});
            } else {
                while(!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                    stack.pop();
                }

                left.add(new int[] {stack.size(), stack.isEmpty() ? 100_000_000 : stack.peek()[0]});
                stack.push(new int[] {i + 1, arr[i]});
            }
        }

        stack.clear();

        // 오른쪽 확인
        for(int i = N - 1; i >= 0; i--){
            if(stack.isEmpty()){
                right.add(new int[] {0, 100_000_000});
                stack.push(new int[] {i + 1, arr[i]});
            } else {
                while(!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                    stack.pop();
                }

                right.add(new int[] {stack.size(), stack.isEmpty() ? 100_000_000 : stack.peek()[0]});
                stack.push(new int[] {i + 1, arr[i]});
            }
        }

        Collections.reverse(right);

        StringBuilder sb = new StringBuilder();

        // 결과 출력
        for(int i = 0; i < N; i++){
            int[] leftArr = left.get(i);
            int[] rightArr = right.get(i);

            if(leftArr[0] + rightArr[0] == 0) {
                sb.append(0 + "\n");
            } else {
                sb.append((leftArr[0] + rightArr[0]) + " ");

                if(Math.abs(i + 1 - leftArr[1]) <= Math.abs(i + 1 - rightArr[1])){
                    sb.append(leftArr[1] + "\n");
                } else {
                    sb.append(rightArr[1] + "\n");
                }
            }
        }

        System.out.print(sb.toString());

    }
}