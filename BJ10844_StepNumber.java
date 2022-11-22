package complete;

import java.util.Scanner;

//계산수
public class StepNumber {
	public static void main(String[] args) {
		int N;
	    long cnt=0, mod = 1000000000;
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		long[][] arr = new long[N+1][10]; //N번째 자리에 0~9 숫자가 들어갈 경우의 수
		
		//첫번째 자리에 들어갈 수 있는 경우의 수는 한개 1~9
		arr[1][0] = 0;
		for (int i=1; i<10; i++) {
			arr[1][i] = 1;
		}
		
		//i번째 지리수가 0일때는 1, 9일때는 8만 가능
		for (int i=2; i<N+1; i++) {
			for (int j=0; j<10; j++) {
				if (j==0) {
					arr[i][0] = arr[i-1][1]% mod;
				}else if(j==9) {
					arr[i][9] = arr[i-1][8]% mod;
				}else {
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1])% mod;
				}
			}
		}
       
		for (int i=0; i<10; i++) {
			cnt += arr[N][i];
		}
		
		System.out.println(cnt%mod);
		input.close();
	}
}


