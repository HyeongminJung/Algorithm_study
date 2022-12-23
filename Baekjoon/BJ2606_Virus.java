package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Virus {
	static int V, E;
	static Node[] nodes;
	static boolean[] visited;
	static int count=0;
	
	static class Node{
		int idx;
		LinkedList<Node> child = new LinkedList<>(); 
		
		public Node(int idx) {
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int v, w;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
				
		V = Integer.parseInt(br.readLine()); // 정점
		E = Integer.parseInt(br.readLine()); // 간선
		
		nodes = new Node[V+1];
		visited = new boolean[V+1];
		for(int i=0; i<=V; i++) {
			nodes[i]=new Node(i);
		}

		for (int i=0; i<E; i++) {
			StringTokenizer vw = new StringTokenizer(br.readLine());
			v = Integer.parseInt(vw.nextToken());
			w = Integer.parseInt(vw.nextToken());

			nodes[v].child.add(nodes[w]);
			nodes[w].child.add(nodes[v]);
		}
		
		visited[1]=true;
		DFS(1);
			
		System.out.println(count);
	}
	
	static void DFS(int idx) {
	    for (Node c : nodes[idx].child) {		    	
	        if (visited[c.idx]) { continue;}	        
		    visited[c.idx] = true;
		    count++;
		    DFS(c.idx);
	    }
	}

}