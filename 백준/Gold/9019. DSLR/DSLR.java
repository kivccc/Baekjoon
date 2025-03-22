import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            Deque<String[]> q=new ArrayDeque<>();
            boolean[] mem=new boolean[10000];
            q.add(new String[]{Integer.toString(A),""});
            mem[A]=true;
            while(!q.isEmpty()){
                String[]val=q.poll();
                int num=Integer.parseInt(val[0]);
                if(num==B){
                    
                }
                int d=getD(num);
                if(d==B){
                    System.out.println(val[1]+"D");
                    break;
                }
                int s=getS(num);
                if(s==B){
                    System.out.println(val[1]+"S");
                    break;
                }
                int l=getL(num);
                if(l==B){
                    System.out.println(val[1]+"L");
                    break;
                }                            
                int r=getR(num);
                if(r==B){
                    System.out.println(val[1]+"R");
                    break;
                }
                
                if(mem[d]==false){
                    q.add(new String[]{Integer.toString(d),val[1]+"D"});
                    mem[getD(num)]=true;
                }
                if(mem[s]==false){
                    q.add(new String[]{Integer.toString(s),val[1]+"S"});
                    mem[getS(num)]=true;
                }
                if(mem[l]==false){
                    q.add(new String[]{Integer.toString(l),val[1]+"L"});
                    mem[getL(num)]=true;
                }
                if(mem[r]==false){
                    q.add(new String[]{Integer.toString(r),val[1]+"R"});
                    mem[getR(num)]=true;
                }
            }
        }
        
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static int getD(int num){
        return (num*2)%10000;        
    }
    public static int getS(int num){
        if(num!=0)        
            return num-1;
        else
            return 9999;
    }
    public static int getL(int num) {
        return (num%1000)*10+(num/1000);
    }

    public static int getR(int num) {
        return (num%10)*1000+(num/10);
    }

}