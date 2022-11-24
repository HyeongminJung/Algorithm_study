package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AssignedRoom {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int act[][] = new int[N][2];
		StringTokenizer split;
		
		for(int i=0; i<N; i++) {
			split = new StringTokenizer(br.readLine(), " ");
			act[i][0] = Integer.parseInt(split.nextToken());
			act[i][1] = Integer.parseInt(split.nextToken());
		}
		
		//종료시간 오름차순 -> 시작시간 오름차순
		Arrays.sort(act, new Comparator<int[]>(){
		    @Override
		    public int compare(int[] o1, int[] o2) {
		        return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
		    }
		});
		
		int nextstart = 0, cnt=0; 
		for(int i=0; i<N; i++) {
			if (act[i][0] >= nextstart) {
				nextstart = act[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
