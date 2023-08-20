package BinaryTrees;

 class BalancedTree {
    private static Node root;

    static class Node {
        int data;
        Node left=null;
        Node right=null;
        public Node(int data){
            this.data=data;
        }
    }
    public BalancedTree(){
        
    }
    public static void main(String[] args) {
        System.out.println("Pal");
        for(int i=0;i<10000;i++){
            insert(i);
        }
        System.out.println("Pal");
        System.out.println(height());
    }
    
    public static void insert(int val){
        root=insert(root,val);
    }
    public static Node insert(Node root,int val){
        if(root==null){
            Node temp=new Node(val);
            return temp;
        }
        if(root.data>val){
            if(root.left==null){
                root.left=new Node(val);
                return root;
            }
            else{
                insert(root.left,val);
            }
            
        }
        else{
            if(root.right==null){
                root.right=new Node(val);
                return root;
            }
            else{
                insert(root.right,val);
            }
        }
        return rotate(root);
    }
    public static int height(){
        return height(root);
    }
    public static int height(Node root){
        if(root==null)return 0;

        int left=height(root.left)+1;
        int right=height(root.right)+1;

        return Math.max(left,right);
    }
    public static Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            if(height(node.left.left)>height(node.left.right)){
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
              } 
        }
        if(height(node.right)-height(node.left)>1){
            if(height(node.right.left)>height(node.right.right)){
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
              }
        }
        return root;
    }
    private static Node leftRotate(Node left) {
        Node p=left.right;
        Node t2=p.left;
        p.left=left;
        left.right=t2;
        return p;
    }
    private static Node rightRotate(Node root2) {
        Node c=root2.left;
        Node t1=c.left;
        c.left=root2;
        root2.left=t1;

        return c;
    }
}
   

