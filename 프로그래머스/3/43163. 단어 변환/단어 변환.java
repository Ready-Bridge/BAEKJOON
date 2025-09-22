import java.util.*;

class Solution {

    private List<String> getNext(String current, String[] words, boolean[] visited) {
        List<String> nextList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneCharDiff(current, words[i])) {
                nextList.add(words[i]);
                visited[i] = true; // 방문 처리
            }
        }

        return nextList;
    }

    private boolean isOneCharDiff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return cnt == 1;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 레벨 크기
            for (int s = 0; s < size; s++) {
                String current = q.poll();
                if (current.equals(target)) return answer;

                List<String> nextWords = getNext(current, words, visited);
                for (String next : nextWords) {
                    q.offer(next);
                }
            }
            answer++; // 한 단계 끝나면 answer 증가
        }

        return 0; // 변환 불가
    }
}
