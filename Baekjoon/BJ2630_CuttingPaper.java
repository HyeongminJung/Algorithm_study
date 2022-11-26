package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingPaper {
	static int white = 0;
	static int blue = 0;
	static int[][] unit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		unit = new int[N][N];
		StringTokenizer split;
		
		for(int i=0; i<N; i++) {
			split = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				unit[i][j] = Integer.parseInt(split.nextToken());
			}
		}
		partition(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}
	
	static void partition(int row, int col, int size) {
		if(CheckColor(row, col, size)==2) {
			partition(row, col, size/2);
			partition(row, col+size/2, size/2);
			partition(row+size/2, col, size/2);
			partition(row+size/2, col+size/2, size/2);
		}else if(CheckColor(row, col, size)==0) {
			white++; return;
		}else{
			blue++; return;
		}
	}

	//색이 다르면 3, white는 1, blue는 1 return
	static int CheckColor(int row, int col, int size) {
		int color = unit[row][col];
		for(int i=row; i<row+size; i++) {
			for (int j=col; j<col+size; j++) {
				if (unit[i][j] != color) {
					return 2;
				}
			}
		}
		return color;
	}
}
