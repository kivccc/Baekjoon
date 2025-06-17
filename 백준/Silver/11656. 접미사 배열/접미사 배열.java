import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        PriorityQueue<String> q=new PriorityQueue<>();
        StringBuilder sb=new StringBuilder();
        for(int i=word.length()-1;i>=0;i--){
            sb.insert(0,word.charAt(i));
            q.add(sb.toString());
        }
        StringBuilder answer=new StringBuilder();
        while(!q.isEmpty())
            answer.append(q.poll()).append("\n");
        System.out.println(answer);
	}
}