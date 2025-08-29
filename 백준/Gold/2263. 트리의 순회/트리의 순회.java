import java.util.*;
import java.io.*;
public class Main {
    static int[] in;
    static int[] post;
    static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v=Integer.parseInt(br.readLine());
        
        in=new int[v];
        post=new int[v];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<v;i++){
            in[i]=Integer.parseInt(st.nextToken());
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<v;i++){
            post[i]=Integer.parseInt(st.nextToken());
        }
        
        getTree(0,0,v);
        System.out.println(sb);
        //int n=
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    static void getTree(int inidx,int postidx,int size){
        if(size<1) return;
        
        int root=post[postidx+size-1];
        sb.append(root).append(" ");
        if(size==1) return;
        
        int idx=0;
        for(int i = inidx ; i < inidx+size; i++ ) {
			if(in[i] == root) {
				idx = i;
				break;
			}
		}
        int presize=idx-inidx;
        getTree(inidx,postidx,presize);
        getTree(inidx+presize+1,postidx+presize,size-presize-1);
    }
}