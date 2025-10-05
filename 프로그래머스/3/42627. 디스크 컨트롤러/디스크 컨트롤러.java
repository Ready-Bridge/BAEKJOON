import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Integer[]> list = new ArrayList<>();
        int idx = 0;
        for (int[] arr : jobs) {
            list.add(new Integer[]{idx++, arr[0], arr[1]}); // idx, 요청시간, 소요시간
        }

        // 요청시간 기준으로 정렬
        Collections.sort(list, (a, b) -> a[1] - b[1]);

        // 소요시간 짧은 순서로 처리하는 우선순위 큐
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> {
            if (!a[2].equals(b[2])) return a[2] - b[2];
            if (!a[1].equals(b[1])) return a[1] - b[1];
            return a[0] - b[0];
        });

        int time = 0;
        int cnt = 0;
        int sum = 0;
        int done = 0;

        while (done < list.size()) {

            // 현재 시점까지 들어온 job들을 모두 큐에 넣음
            while (cnt < list.size() && list.get(cnt)[1] <= time) {
                pq.add(list.get(cnt++));
            }

            // 처리할 job이 없으면 다음 job의 시작 시점으로 시간 이동
            if (pq.isEmpty()) {
                time = list.get(cnt)[1];
                continue;
            }

            // 소요시간이 가장 짧은 job 수행
            Integer[] temp = pq.poll();
            time += temp[2];
            sum += (time - temp[1]);
            done++;
        }

        return sum / list.size();
    }
}
