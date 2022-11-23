package complete;

import java.util.Scanner;

public class AplusB_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b;
		int[] ans = new int[1000];
		int i=0; 
		
		while(true) {
			a = input.nextInt();
			b = input.nextInt();
			
			if (a==0 && a==0) {
				print(ans, i);
				input.close();
				return;
			}
			
			ans[i] = a+b;
			i++;
		}
	}

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.println(arr[i]);
    }
}
