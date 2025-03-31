import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(br.readLine());
            list.add(val-1,i+1);
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        for(int i=M;i>0;i--){
            int num=list.get(i-1);
            int val=Integer.parseInt(br.readLine());
            list2.add(val-1,num);
        }
        for(int i=0;i<3;i++)
            System.out.println(list2.get(i));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}