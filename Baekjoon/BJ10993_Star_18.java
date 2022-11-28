package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Star_18 {
	static char[][] star;
	static boolean even;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		star = new char[row(N)][col(N)];
		for (int i=0; i<star.length; i++) {
			Arrays.fill(star[i],' ');
		}
		
		if (N%2==1) {
			Pattern(0 ,col(N)/2, N);
		}else {
			Pattern(row(N)-1 ,col(N)/2, N);
		}
		
		System.out.print(print(star, N));
		br.close();
	}
	
	static int row(int N){
		if(N==1) {return 1;}
		int r=1;
		for(int i=1; i<N; i++) {
			r = r*2+1;
		}
		return r;
	}
	static int col(int N){
		if(N==1) {return 1;}
		int c=1;
		for(int i=1; i<N; i++) {
			c = c*2+3;
		}
		return c;
	}

	static void Pattern(int row, int col, int N) {
		if (N%2==1) {
			if (N==1) {
				star[row][col] = '*';
				return;
			}
			
			star[row][col] = '*';
			for(int i=1; i<row(N)-1;i++) {
				star[row+i][col-i] = star[row+i][col+i] = '*';
			}
			for(int i=0; i<col(N);i++) {
				star[row+row(N)-1][i+col-col(N)/2] = '*';
			}
			
			Pattern(row+row(N)-2, col, N-1);
			return;
		}else{
			star[row][col] = '*';

			for(int i=1; i<row(N)-1;i++) {
				star[row-i][col-i] = star[row-i][col+i] = '*';
			}
			for(int i=col-col(N)/2; i<col+col(N)/2+1; i++) {
				star[row-row(N)+1][i] = '*';
			}
			
			Pattern(row-row(N)+2, col, N-1);
			return;
		}	
	}
	
	static StringBuilder print(char[][] star, int N) {
		StringBuilder sb = new StringBuilder();
		
		if(N%2==1) {
			for (int i = 0; i < star.length; i++) {
				for (int j = 0; j < star[0].length/2+i+1; j++) {
					sb.append(star[i][j]);
				}
				sb.append('\n');
			}
		}else {
			for (int i = 0; i < star.length; i++) {
				for (int j = 0; j < star[0].length-i; j++) {
					sb.append(star[i][j]);
				}
				sb.append('\n');
			}
		}

		return sb;
	}
}
