import java.io.*;
import java.util.*;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		
		int v = 0;
		int weight = 0;
		
		Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			long answer = 0; 
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
				
			HashSet<Integer> visited = new HashSet<>();
			HashMap<Integer, ArrayList<Edge>> map = new HashMap<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				if(!map.containsKey(A)) {
					map.put(A,  new ArrayList<>());
				}
				
				if(!map.containsKey(B)) {
					map.put(B,  new ArrayList<>());
				}
								
				ArrayList<Edge> listA = map.get(A);
				ArrayList<Edge> listB = map.get(B);
				
				listA.add(new Edge(B, C));
				listB.add(new Edge(A, C));
			}
			
			PriorityQueue<Edge> q = new PriorityQueue<>();
			
			int start = map.keySet().iterator().next();
			q.add(new Edge(start, 0));
			
			while(!q.isEmpty()) {
				
				Edge edge = q.poll();
				
				int u = edge.v;
				int w = edge.weight;
				
				if(visited.contains(u)) continue;
				
				answer += w;
				visited.add(u);
				
				if(visited.size() == V) {
					break;
				}
				
				for(Edge next : map.get(u)) {
					if(!visited.contains(next.v)) {
						q.add(new Edge(next.v, next.weight));
					}
				}
				
			}
					
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}