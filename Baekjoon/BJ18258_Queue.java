package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue {
	static LinkedList<String> queue = new LinkedList<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n;
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer split;
		
		for(int i=0; i<N; i++) {
			split = new StringTokenizer(br.readLine(), " ");
			String str = split.nextToken();
			if (str.equals("push")){
				n = split.nextToken();
				push(queue, n);
			}
			
			switch(str) {
				case "pop":
					sb.append(pop(queue)).append('\n');
					break;
				case "size":
					sb.append(size(queue)).append('\n');
					break;
				case "empty":
					sb.append(empty(queue)).append('\n');
					break;
				case "front":
					sb.append(front(queue)).append('\n');
					break;
				case "back":
					sb.append(back(queue)).append('\n');
					break;
			}
		}
		System.out.println(sb);
	}
	
	static void push(LinkedList<String> q, String str) {
		q.add(str);
	}
	static String pop(LinkedList<String> q) {
		// 큐가 비어있으면 -1
		if (empty(q).equals("1")) {
			return "-1";
		}
		return q.poll();
	}
	static String size(LinkedList<String> q) {
		return Integer.toString(q.size());
	}
	static String empty(LinkedList<String> q) {
		if(q.size()==0)
			return "1";
		return "0";
	}
	static String front(LinkedList<String> q) {
		if (empty(q).equals("1")) {
			return "-1";
		}
		return q.peek();
	}
	static String back(LinkedList<String> q) {
		if (empty(q).equals("1")) {
			return "-1";
		}
		return q.peekLast();
	}
}
