import java.util.*;
import java.io.*;
public class Main {
    static int max = 0;
    static int n;
    static int[][] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2]; //내구도 s , 무게 w
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dfs(arr,0);
        System.out.println(max);
        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    static void dfs(int[][]arr,int idx){
        if(idx == n){
            int count = 0;
            for(int i=0;i<n;i++){
                if(arr[i][0]<=0)
                    count++;
            }
            max = Math.max(max,count);
            return;
        }
        int handEggWeight = arr[idx][0];
        if(handEggWeight<=0){ //손에 든 계란이 깨졌거나
            dfs(arr,idx+1); //안 부딪치고 넘어가는 3번 과정
            return;
        }
        else{
            boolean flag = true;
            for(int i=0;i<n;i++){
                if(i == idx) continue;
                if(arr[i][0]>0){
                    flag = false;
                    break;
                }
            }
            if(flag){ //깨지지 않은 다른 계란이 없으면
                dfs(arr,idx+1); //안 부딪치고 넘어가는 3번 과정
                return;
            }
            else{ //계란 충돌 로직
                
            for(int i=0;i<n;i++){
                if(i == idx) continue;
                if(arr[i][0]<=0) continue;
                arr[idx][0] -= arr[i][1];
                arr[i][0] -= arr[idx][1];
                dfs(arr,idx+1);
                arr[idx][0] += arr[i][1];
                arr[i][0] += arr[idx][1];
            }
            }
        }
    }
}