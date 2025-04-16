import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String og=br.readLine();
        String bomb=br.readLine();
        int blen=bomb.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<og.length();i++){
            char c=og.charAt(i);
            stack.push(c);
            if(stack.size()>=blen){
                boolean match=true;
                
                for(int j=0;j<blen;j++){
                    if(stack.get(stack.size()-blen+j)!=bomb.charAt(j)){
                        match=false;
                        break;
                    }
                }
                if(match){
                    for(int j=0;j<blen;j++)
                        stack.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack)
            sb.append(c);
        if(sb.length()!=0)
            System.out.println(sb);
        else
            System.out.println("FRULA");
            
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}