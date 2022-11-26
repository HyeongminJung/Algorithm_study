package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star_10 {
	static char[][] star;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		star = new char[N][N];

		Pattern(0, 0, N, false);
		
		System.out.println(print(star));
		br.close();
	}
	
	static void Pattern(int row, int col, int size, boolean blank) {
		if (blank) {
			blank(row, col, size);
			return;
		}
		
		if (size==1) {
			star[row][col] = '*';
			return;
		}
		
		int cnt=0;
		int newsize = size/3;
		for(int i=row; i<row+size; i+=newsize) {
			for(int j=col; j<col+size; j+=newsize) {
				if(cnt==4) {
					Pattern(i, j, newsize, true);
				}else {
					Pattern(i, j, newsize, false);
				}
				cnt++;
			}
		}
	}
	
	static void blank(int row, int col,int size) {
		for(int i=row; i<size+row; i++) {
			for(int j=col; j<size+col; j++) {
				star[i][j]=' ';
			}
		}
	}
	
	static StringBuilder print(char[][] star) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star.length; j++) {
				sb.append(star[i][j]);
			}
			sb.append('\n');
		}
		return sb;
	}
}
