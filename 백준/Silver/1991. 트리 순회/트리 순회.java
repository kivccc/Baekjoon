import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        char val;
        Node right;
        Node left;
        public Node(char c){
            val=c;
            right=null;
            left=null;
        }
    }
    public static class Graph{
        HashMap<Character,Node> map=new HashMap<>();
        Node root;
        public void add(char top,char left,char right){
            if(left!='.' && !map.containsKey(left))
                map.put(left,new Node(left));
            if( right!='.' && !map.containsKey(right))
                map.put(right,new Node(right));
            if(!map.containsKey(top))
                map.put(top,new Node(top));
            Node root=map.get(top);
            root.left=map.get(left);
            root.right=map.get(right);
        }
        StringBuilder sb=new StringBuilder();
        public  void front(Node node){
            if(node==null) return;
            sb.append(node.val);
            front(node.left);
            front(node.right);
        }
        public  void mid(Node node){
            if(node==null) return;
            
            mid(node.left);
            sb.append(node.val);
            mid(node.right);
        }
        public  void rear(Node node){
            if(node==null) return;
            
            rear(node.left);
            rear(node.right);
            sb.append(node.val);
        }
        
        public  void print(){
            front(root);
            System.out.println(sb);
            sb.setLength(0);
            mid(root);
            System.out.println(sb);
            sb.setLength(0);
            rear(root);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Graph graph=new Graph();
        //int N=Integer.parseInt(st.nextToken());        
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char top=st.nextToken().charAt(0);
            char left=st.nextToken().charAt(0);
            char right=st.nextToken().charAt(0);
            graph.add(top,left,right);
        }
        graph.root=graph.map.get('A');
        graph.print();
        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}