public class NewMain {

    static String[] splitStr(String str) {
        String[] subStr;
        str.replaceAll("\\s+", " ");
        str.replaceAll("[-+.^:,*]", "");
        subStr = str.split(" ");
        int c = 0;
        for (int j = 0; j < subStr.length - 1; j++) {
            String a = subStr[j];
            int count = 1;
            for (int i = j + 1; i < subStr.length; i++) {
                if (subStr[i].equals(a) && !subStr[i].equals("")) {
                    count++;
                    c++;
                    subStr[i] = "";
                }
            }
            subStr[j] = a + ":" + count;
        }
        String[] result = new String[subStr.length - c];
        int count_j = 0;
        for (int i = 0; i < subStr.length; i++) {
            if (!subStr[i].equals(":1")) {
                result[count_j] = subStr[i];
                count_j++;
            }
        }
        return result;
    }

    static String normStr(String str) {
        String[] subStr;
        str.replaceAll("\\s+", " ");
        str.replaceAll("[-+.^:,*]", "");
        subStr = str.split(" ");
        String result = "";
        int c = 0;
        for (int j = 0; j < subStr.length - 1; j++) {
            String a = subStr[j];
            for (int i = j + 1; i < subStr.length; i++) {
                if (subStr[i].equals(a) && !subStr[i].equals("")) {
                    c++;
                    subStr[i] = "";
                }
            }
        }
        for (int i = 0; i < subStr.length; i++) {
            result = result + subStr[i];
            if (i < subStr.length - 1 && !subStr[i].equals("")) {
                result = result + " ";
            }
        }
        return result;
    }

    /*private int depth_(NormTree.NNode node, int depth) {

    }*/

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

        /**depth**/
        Tree tree = new Tree();                       // real depth=3
        int[] obj = {5,8,10,9,3,4,1,7,11};
        for(int i = 0; i<9; i++) {
            tree.addChild(obj[i]);
        }
        Tree tree2 = new Tree(obj[0]);                      // real depth=1

        Tree.Node n = tree.getChild(5);
        System.out.println("depth tree: "+depthOfTree(n));

        Tree.Node n2 = tree2.getChild(5);
        System.out.println("depth tree2: "+depthOfTree(n2));
        System.out.println("");

        /**split**/
        String ss3 ="a aaa rrrr rrrr  aa rrrr aaa a a aa a ";
        String[] s = splitStr(ss3);
        String ss = normStr(ss3);
        System.out.println(ss);
        for(String i : s)
            System.out.println(i);

    }
}
