import java.util.*;
import java.io.*;
public class Main {
    public static ArrayList<Long> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n<=10){
            System.out.println(n);
            return;
        }
        for(int i=1;i<=9;i++){
            dfs(i,i);
        }
        
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int n=Integer.parseInt(st.nextToken());

        /*
        for(int i=0;i<n;i++){
        
        }
        */
        list.add(0L);
        Collections.sort(list);
        if(n>=list.size()){
            System.out.println(-1);
        }else{
            System.out.println(list.get(n));
        }
        //ㅁ
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(long num,int digit){
        list.add(num);
        for(int i=0;i<digit;i++){
            dfs(num*10+i,i);
        }
    }
}