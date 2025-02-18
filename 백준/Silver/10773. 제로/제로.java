import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<N;i++){
            int v=sc.nextInt();
            if(v!=0)
                stack.push(v);
            else
                stack.pop();
        }
        int answer=0;
        while(!stack.isEmpty())
            answer+=stack.pop();
        System.out.println(answer);
	}
}