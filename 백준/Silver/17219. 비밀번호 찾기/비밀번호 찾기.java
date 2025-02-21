import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] s=br.readLine().split(" ");
        int N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);
        HashMap<String,String> map=new HashMap<>();
        
        for(int i=0;i<N;i++){
            s=br.readLine().split(" ");
            map.put(s[0],s[1]);
        }
        
        for(int i=0;i<M;i++){
            String site=br.readLine();
            bw.write(map.get(site));
            bw.write("\n");
        }
        bw.flush();
	}
}