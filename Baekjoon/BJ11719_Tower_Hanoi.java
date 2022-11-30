package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tower_Hanoi {	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		bw.write((int)(Math.pow(2, N)-1)+"\n");;
		Hanoi(N, 1, 3, 2);
		
		bw.flush();
		br.close();
	}
	
	static void Hanoi(int N, int start, int goal, int via) throws IOException {
		if (N==1) {
			bw.write(start+" "+goal+"\n");
			return;
		}else {
			Hanoi(N-1, start, via, goal);
			bw.write(start+" "+goal+"\n");
			Hanoi(N-1, via, goal, start);
		}
	}
}
