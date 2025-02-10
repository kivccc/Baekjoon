import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        
        int [] answer=new int[26];
        Arrays.fill(answer,-1);
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(answer[idx]==-1)
                answer[idx]=i;
        }
        StringBuilder sb=new StringBuilder();
        for(int i:answer)
            sb.append(Integer.toString(i)+" ");
        System.out.println(sb.toString());
	}
}