import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());        
        Stack<Character> stk=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c>='A'){
                sb.append(c);
                continue;
            }
            if(c=='('){
                stk.push(c);
                continue;
            }
            if(c==')'){
                while(stk.peek()!='('){
                    sb.append(stk.pop());
                }
                stk.pop();
                continue;
            }
            while(!stk.isEmpty() &&pri(stk.peek())>=pri(c)){
                sb.append(stk.pop());
            }                
            stk.push(c);    
        }
        while(!stk.isEmpty())
            sb.append(stk.pop());
        System.out.println(sb);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static int pri(char c){
        if(c=='*'||c=='/')
            return 2;
        if(c=='+'||c=='-')
            return 1;
        else
            return 0;
    }
}