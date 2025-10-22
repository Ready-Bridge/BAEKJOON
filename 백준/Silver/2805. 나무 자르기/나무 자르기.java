import java.io.*;
import java.util.*;

// 이분 탐색하면서 현재 중간 값을 잘랐을때 나오는 값 x 현재 인덱스로 비교

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = br.readLine().split(" ");
        int[] trees = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(trees);

        int max = trees[trees.length - 1];
        int min = 0;

        while(max > min) {
            int mid = (max + min) / 2; // 중간값을 찾음
            long sum = 0;

            for(int tree : trees) {
                if(tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if(sum >= m) { // 나무 길이 충분하면 더 높은 범위에서 자른 상황을 탐색해봐야함
                min = mid + 1;
            } else { // 나무 길이 모자르면 자르는 범위를 더 낮춰야함
                max = mid;
            }
        }

        System.out.println(min - 1);

    }
}