import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x좌표는 순서대로 들어오므로 저장만 함
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];

            // 현재 높이가 스택의 top보다 낮아지면, 
            // 스택에 있던 더 높은 건물들은 확정적으로 끝난 것임
            while (!stack.isEmpty() && stack.peek() > currentHeight) {
                ans++;
                stack.pop();
            }

            // 현재 높이가 0이 아니고, 스택이 비어있거나 top보다 높다면 새로운 건물 시작
            if (currentHeight > 0) {
                if (stack.isEmpty() || stack.peek() < currentHeight) {
                    stack.push(currentHeight);
                }
            }
        }

        // 반복문이 끝난 후 스택에 남아있는 높이들은 아직 종료되지 않은 건물들
        ans += stack.size();

        System.out.println(ans);
    }
}