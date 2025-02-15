import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 1; 
        boolean flag=true;
        
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            while (num <= val) {
                stack.push(num++);
                //bw.write("+\n");
                sb.append("+\n");
            }
            
            if (stack.peek() == val) {
                stack.pop();
                //bw.write("-\n");
                sb.append("-\n");
                
            } else {
                flag = false;
                break;
            }
        }
        if (!flag) 
            System.out.println("NO");
        else 
            System.out.println(sb.toString());

        
    }
}
