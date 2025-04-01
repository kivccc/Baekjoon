import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        String val;
        Node left;
        Node right;
        public Node(String val){
            this.val=val;
            left=null;
            right=null;
        }
    }
    public static class Graph{
        HashMap<String,Node> map=new HashMap<>();
        Node root;
        public void add(String top,String left,String right){
            map.putIfAbsent(top,new Node(top));
            if(!left.equals("."))
                map.putIfAbsent(left,new Node(left));
            if(!right.equals("."))
                map.putIfAbsent(right,new Node(right));
            
            Node parent=map.get(top);
            Node l=map.get(left);
            Node r=map.get(right);
            parent.left=l;
            parent.right=r;
        }
        public void front(Node node) {
            if (node != null) {
                System.out.print(node.val);
                front(node.left);
                front(node.right);
            }
        }
        public void mid(Node node) {
            if (node != null) {
                mid(node.left);
                System.out.print(node.val);
                mid(node.right);
            }
        }
        public void back(Node node) {
            if (node != null) {
                back(node.left);
                back(node.right);
                System.out.print(node.val);
            }
        }                        
        public void print() {
            front(root);
            System.out.println();
            mid(root);
            System.out.println();
            back(root);
            System.out.println();
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Graph g=new Graph();
        g.map.put("A",new Node("A"));
        g.root=g.map.get("A");
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String top=st.nextToken();
            String left=st.nextToken();
            String right=st.nextToken();
            g.add(top,left,right);
        }
        g.print();
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}