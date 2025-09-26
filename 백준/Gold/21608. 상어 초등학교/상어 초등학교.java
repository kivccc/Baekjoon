import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] table;
    static int[][] like;
    static int[] order;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        order = new int[n*n+1];
        like = new int[n*n+1][4];
        //
        //int n = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n*n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int who = Integer.parseInt(st.nextToken());
            order[i] = who;
            for(int j=0;j<4;j++){
                like[who][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //학생 배치
        for(int i=0;i<order.length;i++){
            
            int student = order[i];
            
            int[][] tmpTable = new int[n][n];
            checkNearLike(tmpTable,student); 

            PriorityQueue<int[]> pq =new PriorityQueue<>((e1,e2)->{
                // 0 : 인접 좋아하는 학생수
                // 1 : 인접한 칸에서 비어있는 칸 개수
                // 2 : y
                // 3 : x
                if(e1[0]!=e2[0])
                    return e2[0]-e1[0]; //좋아하는학생수는 내림차순
                if(e1[1]!=e2[1])
                    return e2[1]-e1[1]; //빈칸도 내림차순
                if(e1[2]!=e2[2])
                    return e1[2]-e2[2]; //행, 열은 오름차순
                if(e1[3]!=e2[3])
                    return e1[3]-e2[3];   
                return 0;
            });
            
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(table[j][k] != 0 ) continue;
                    int emptyTable = 0;
                    for(int idx=0;idx<4;idx++){
                        int nexty = j + dy[idx];
                        int nextx = k + dx[idx];
                        if(!isInTable(nexty,nextx)) continue;
                        if( table[nexty][nextx] == 0) //비어있다면
                            emptyTable++;
                    } 
                    pq.add(new int[]{tmpTable[j][k],emptyTable,j,k});
                }
            }
            int[] sit = pq.poll();
            table[sit[2]][sit[3]] = student;
            //출력
            //System.out.println(Arrays.toString(sit));
            //for(int[]t:table)
            //    System.out.println(Arrays.toString(t));
            //System.out.println();
        }
        
        //만족도
        int answer = 0;
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){            
                int student = table[j][k];
                int nearLike = 0;
                for(int idx=0;idx<4;idx++){
                    int nexty = j + dy[idx];
                    int nextx = k + dx[idx];
                    if(!isInTable(nexty,nextx)) continue;
                    for(int l=0;l<4;l++){
                        if( table[nexty][nextx] == like[student][l]) 
                            nearLike++;
                    }
                }
                if(nearLike == 1)
                    answer += 1;
                else if(nearLike == 2)
                    answer += 10;
                else if(nearLike == 3)
                    answer += 100;
                else if(nearLike == 4)
                    answer += 1000;
            }
        }
        System.out.println(answer);
	}
    
    static void checkNearLike(int[][] tmpTable,int student){
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){ //n * n 모든 자리 확인 
                for(int l=0;l<4;l++){ // 좋아하는 친구 4명이 앉은자리에 해당하는지
                    if(table[j][k] == like[student][l]){
                        for(int idx=0;idx<4;idx++){//맞으면 동서남북 +1
                            int nexty = j+dy[idx];
                            int nextx = k+dx[idx];
                            if(!isInTable(nexty,nextx)) continue;
                            tmpTable[nexty][nextx]++;
                        } 
                    }
                }
            }
        }
    }
    
    static boolean isInTable(int y,int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}