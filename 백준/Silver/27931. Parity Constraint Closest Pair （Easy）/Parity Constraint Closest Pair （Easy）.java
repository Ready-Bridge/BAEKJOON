import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp % 2 == 0) {
                evenList.add(temp);
            } else {
                oddList.add(temp);
            }
        }

        Collections.sort(evenList);
        Collections.sort(oddList);

        int even = Integer.MAX_VALUE;
        int odd = Integer.MAX_VALUE;

        for (int i = 1; i < evenList.size(); i++) {
            even = Math.min(even, evenList.get(i) - evenList.get(i - 1));
        }
        for (int i = 1; i < oddList.size(); i++) {
            even = Math.min(even, oddList.get(i) - oddList.get(i - 1));
        }

        int ePtr = 0;
        int oPtr = 0;

        while (ePtr < evenList.size() && oPtr < oddList.size()) {
            int eVal = evenList.get(ePtr);
            int oVal = oddList.get(oPtr);

            odd = Math.min(odd, Math.abs(eVal - oVal));

            if (eVal < oVal) {
                ePtr++;
            } else {
                oPtr++;
            }
        }

        if (even == Integer.MAX_VALUE) even = -1;
        if (odd == Integer.MAX_VALUE) odd = -1;

        System.out.println(even + " " + odd);
    }
}