import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] time = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 1;
        for(int i=0;i<n;i++){
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            max = Math.max(max,val);
            time[i] = val;
        }
        
        
        int left = max; 
        int right = sum; 
        int answer = Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left + right) / 2;
            //System.out.println("전");
            //System.out.println("left : "+left);
            //System.out.println("right : "+right);
            //System.out.println("mid : "+mid);
            int count = 0;
            
            int tmp = 0;
            for(int i=0;i<n;i++){
                tmp += time[i];
                if(tmp == mid){
                    count++;
                    tmp = 0;
                }           
                else if(tmp > mid){
                    count++;
                    tmp = time[i];
                }
            }
            if(tmp!=0)
                count++;
            //System.out.println("count : "+count);
            
            if(count > m){ // 너무 무게를 작게했음
                left = mid+1;
            } 
            else{ // 너무 무게를 크게했음
                answer = Math.min(answer,mid);
                right = mid -1;
            }
            //System.out.println("후");
            //System.out.println("left : "+left);
            //System.out.println("right : "+right);
            //System.out.println();
            
        }
        System.out.println(answer);
        
        

        //int n = Integer.parseInt(br.readLine());
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}