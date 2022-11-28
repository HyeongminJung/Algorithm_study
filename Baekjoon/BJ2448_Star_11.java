package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Star_11 {
	static char[][] star;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		star = new char[N][2*N-1];
		for (int i=0; i<N; i++) {
			Arrays.fill(star[i],' ');
		}
		
		Pattern(0, N-1, N);
		System.out.println(print(star));
		br.close();
	}
	
	static void Pattern(int row, int col, int N) {
		if (N==3) {
			star[row][col] = '*';
			star[row+1][col-1]=star[row+1][col+1]='*';
			for(int i=0; i<5; i++) {
				star[row+2][col-2+i]='*';
			}
			return;
		}
		Pattern(row, col, N/2);
		Pattern(row+N/2, col-N/2, N/2);
		Pattern(row+N/2, col+N/2, N/2);
	}
	
	static StringBuilder print(char[][] star) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[0].length; j++) {
				sb.append(star[i][j]);
			}
			sb.append('\n');
		}
		return sb;
	}
}
