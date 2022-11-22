package complete;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NandM_1 {
	public static void main(String[] args) {
        int N=0, M =0;
        Scanner input = new Scanner(System.in);
        
        N = input.nextInt();
        M = input.nextInt();
        
        if (1>M || 1>N || M>8 || N>8 || M>N) {
        	System.out.println("올바른 입력값이 아닙니다.");
        	return;
        }
        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] visited = new boolean[N];
        
        makearray(arr, N);
        permutation(arr, output, visited, 0, N, M);
        System.out.println();
    }

	static void makearray(int[] arr, int n) {
        for(int i=0; i<n; i++) {
        	arr[i] = i+1;
        }     
	}

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int m) {
        if (depth == m) { // depth끝까지 다다르면 output 출력
            print(output, m);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) { // 중복 방지
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, m);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}