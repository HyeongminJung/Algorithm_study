package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Hide_Seek {
	static final int max = 100000;
	static int N, K;
	static boolean[] visited;
	static LinkedList<Integer> queue = new LinkedList<Integer>();
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken()); // 언니 위치
		K = Integer.parseInt(s.nextToken()); // 동생 위치
		
		visited = new boolean[max+1];
		System.out.println(BFS(N));

	}
	
	static int BFS(int x) {
		int time=0;	
		visited[x] = true;
		queue.add(N);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i=0; i<size; i++) {
				x=queue.pollFirst();
		    	if (x==K) { return time; }
		    	if(x>0 && !visited[x-1]) {
		    		queue.add(x-1);
		    		visited[x-1]=true;
		    	}if(x<max && !visited[x+1]) {
		    		queue.add(x+1);
		    		visited[x+1]=true;
		    	}if(2*x<=max && !visited[2*x]) {
		    		queue.add(2*x);
		    		visited[2*x]=true;
		    	}
			}
			time++;	 
		}
		return -1;
	}
}