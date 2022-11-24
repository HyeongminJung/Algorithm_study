package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 1000-Integer.parseInt(br.readLine());
		int[] change = { 500, 100, 50, 10, 5, 1 };
		int cnt=0;
		
		for(int i : change) {
			if (c/i > 0) {
				cnt += c / i;
				c = c % i;
			}
			i++;
		}
		System.out.println(cnt);
	}
}
