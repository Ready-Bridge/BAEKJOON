import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		int[] edgeCnt = new int[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			graph.get(first - 1).add(second);
			edgeCnt[second - 1] += 1;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			if(edgeCnt[i] == 0) {
				q.add(i + 1);
			}
		}
		
		while(!q.isEmpty()) {

			int problem = q.poll();
			answer.add(problem);
			
			ArrayList<Integer> linked = graph.get(problem - 1);
			
			for(int i = 0; i < linked.size(); i++) {
				edgeCnt[linked.get(i) - 1] -= 1;
				
				if(edgeCnt[linked.get(i) - 1] == 0) {
					q.add(linked.get(i));
				}
			}
			
			
		}
		
		
		
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i)+ " ");
		}
		
	}
}