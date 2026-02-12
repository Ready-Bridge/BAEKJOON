import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int S = 0;

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String operation = st.nextToken();

            if(operation.equals("all")) {
                S = (1 << 21) - 1;
            } else if(operation.equals("empty")) {
                S = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());

                if(operation.equals("add")) {
                    S |= (1 << num);
                } else if(operation.equals("remove")) {
                    S &= ~(1 << num);
                } else if(operation.equals("check")) {

                    sb.append((S & (1 << num)) != 0 ? 1 : 0);
                    sb.append("\n");

                } else if(operation.equals("toggle")) {
                    S ^= (1 << num);
                }
            }
        }

        System.out.println(sb);
    }
}