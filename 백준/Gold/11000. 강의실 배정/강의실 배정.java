import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)->{
            //s 가 같을 경우
            if(e1[0] == e2[0]) { 
               return e1[1]-e2[1];
            }
            //s 가 다를 경우
            else{
                return e1[0]-e2[0];
            }
        });
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start,end});
        }
        
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        int end = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            end = cur[1];
            if(!answer.isEmpty() && answer.peek() <= cur[0]){
                answer.poll();
            }
            answer.add(end);
        }
        System.out.println(answer.size());
        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}