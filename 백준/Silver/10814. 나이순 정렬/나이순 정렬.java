import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<String[]> q=new PriorityQueue<>((e1,e2)->{
            int age1=Integer.parseInt(e1[0]);
            int age2=Integer.parseInt(e2[0]);
            int ord1=Integer.parseInt(e1[2]);
            int ord2=Integer.parseInt(e2[2]);
            if(age1!=age2){
                return age1-age2;
            }
            else{
                return ord1-ord2;
            }
        });
        for(int i=0;i<N;i++){
            String[] line=br.readLine().split(" ");
            String[] arr=new String[]{line[0],line[1],Integer.toString(i)};
            q.add(arr);
        }
        while(!q.isEmpty()){
            String[] tmp=q.poll();
            bw.write(tmp[0]+" "+tmp[1]+"\n");
        }
        bw.flush();
	}
}