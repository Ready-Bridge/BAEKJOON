import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String originStr = br.readLine();
        int[] origin = new int[26];

        // 기준 문자열 알파벳 카운팅
        for(char c : originStr.toCharArray()) {
            origin[c - 'A']++;
        }

        int answer = 0;

        for(int i = 1; i < n; i++) {
            String compareStr = br.readLine();
            int[] compare = new int[26];

            // 비교 문자열 알파벳 카운팅
            for(char c : compareStr.toCharArray()) {
                compare[c - 'A']++;
            }

            int sameCnt = 0; // 같은 문자의 개수
            for(int j=0; j<26; j++) {
                // 두 단어 중 해당 알파벳 개수가 적은 쪽만큼이 겹치는(일치하는) 개수
                sameCnt += Math.min(origin[j], compare[j]);
            }

            // 1. 길이가 같을 때 (같은 구성 or 한 글자 교체)
            if(originStr.length() == compareStr.length()) {
                // 완전히 같거나(sameCnt == len), 한 글자만 다른 경우(sameCnt == len - 1)
                if(sameCnt == originStr.length() || sameCnt == originStr.length() - 1) {
                    answer++;
                }
            }
            // 2. 기준 문자열이 1글자 더 길 때 (한 글자 삭제해야 비슷해짐)
            // 겹치는 개수가 비교 문자열 전체와 같아야 함 (즉, 비교 문자열은 기준 문자열의 부분집합 꼴)
            else if (originStr.length() == compareStr.length() + 1) {
                if(sameCnt == compareStr.length()) {
                    answer++;
                }
            }
            // 3. 비교 문자열이 1글자 더 길 때 (한 글자 추가해야 비슷해짐)
            // 겹치는 개수가 기준 문자열 전체와 같아야 함
            else if (originStr.length() + 1 == compareStr.length()) {
                if(sameCnt == originStr.length()) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}