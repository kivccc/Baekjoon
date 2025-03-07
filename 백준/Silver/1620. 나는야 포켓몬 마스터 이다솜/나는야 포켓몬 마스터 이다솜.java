import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]s=br.readLine().split(" ");
        int N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);
        String[] arr=new String[N+1];        
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=1;i<=N;i++){
            String word=br.readLine();
            arr[i]=word;
            map.put(word,i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            String word=br.readLine();
            if(Character.isDigit(word.charAt(0)))
                sb.append(arr[Integer.parseInt(word)]).append("\n");
            else
                sb.append(map.get(word)).append("\n");
        }
        System.out.println(sb);
        
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}