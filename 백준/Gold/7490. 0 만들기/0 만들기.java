import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int calculate(String expression) {

        // 공백 제거
        expression = expression.replaceAll("\\s+", "");

        // -, + 로 split (기호는 유지)

        String[] values = expression.split("(?<=[+-])|(?=[+-])");


        // -, + 만나면 연산
        int sum = Integer.parseInt(values[0]);
        int pre = sum;

        for(int i = 1; i < values.length; i++) {
            if(values[i].equals("+")) {
                sum += Integer.parseInt(values[++i]);
            } else if(values[i].equals("-")) {
                sum -= Integer.parseInt(values[++i]);
            }
        }

        return sum;
    }


    static void dfs(int value, int N, String expression, ArrayList<String> list) {
        if(value >= N) {
            if(calculate(expression) == 0) {
                list.add(expression);
            }

            return;
        }

        dfs(value + 1, N, expression + " " + (value + 1), list);
        dfs(value + 1, N, expression + "+" + (value + 1), list);
        dfs(value + 1, N, expression + "-" + (value + 1), list);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> result = new ArrayList<>();

            dfs(1, N, "1",result);

            for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }

            System.out.println();
        }

    }
}