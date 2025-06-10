import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        long answer=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                answer+=stack.peek()-i-1;
            } else {
                answer+=n-i-1;
            }
            stack.push(i);
        }
        System.out.println(answer);


        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}