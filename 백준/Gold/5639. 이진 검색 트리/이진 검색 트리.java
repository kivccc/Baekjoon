import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key=key;
            this.left=null;
            this.right=null;
        }
    }
    public static class BST{
        Node root;
        public BST(){
            root=null;
        }
        void insert(int key){
            this.root=insertKey(root,key);
        }
        Node insertKey(Node root,int key){
            if(root==null)
                return new Node(key);
            if(key<root.key)
                root.left=insertKey(root.left,key);
            else if(key>root.key)
                root.right=insertKey(root.right,key);
            return root;
        }
        public void postOrder(Node node){
            if(node==null)
                return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list=new ArrayList<>();
        String s;
        while((s=br.readLine())!=null){
            int n=Integer.parseInt(s);
            list.add(n);
        }
        BST tree=new BST();
        for(int i:list){
            tree.insert(i);
        }
        tree.postOrder(tree.root);

        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}