import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][]arr=new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i:arr[n-1])
            list.add(i);
        Collections.sort(list,Comparator.reverseOrder());
        for(int i=n-2;i>=0;i--){
            int min=list.get(n-1);
            int max=Integer.MIN_VALUE;
            ArrayList<Integer>tmp=new ArrayList<>();
            for(int j=n-1;j>=0;j--){
                max=Math.max(max,arr[i][j]);
                tmp.add(arr[i][j]);
            }
            if(min>max){
                System.out.println(min);
                return;
            }
            list.addAll(tmp);
            Collections.sort(list,Comparator.reverseOrder());
        }
        System.out.println(list.get(n-1));
        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}