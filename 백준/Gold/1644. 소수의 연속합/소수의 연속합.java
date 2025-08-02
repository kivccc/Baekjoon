import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i)
                    prime[j]=false;
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=2;i<=n;i++)
            if(prime[i])
                list.add(i);
        int left=0;
        int right=0;
        int sum=0;
        int answer=0;
        while(true){
            if(sum>=n){
                if(sum==n)
                    answer++;
                sum-=list.get(left++);
            }
            else{
                if(list.size()==right)    break;
                sum+=list.get(right++);
            }
        }
        System.out.println(answer);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int n=Integer.parseInt(st.nextToken());

        /*
        for(int i=0;i<n;i++){
        
        }
        */
        

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}