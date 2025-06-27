import java.util.*;
import java.io.*;
public class Main {
    public static StringBuilder sb=new StringBuilder();
    public static int n;
    public static int[] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        if(perm())
            app();
        else
            sb.append(-1);
        System.out.println(sb);
        return;
        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static boolean perm(){
        int i=arr.length-1;
        while(i>0 && arr[i-1]< arr[i]) i--;
        if(i<=0) return false;
        
        int j=arr.length-1;
        while(arr[j]>arr[i-1]) j--;
        swap(i-1,j);
        
        int left=i;
        int right=arr.length-1;
        while(left<right) swap(left++,right--);
        return true;
    }
    
    public static void swap(int i,int j){
        int t=arr[j];
        arr[j]=arr[i];
        arr[i]=t;
    }
    public static void app(){
        for(int i=0;i<n;i++){
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }
}