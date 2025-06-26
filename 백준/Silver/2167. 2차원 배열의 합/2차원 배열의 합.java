import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int [] arr2=new int[n*m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int val=Integer.parseInt(st.nextToken());
                arr2[i*m+j]=val;
            }
        }
        //System.out.println(Arrays.toString(arr2));
        StringBuilder sb=new StringBuilder();
        int k=Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            int d=Integer.parseInt(st.nextToken())-1;
            int sum=0;
            for(int y=a;y<=c;y++)
                for(int x=b;x<=d;x++)
                    sum+=arr2[y*m+x];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}