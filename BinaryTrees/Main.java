package BinaryTrees;
public class Main{
    public static void main(String[] args) {
        System.out.println("Pal");
        for(int i=0;i<10000;i++){
            BalancedTree.insert(i);
        }
        System.out.println(BalancedTree.height());
    }
}