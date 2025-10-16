import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int left = 0;
        int right = 0;
        int len = 0 ;
        int leftK = k;
        while(right<n){
            if(arr[right]%2 == 0){ //짝수
                len++;
                answer = Math.max(answer,len);
            }
            else{ // 홀수
                leftK--;
                if(leftK<0){
                    while(leftK<0){
                        if(arr[left]%2 == 0)
                            len--;
                        else
                            leftK++;
                        left++;
                    }
                }
            }
            //System.out.println("left : " +left+ " arr[left] : "+arr[left]);
            //System.out.println("right : " +right+ " arr[right] : "+arr[right]);
            //System.out.println("len : " +len);
            //System.out.println();
            right++;
        }
        System.out.println(answer);
        //int n = Integer.parseInt(br.readLine());
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

}