package BinaryTrees;

class Node{
    int data;
    Node left=null;
    Node right=null;
    int startIndex;
    int endIndex;

    Node(int startIndex,int endIndex){
        this.startIndex=startIndex;
        this.endIndex=endIndex;
    }

}
public class SegmentTree{

    private static Node root;

    public static void main(String[] args){
        int []arr={1,2,32,3};
       root= generateTree(arr,0,arr.length-1);
       display();


       update(3,45);
        display();

    }

    public static Node generateTree(int []arr,int start,int end){
       if(start == end) {
      // leaf node
      Node leaf = new Node(start, end);
      leaf.data = arr[start];
      return leaf;
    }

    // create new node with index you are at
    Node node = new Node(start, end);
    
    int mid = (start + end) / 2;

    node.left = generateTree(arr, start, mid);
    node.right = generateTree(arr, mid + 1, end);

    node.data = node.left.data + node.right.data;
    return node;
    }

    public static void display(){
        display(root);
    }
    public static void display(Node root){
        if(root==null)return;

        System.out.println(root.data+". "+root.startIndex+" "+root.endIndex);
        display(root.left);
        display(root.right);
    }

    public static int query(int si,int ei){
            return query(root,si,ei);
    }
    public static int query(Node node,int si,int ei){
        if(node.startIndex>=si && node.endIndex<=ei){
            return node.data;
        }
        if(node.startIndex>ei || node.endIndex<si){
            return 0;
        }
        return query(node.left,si,ei)+query(node.right,si,ei);
    }

    public static void update(int index,int value){
        update(root,index,value);
    }
    public static int update(Node node,int index,int value){
     if (index >= node.startIndex&& index <= node.endIndex){
      if(index == node.startIndex && index == node.endIndex) {
        node.data = value;
        return node.data;
      } else {
        int leftAns = update(node.left, index, value);
        int rightAns = update(node.right, index, value);
        node.data = leftAns + rightAns;
        return node.data;
      }
    }
    return node.data;

        
    }

}