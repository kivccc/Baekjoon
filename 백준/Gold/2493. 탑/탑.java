import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int[] answer=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());        
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=N-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else if(arr[i]<arr[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && arr[i]>arr[stack.peek()]){
                    int idx=stack.pop();
                    answer[idx]=i+1;
                }    
                stack.push(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i:answer)
            sb.append(i).append(" ");
        System.out.println(sb);
        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}