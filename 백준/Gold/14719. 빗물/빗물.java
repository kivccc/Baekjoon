import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0, right = w - 1;
        int leftMax = 0, rightMax = 0;
        int answer = 0;
        
        while(left < right){
            if(arr[left] < arr[right]){
                if(arr[left] >= leftMax){
                    leftMax = arr[left];
                } else {
                    answer += leftMax - arr[left];
                }
                left++;
            } else {
                if(arr[right] >= rightMax){
                    rightMax = arr[right];
                } else {
                    answer += rightMax - arr[right];
                }
                right--;
            }
        }
        
        System.out.println(answer);
    }
}
