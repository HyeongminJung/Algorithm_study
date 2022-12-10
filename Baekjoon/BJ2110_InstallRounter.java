package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallRounter {
	static int[] home;
	static int N, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N  = Integer.parseInt(st.nextToken());
		c  = Integer.parseInt(st.nextToken());
		
		home = new int[N];
		for(int i = 0; i<N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		
		int high = home[N-1] - home[0] + 1;
		System.out.println(distance(high, 1));
		
		br.close();
	}
	static int house(int d) {	
		int cnt = 1, next;
		int start = home[0];
		
		for(int i=1; i<N; i++) {
			next = home[i];
			
			if(next-start >= d) {
				cnt++;
				start = next;
			}
		}
		return cnt;
	}
	
	static int distance(int high, int low) {
		int mid = (high+low)/2;
		if(low >= high) {
			return low-1;
		}
		//house(d)는 공유기 개수
		if(house(mid) < c) {
			return distance(mid, low);
		}else {
			return distance(high, mid+1);
		}
	}
}
