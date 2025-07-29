import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n][n];

        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<n;j++){
                char c=line.charAt(j);
                if(c=='Y')
                    arr[i][j]=1;
                else
                    arr[i][j]=0;
            }
        }
        int max=0;
        for(int start=0;start<n;start++){
            Deque<Integer> q=new ArrayDeque<>();
            HashSet<Integer> set=new HashSet<>();
            for(int next=0;next<n;next++){
                if(arr[start][next]==1){
                    set.add(next);
                    q.add(next);
                }
            }
            while(!q.isEmpty()){
                int next=q.poll();
                for(int nextidx=0;nextidx<n;nextidx++){
                    if(nextidx==start) continue;
                    if(arr[next][nextidx]==1)
                        set.add(nextidx);
                }
            }
            max=Math.max(max,set.size());
        }
        System.out.println(max);

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}