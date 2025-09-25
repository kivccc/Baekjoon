import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int count=0;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int k = Integer.parseInt(st.nextToken());
        arr = new int[3][3];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(count<=100){
            if(0<=r && r<arr.length && 0<=c && c<arr[0].length && arr[r][c] == k ){
                System.out.println(count);
                return;
            }
            if(arr.length >= arr[0].length){
                R();
            }    
            else{
                C();
            }
            
            //for(int[]a:arr)
            //    System.out.println(Arrays.toString(a));
            //System.out.println();
            
            count++;
            
        }
        System.out.println(-1);

	}
    
    static void R(){//행에 대해
        int maxLen = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){ //R 정렬
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<arr[i].length;j++){
                int val = arr[i][j];
                if(val == 0) continue;
                map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);
            }
            maxLen = Math.max(maxLen,arrSort(map,list));
        }
        if(maxLen > 100)
            maxLen = 100;
        int [][] newArr = new int[arr.length][maxLen];
        for(int i=0;i<list.size();i++){
            int[] sorted = list.get(i);
            int idx = 0;
            for(int val:sorted){
                newArr[i][idx++]=val;
                if(idx == 100)
                    break;
            }
        }
        arr = newArr;
        return;
    }
    static void C(){//열에 대해
        int maxLen = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<arr[0].length;i++){ //R 정렬
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<arr.length;j++){
                int val = arr[j][i];
                if(val == 0) continue;
                map.put(arr[j][i],map.getOrDefault(arr[j][i],0)+1);
            }
            maxLen = Math.max(maxLen,arrSort(map,list));
        }
        if(maxLen > 100)
            maxLen = 100;
        int [][] newArr = new int[maxLen][arr[0].length];
        for(int i=0;i<list.size();i++){
            int[] sorted = list.get(i);
            int idx = 0;
            for(int val:sorted){
                newArr[idx++][i]=val;
                if(idx == 100)
                    break;
            }
        }
        arr = newArr;
        return;
    }
    
    static int arrSort(HashMap<Integer,Integer> map,ArrayList<int[]> list){
        PriorityQueue<int[]> pq =new PriorityQueue<>((e1,e2)->{
            if(e1[1]!=e2[1])
                return e1[1]-e2[1];
            else
                return e1[0]-e2[0];
        });
        
        for(int key:map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        int[] afterSort = new int[map.size()*2];
        int idx=0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            afterSort[idx]=tmp[0];
            afterSort[idx+1]=tmp[1];
            idx+=2;
        }
        list.add(afterSort);
        return map.size()*2;
        
    }
    
}
