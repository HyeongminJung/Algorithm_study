package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Maze {
	static int N, M;
	static int[][] maze;
	static LinkedList<Integer> queue = new LinkedList<Integer>();
			
	public static void main(String[] args) throws IOException {
		String str;
		String[] splitStr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken()); //행
		M = Integer.parseInt(s.nextToken()); //열

		maze = new int[N+1][M+1];
		for (int i=1; i<=N; i++) {
			str = br.readLine();
			splitStr = str.split("");

			for (int j=1; j<=M; j++) {				
				maze[i][j]=Integer.parseInt(splitStr[j-1]);
			}
		}
		
		SearchMaze(1, 1); 		
		System.out.println(maze[N][M]);

	}
	
	static void SearchMaze(int x, int y) {
		int nx, ny;
		//좌표값의 상하좌우 비교
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		
		queue.add(x);
		queue.add(y);

		while (!queue.isEmpty()) {
			x=queue.pollFirst();
			y=queue.pollFirst();

		    for (int i=0; i<4; i++) {
		    	nx = x +dx[i];
		    	ny = y +dy[i];
		        if (nx>=1 && nx<=N && ny>=1 && ny<=M ){ 
		        	if (maze[nx][ny]==1) {
		        		maze[nx][ny] += maze[x][y];
		        		queue.add(nx);
		        		queue.add(ny);
		        	}  
		        }
		    }
		}
	}
}