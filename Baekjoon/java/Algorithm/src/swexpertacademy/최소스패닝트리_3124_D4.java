package swexpertacademy;

import java.io.*;
import java.util.*;

public class 최소스패닝트리_3124_D4{
	static int V,E; 
	static int[] parents;
	static Edges[] edges;
	
	public static class Edges implements Comparable<Edges>{
		int from, to, weight;

		public Edges(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edges o) {
			return Integer.compare(this.weight,o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new Edges[E];
			parents = new int[V+1];
		
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				edges[i] = new Edges(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edges);
			make();
			
			long result = 0;
			int cnt = 0;
			
			for (int i = 0; i < edges.length; i++) {
				if(union(edges[i].from, edges[i].to)){
					result += edges[i].weight;
					cnt+=1;
				}
				if(cnt == V-1) break;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = Math.min(aRoot, bRoot);
		parents[bRoot] = Math.min(aRoot, bRoot);
		
		return true;
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void make() {
		for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
	}
}