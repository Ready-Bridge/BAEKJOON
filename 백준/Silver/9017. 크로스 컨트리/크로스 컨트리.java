import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {

            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= N; i++) {
                int key = Integer.parseInt(st.nextToken());

                if(!map.containsKey(key)) {
                    map.put(key , new ArrayList<>());
                    map.get(key).add(i);
                } else {
                    map.get(key).add(i);
                }
            }

            ArrayList<int[]> resultList = new ArrayList<>();
            ArrayList<int[]> scoreList = new ArrayList<>();

            for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                if(entry.getValue().size() == 6) {

                    for(int i : entry.getValue()) {
                        scoreList.add(new int[]{entry.getKey(), i});
                    }
                }
            }

            HashMap<Integer, ArrayList<Integer>> resultMap = new HashMap<>();

            Collections.sort(scoreList, (o1 , o2) -> o1[1] - o2[1]);

            for(int i = 0; i < scoreList.size(); i++) {

                int key = scoreList.get(i)[0];

                if(!resultMap.containsKey(key)) {
                    resultMap.put(key , new ArrayList<>());
                    resultMap.get(key).add(i + 1);
                } else {
                    resultMap.get(key).add(i + 1);
                }
            }

            for(Map.Entry<Integer, ArrayList<Integer>> entry : resultMap.entrySet()) {
                int sum = 0;
                int five = 0;
                int six = 0;
                ArrayList<Integer> list = entry.getValue();

                for(int i = 0; i < 4; i++) {
                    sum += list.get(i);
                }

                five = list.get(4);
                six = list.get(5);

                resultList.add(new int[]{entry.getKey(), sum, five, six});
            }

            Collections.sort(resultList, (o1, o2) -> {
                if(o1[1] == o2[1]) {
                    if(o1[2] == o2[2]) {
                        return o1[3] - o2[3];
                    }

                    return o1[2] - o2[2];
                }

                return o1[1] - o2[1];
            });

            System.out.println(resultList.get(0)[0]);

        }

    }
}