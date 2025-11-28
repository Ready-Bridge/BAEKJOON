import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            boolean hasVowel = false;  // 모음 포함 여부
            boolean valid = true;      // 규칙 위반 여부

            int vowelCnt = 0;
            int consCnt = 0;
            char prev = ' ';

            for (char c : s.toCharArray()) {
                boolean isVowel = "aeiou".indexOf(c) >= 0;

                // 1) 모음 포함 확인
                if (isVowel) hasVowel = true;

                // 2) 모음/자음 연속 체크
                if (isVowel) {
                    vowelCnt++;
                    consCnt = 0;
                } else {
                    consCnt++;
                    vowelCnt = 0;
                }
                if (vowelCnt == 3 || consCnt == 3) valid = false;

                // 3) 같은 글자 연속 (ee, oo는 허용)
                if (prev == c && c != 'e' && c != 'o') valid = false;

                prev = c;
            }

            // 모음이 하나도 없으면 실패
            if (!hasVowel) valid = false;

            if (valid)
                System.out.println("<" + s + "> is acceptable.");
            else
                System.out.println("<" + s + "> is not acceptable.");
        }
    }
}
