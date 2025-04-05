import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int B=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        
        long answer=0;
        for(int i=0;i<N;i++){
            int tmp=arr[i]-B;
            answer++;
            if(tmp>0){
                if(tmp%C==0)
                    answer+=tmp/C;
                else
                    answer+=tmp/C+1;
            }
        }
        System.out.println(answer);
        // N 시험장 개수 , int[] arr 각시험장 학생수 , B 총감독관 감시, C 부감독관 감시
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}