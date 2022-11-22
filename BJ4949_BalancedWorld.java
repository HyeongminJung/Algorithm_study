package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class BalancedWorld {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		
		while(true) {
			s = br.readLine();
			if (s.equals(".")) {
				break;
			}
			sb.append(balanced(s)).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static String balanced(String str) {
		Stack<String> stack = new Stack<String>();
		String[] splitStr = str.split("");
		stack.clear();
		
		for (int j=0; j<splitStr.length; j++){
			if (splitStr[j].equals("[") || splitStr[j].equals("(")) {
				stack.push(splitStr[j]);
			}else if(splitStr[j].equals("]")){
				if (!stack.empty() && stack.peek().equals("[")) {
					stack.pop();
				}else { return "no"; }
					
			}else if(splitStr[j].equals(")")){
				if (!stack.empty() && stack.peek().equals("(")) {
					stack.pop();
				}else { return "no"; }
			}
		}

		if (!stack.empty()) {
			return "no";
		}else {
			return "yes";
		}
	}
}














