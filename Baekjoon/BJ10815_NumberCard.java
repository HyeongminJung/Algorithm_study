package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {	
	static int[] sang;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());	
		StringTokenizer s1 = new StringTokenizer(br.readLine());
		sang = new int[N];
		for(int i = 0; i<N; i++) {
			sang[i] = Integer.parseInt(s1.nextToken());
		}
		Arrays.sort(sang);

		int M = Integer.parseInt(br.readLine());	
		StringTokenizer s2 = new StringTokenizer(br.readLine());
		int[] target = new int[M];
		for(int i = 0; i<M; i++) {
			target[i] = Integer.parseInt(s2.nextToken());
		}
			
		for(int m : target) {
			bw.write(BinarySearch(m, N-1, 0)+" ");
		}
		
		br.close();
		bw.flush();
	}
	static int BinarySearch(int target, int high, int low) {	
		int mid = (high+low)/2;
		if(sang[mid]!=target && high==low) {
			return 0;
		}
		
		if(sang[mid]==target) {
			return 1;
		}else if(sang[mid]>target) {
			return BinarySearch(target, mid, low);
		}else{
			return BinarySearch(target, high, mid+1);
		}
	}
}
