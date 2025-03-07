import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String p=br.readLine();
            int n=Integer.parseInt(br.readLine());
            String[] arr=new String[n];
            String s=br.readLine();
            if(n!=0){
                String[] tmp=s.substring(1,s.length()-1).split(",");
                int j=0;
                for(String word:tmp)
                    arr[j++]=word;
            }
            int lidx=0;
            int ridx=n-1;
            boolean reverse=false;
            boolean error=false;
            for(char c:p.toCharArray()){
                if(c=='R')
                    reverse=!reverse;
                else if(c=='D'){
                    if(lidx>ridx){
                        error=true;
                        break;
                    }
                    if(!reverse)
                        lidx++;
                    else
                        ridx--;
                }
            }
            StringBuilder sb=new StringBuilder();
            if(!error){
                sb.append("[");
                if(!reverse)
                    for(int j=lidx;j<=ridx;j++){
                        if(j!=ridx)
                            sb.append(arr[j]).append(",");
                        else
                            sb.append(arr[j]);
                    }
                else
                    for(int j=ridx;j>=lidx;j--){
                        if(j!=lidx)
                            sb.append(arr[j]).append(",");
                        else
                            sb.append(arr[j]);
                    }
                sb.append("]");
            }
            else
                sb.append("error");
            System.out.println(sb);
        }
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}