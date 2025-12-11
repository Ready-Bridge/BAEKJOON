import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        ArrayList<Integer> people = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= arr.length; i++){
            if(arr[i - 1] == 'P') {
                people.add(i);
            } else {
                stack.add(i);
            }
        }

        Collections.sort(people, Collections.reverseOrder());

        int cnt = 0;
        int ptr = 0;

        while(ptr < people.size()){

            if(stack.isEmpty()){
                break;
            }

            if(Math.abs(stack.peek() - people.get(ptr)) <= K) {
                cnt++;
                ptr++;
                stack.pop();
            } else if(stack.peek() > people.get(ptr)) {
                stack.pop();
            } else {
                ptr++;
            }
        }

        System.out.println(cnt);
    }
}