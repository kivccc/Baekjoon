import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] health=new int[2*N];
        int[][] belt=new int[2*N][2]; //위치 개념 0 : 칸 번호,  1: 로봇유무
        st=new StringTokenizer(br.readLine());
        for(int i=2*N-1;i>=0;i--){
            belt[i][0]=2*N-1-i;
            health[i]=Integer.parseInt(st.nextToken());
        }
        int count=0;
        int answer=0;
        while(true){
            answer++;
            int[] last = belt[2*N-1]; // 마지막 칸 백업
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1]; // 한 칸씩 뒤로 밀기
            }
            belt[0] = last;
            if(belt[N-1][1]==1){ //로봇 하차
                belt[N-1][1]--;
            }
            for(int i=N-2;i>=0;i--){ //앞으로 하나씩 떙기기
                if(belt[i][1]==1 && belt[i+1][1]==0 && health[belt[i+1][0]]>=1){
                    belt[i][1]--;
                    belt[i+1][1]++;
                    if(i+1==N-1){ //로봇 하차
                        belt[i+1][1]--;
                    }
                    health[belt[i+1][0]]--;
                    if(health[belt[i+1][0]]==0)
                        count++;
                    if(count>=K){
                        System.out.println(answer);
                        return;
                    }
                }
            }
            if(health[belt[0][0]]>0){ //로봇 승차
                health[belt[0][0]]--;
                if(health[belt[0][0]]==0)
                    count++;
                if(count>=K){
                    System.out.println(answer);
                    return;
                }
                belt[0][1]++;
            }
        }

        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}