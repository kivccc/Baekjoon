import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            int cur = arr[i];
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && arr[stack.peek()]< cur){
                    int idx=stack.pop();
                    answer[idx]=i;
                }
            }
            stack.push(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i:answer){
            if(i!=0)
                sb.append(arr[i]).append(" ");
            else
                sb.append(-1).append(" ");
        }
        System.out.println(sb);
        


        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}