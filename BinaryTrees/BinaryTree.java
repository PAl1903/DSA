package BinaryTrees;
import java.util.*;

 class Node {
    int data;
    Node right;
    Node left;
    Node(int data,Node right,Node left){
      this.data=data;
      this.right=right;
      this.left=left;
    }
  }
class BinaryTree{
  
    static int res=0;
    static int maxLevel=0;
    static ArrayList<Integer>arr2=new ArrayList<Integer>();
    
  
  public static void main (String[] args){

    int []arr={1,2,3,4,5,6,7};
    Node root=new Node((0+arr.length)/2,null,null);
    SortedArray(arr, 0, arr.length, root);

        inOrder(root);

    // for(int i=1;i<arr.length;i++){
    //   GenerateBinarySearchTree(root, arr[i]);
    // }
    // Node root=GenerateBinaryTree(arr);
    // Node temp=root;
    // find(root,maxLevel);
    // System.out.println();
    // System.out.println(res +" "+maxLevel);
    // printPath(root);
    // for(int i=0;i<arr2.size();i++)
    //   System.out.println(arr2.get(i)+"-->");
    
  }
  public static void inOrder(Node root){
    if(root==null)return;
    
   System.out.print(root.data+" ");
    inOrder(root.left);
    inOrder(root.right);
    
  }
  public static boolean printPath(Node root){
    if(root==null)return false;

    if(root.data==res){
      arr2.add(root.data);
      return true;
    }
    
    if(printPath(root.left)){
      arr2.add(root.data);
      return true;
    }
    if(printPath(root.right)){
      arr2.add(root.data);
      return true;
    }
    return false;
  }
  
  public static void find(Node root,int level){
    if (root != null)
        {
            find(root.left, ++level);
 
            // Update level and rescue
            if (level > maxLevel)
            {
                res = root.data;
                maxLevel = level;
            }
 
            find(root.right, level);
        }

  }
 

  public static Node GenerateBinaryTree(int [] nums){
     if (nums == null || nums.length == 0) {
            return null;
        }
        Node root = new Node(nums[0],null,null);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nums.length) {
            Node curr = q.remove();
            if (i < nums.length) {
                curr.left = new Node(nums[i++],null,null);
                q.add(curr.left);
            }
            if (i < nums.length) {
                curr.right = new Node(nums[i++],null,null);
                q.add(curr.right);
            }
        }
        return root;
  }

  //Generate Binary Search Tree
  public static void GenerateBinarySearchTree(Node root,int val){
    if(root.data>val){
        if(root.left == null){
          root.left=new Node(val,null,null);
          return ;
        }
        GenerateBinarySearchTree(root.left, val);
    }
    else{
      if(root.right == null){
          root.right=new Node(val,null,null);
          return ;
        }
        GenerateBinarySearchTree(root.right, val);
    }
  }

  public static void SortedArray(int []nums,int start,int end,Node root){
    if(start>=end)return;

    int mid=(start+end)/2;
    GenerateBinarySearchTree(root,nums[mid]);

    SortedArray(nums, start, mid, root);
    SortedArray(nums, mid+1, end, root);
    
  }
}