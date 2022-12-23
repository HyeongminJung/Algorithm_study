package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Bipartite_Graph {
	static int V, E;
	static Node[] nodes;
	static boolean[] visited;
	static boolean ans;
	
	static class Node{
		int idx;
		boolean color;
		// 연결된 리스트_간선
		LinkedList<Node> child = new LinkedList<>(); 
		
		public Node(int idx) {
			this.idx = idx;
		}
		public void setColor(boolean color) {
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int v, w;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
			
		int K = Integer.parseInt(br.readLine());
		
		while (K--!=0) {
			StringTokenizer s = new StringTokenizer(br.readLine());		
			V = Integer.parseInt(s.nextToken()); // 정점
			E = Integer.parseInt(s.nextToken()); // 간선
			
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
			
			boolean ans = true;
			//비연결 그래프를 고려하기 위해 모든 정점을 확인해야 함
			
			for(int i = 1; i<=V; i++) {
				if (!visited[i]) {
					visited[i]=true;
					nodes[i].setColor(true);
					//BFS
//					if(!BFS(i)) {
//						ans = false; 
//						break;
//					}
					
					//DFS
					DFS(i);
					if(!ans) {
						break;
					}
				}
			}	
			sb.append(ans?"YES":"NO").append('\n');
		}
		System.out.println(sb);
	}
	
	static boolean BFS(int idx) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(nodes[idx]);

		while (!queue.isEmpty()) {
			Node node=queue.poll();
			if(check(node)) {
				return false;
			}else {		
			    for (Node c : node.child) {		    	
			        if (!visited[c.idx]) { 
				        visited[c.idx] = true;
				        // 연결된 이전 정점과 다른 색으로 설정 
				        c.setColor(!node.color);
				        queue.add(c);
				    }
			    }
			}
		}
		return true;
	}
	static void DFS(int idx) {
		if(check(nodes[idx])) {
			ans = false;
			return;
		}else {		
		    for (Node c : nodes[idx].child) {		    	
		        if (visited[c.idx]) { continue;}
		        
			    visited[c.idx] = true;
			    c.setColor(!nodes[idx].color);
			    DFS(c.idx);
		    }
		}
	}
	static boolean check(Node node) {
		for (Node n : node.child) {
			//방문한 적 있고 연결된 정점의 색이 같은 경우 true(이분리스트x)
			if(visited[n.idx] && n.color == node.color) {
				return true;
			}
		}
		return false;
	}
}
