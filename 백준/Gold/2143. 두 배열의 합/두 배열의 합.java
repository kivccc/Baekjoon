import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        int n=Integer.parseInt(br.readLine());
        int[] arra=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arra[i]=Integer.parseInt(st.nextToken());
        }
        
        int m=Integer.parseInt(br.readLine());
        int[] arrb=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arrb[i]=Integer.parseInt(st.nextToken());
        }

        HashMap<Integer,Integer> memmap=new HashMap<>();
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=i;j<m;j++){
                sum+=arrb[j];
                memmap.put(sum,memmap.getOrDefault(sum,0)+1);
            }
        }
        long answer=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arra[j];
                answer+=memmap.getOrDefault(t-sum,0);
            }
        }                   
        System.out.println(answer);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}