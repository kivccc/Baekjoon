import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String label;
        ArrayList<Node> child;
        
        Node(String label) {
            this.label = label;
            this.child = new ArrayList<>();
        }
    }
    
    private static boolean solveTreeIsomorphism(String one, String two) {
        Node rootA = buildTree(one);
        Node rootB = buildTree(two);
        
        String formA = getForm(rootA);
        String formB = getForm(rootB);
        
        //System.out.println(formA);
        //System.out.println(formB);
        return formA.equals(formB);  
    }
    
    static Node buildTree(String input) {
        StringTokenizer st = new StringTokenizer(input);
        Node root = new Node(st.nextToken());
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (st.hasMoreTokens()) {
            String label = st.nextToken();
            if (label.equals("#")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                Node parent = stack.peek();
                Node newNode = new Node(label);
                parent.child.add(newNode);
                stack.push(newNode);
            }
        }
        
        return root;
    }
    
    static String getForm(Node node) {
        if (node.child.isEmpty()) {
            return "()";  // 리프 노드
        }
        
        List<String> childForm = new ArrayList<>();
        for (Node child : node.child) {
            childForm.add(getForm(child));
        }
        
        Collections.sort(childForm);
        
        StringBuilder sb = new StringBuilder("(");
        for (String form : childForm) {
            sb.append(form);
        }
        sb.append(")");
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < numTests; i++) {
            String line1 = br.readLine();
            String line2 = br.readLine();
            
            if (solveTreeIsomorphism(line1, line2)) {
                System.out.println("The two trees are isomorphic."); 
            } else {
                System.out.println("The two trees are not isomorphic."); 
            }
        }
        
        br.close();
    }
}