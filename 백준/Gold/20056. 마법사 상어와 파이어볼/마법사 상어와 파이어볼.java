import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int r,c,m,s,d;
        public Node(int r,int c,int m,int s,int d){
            this.r=r;
            this.c=c;
            this.m=m;
            this.s=s;
            this.d=d;
        }
    }
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};	
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};	
    static ArrayList<Node>[][] map;	
    static ArrayList<Node> nodes = new ArrayList<>();	
    static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        map=new ArrayList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes.add(new Node(r,c,m,s,d));
        }
        for(int i=0;i<K;i++){
            nodeMove();
            checkNode();
        }
        int answer=0;
        for(Node node : nodes)
            answer += node.m;
        System.out.println(answer);
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void nodeMove(){
        for(Node node:nodes){
            int nextR= (node.r+N+dr[node.d]*(node.s%N))%N;
            int nextC= (node.c+N+dc[node.d]*(node.s%N))%N;
            node.r=nextR;
            node.c=nextC;
            map[node.r][node.c].add(node);
        }
    }
    public static void checkNode(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(map[y][x].size()<2){
                    map[y][x].clear();
                    continue;
                }
                
                int sumM=0,sumS=0,count=0;
                int size=map[y][x].size();
                for(Node node:map[y][x]){
                    sumM+=node.m;
                    sumS+=node.s;
                    if(node.d%2==0)
                        count++;
                    nodes.remove(node);
                }
                map[y][x].clear();
                sumM/=5;
                if(sumM==0)
                    continue;
                sumS/=size;
                if(count==size || count==0){
                    for(int i=0;i<8;i+=2)	
                        nodes.add(new Node(y,x,sumM, sumS, i));
                }
                else{
                    for(int i=1;i<8;i+=2)	
                        nodes.add(new Node(y,x,sumM, sumS, i));
                }
            }
        }
    }
}