package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Tomato {
	static int N, M;
	static int[][] box;
	static LinkedList<int[]> queue = new LinkedList<int[]>();
			
	public static void main(String[] args) throws IOException {
		StringTokenizer str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		StringTokenizer s = new StringTokenizer(br.readLine());
		M = Integer.parseInt(s.nextToken()); // 가로
		N = Integer.parseInt(s.nextToken()); // 세로
		box = new int[N+1][M+1];	
		
		for (int i=1; i<=N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j=1; j<=M; j++) {				
				box[i][j]=Integer.parseInt(str.nextToken());
				if(box[i][j]==1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		agingDate();
		System.out.println(count());
	}
	
	static int count() {
		int m = 0;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {	
				if(box[i][j]==0) {return -1;}
				if(box[i][j]>m) { m = box[i][j]; }
			}
		}
		return m-1;

	}
	
	static void agingDate() {		
		int nx, ny;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};

		while (!queue.isEmpty()) {
			int[] xy = queue.pollFirst();
			int x = xy[0];
			int y = xy[1];

			for (int i=0; i<4; i++) {
			    nx = x +dx[i];
			    ny = y +dy[i];
			    if (nx<1 || nx>N || ny<1 || ny>M) continue;
			    if (box[nx][ny]==0){ 
			        box[nx][ny] = box[x][y]+1;
			        queue.add(new int[] {nx, ny});
			    }
			}
		}
	}
	
}
