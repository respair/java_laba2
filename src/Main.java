

public class Main {
    static int depthOfChild(Tree.Node node, int depth) {
        if ( node == null )
            return 0;
        int a = depth + depthOfChild(node.leftChild(), depth );
        int b = depth + depthOfChild(node.rightChild(), depth );
        if(a>b)
            return a+1;
        else return b+1;
    }

    static int depthOfTree(Tree.Node root){
        if(root.leftChild()==null && root.rightChild()==null)
           return 1;
        else return depthOfChild(root,0)-1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();                       // real depth=3
        Object[] obj = {5,8,10,9,3,4,1,7,11};
      // Object[] obj = {0,1,2,3,4,5,6,7,8};
        for(int i = 0; i<9; i++) {
            Tree.Node n = tree.new Node(obj[i],i);
            tree.addChild(n);          
          //  System.out.println(tree.getChild(i));
        }
        Tree tree2 = new Tree();                      // real depth=1
        Tree.Node n1 = tree.new Node(obj[0],0);
        tree2.addChild(n1);

        Tree.Node n = tree.getChild(0);
        System.out.println("depth tree: "+depthOfTree(n));

        Tree.Node n2 = tree2.getChild(0);
        System.out.println("depth tree2: "+depthOfTree(n2));
    }


}
