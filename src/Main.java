
//Здесь старый вариант выполнения заданий, поэтому перейдите к NewMain!!!!!!!!!!!!!!!!!!!!!!

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

    static String normalizeStr(String str) {
        char[] res = str.toCharArray();
        int count=0;
        int ii=0;
        while(ii<res.length){
            //   System.out.println(3);
            int k=0;
            if(res[ii]==' ') {
                k = ii + 1;
                while (k < res.length && res[k] == ' ') {
                    k++;
                }
                ii = k;
            }
            else{
                count++;
                k = ii + 1;
                while (k < res.length && res[k] != ' ') {
                    k++;
                }
                ii=k;
            }
        }
        //  System.out.println(count);
        String[] result = new String[count];
        int counter=0;
        int i =0;
        int y =0;
        while(i<res.length){
            if(res[i]!=' ') {
                String time = "" + res[i];
                int k = i + 1;
                while (k < res.length && res[k] != ' ') {
                    time = time + res[k];
                    k++;
                }
                result[y] = time;
                y++;
                i=k;
            }
            else{i++;}
        }

        for(int j=0;j< result.length;j++) {
            if (result[j] != null)
                if (result[j] != "") {
                 //   int ccount=1;
                    //System.out.println("!!!11111111"+toString(result));
                    if(j+1<result.length)
                        for(int n=j+1;n<result.length;n++){
                            if(result[j].equals(result[n])){
                             //   ccount++;
                                result[n]="";
                            }
                        }
                    /*if (count != 1) {
                        char[] a = result[j].toCharArray();
                        a[a.length - 1] = Character.forDigit(ccount, 10);
                        result[j] = "";
                        for (int l = 0; l < a.length; l++) {
                            result[j] = result[j] + a[l];

                        }
                    }*/
                }
        }
      //  System.out.println(toString(result));
        String str1="";
        for(int z = 0; z<result.length;z++) {
            if(result[z]!="") {
               // System.out.println(str1);
                str1 = str1 + result[z];
                if (str1.length()  > z) str1 = str1 + " ";
            }
        }
        return str1;
    }

    static String split(String str){
       // System.out.println(1);
        char[] res = str.toCharArray();
       // System.out.println(2);
       // List ress = new List(res);
        int count=0;
        int ii=0;
        while(ii<res.length){
         //   System.out.println(3);
            int k=0;
            if(res[ii]==' ') {
                k = ii + 1;
                while (k < res.length && res[k] == ' ') {
                //    System.out.println(4);
                    k++;
                }

                /*if (k >= res.length) {
                    break;
                } else if (ii != 0) {
                    count++;
                }*/
                ii = k;
              //  System.out.println(ii);
            }
            else{
                count++;
                k = ii + 1;
                while (k < res.length && res[k] != ' ') {
                   // System.out.println(44);
                    k++;
                }
                ii=k;
               // else{break;}

            }
        }
      //  System.out.println(count);
        String[] result = new String[count];
        int counter=0;
        int i =0;
        int y =0;
        while(i<res.length){
            if(res[i]!=' ') {
                String time = "" + res[i];
                int k = i + 1;
                while (k < res.length && res[k] != ' ') {
                    time = time + res[k];
                    k++;
                }
                   result[y] = time+":1";
                   y++;
                   i=k;
            }
            else{i++;}
            }
      //  System.out.println(toString(result));
      //   i=0;
       /* while(i<res.length){
            if(res[i]!=' '){
                String time = ""+res[i];
                int k=i+1;
                while(k<res.length && res[k]!= ' '){
                    time=time+res[k];
                    k++;
                }*/
               // int m=0;
                for(int j=0;j< result.length;j++) {
                    if (result[j] != null)
                        if (result[j] != "") {
                            // System.out.println(44);
                        /*char[] v = result[j].toCharArray();
                        String s1 = "";
                        for (int l = 0; l < v.length - 2; l++) {
                            s1 = s1 + v[l];
                        }*/
                            int ccount = 1;
                            //System.out.println("!!!11111111"+toString(result));
                            if (j + 1 < result.length)
                                for (int n = j + 1; n < result.length; n++) {
                                    if (result[j].equals(result[n])) {
                                        ccount++;
                                        // System.out.println("+++==="+toString(result));
                                        //System.out.println("!!"+result[n]);
                                        result[n] = "";
                                        //System.out.println("+++"+result[j]+"==="+toString(result));
                                    }
                                }
                            if (count != 1) {
                                //  m = 1;
                                char[] a = result[j].toCharArray();
                       /* if(a[a.length-2]!=':'){
                            result[j]=result[j]+":2";
                        }
                        else{*/
                                // int b = a[a.length - 1] - '0';
                                //  b++;
                                a[a.length - 1] = Character.forDigit(ccount, 10);
                                result[j] = "";
                                for (int l = 0; l < a.length; l++) {
                                    result[j] = result[j] + a[l];
                                    // }
                                }
                            }
                        }
                    //  }
              /*  if(m==0) {
                    result[counter]=time+":1";
                    counter++;
                }*/
              /*  if(k>=res.length){ break;}
                i=k+1;*/
                    // }
                    //  else {i++;}
                }
         String str1="";
        for(int z = 0; z<result.length;z++) {
            if(result[z]!="") {
                str1 = str1 + result[z];
                if (str1.length() - 1 > z) str1 = str1 + " ";
            }
        }
        return str1;
    }

    public static String toString(String[] s) {
        String str="";
        for(int i = 0; i<s.length;i++) {
            str = str + s[i];
            if(i<s.length-1) str=str+" ";
        }
        return str;

    }

    public static void main(String[] args) {

        /**depth**/
        /*Tree tree = new Tree();                       // real depth=3
        Object[] obj = {5,8,10,9,3,4,1,7,11};
        //Object[] obj = {'a','c','s','e','z','k','d','o','i'};
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
        System.out.println("depth tree2: "+depthOfTree(n2));*/

        /**split**/
        String ss ="a aaa rrrr   aa";
        System.out.println("a aaa rrrr   aa --->"+split(ss));
        String ss1 =" a aaa rrrr   aa ";
        System.out.println(" a aaa rrrr   aa --->"+split(ss1));
        String ss2 ="a aaa rrrr   aa aaa";
        System.out.println("a aaa rrrr   aa aaa  --->"+split(ss2));
        String ss3 ="a aaa rrrr rrrr  aa rrrr aaa a a aa a ";
        System.out.println("a aaa rrrr rrrr  aa rrrr aaa a a aa a  --->"+split(ss3));

        System.out.println("___________________________");

        /**norm**/
        String ss4 ="a aaa rrrr   aa";
        System.out.println("a aaa rrrr   aa --->"+normalizeStr(ss4));
        String ss5 =" a aaa rrrr   aa ";
        System.out.println(" a aaa rrrr   aa --->"+normalizeStr(ss5));
        String ss6 ="a aaa rrrr   aa aaa";
        System.out.println("a aaa rrrr   aa aaa  --->"+normalizeStr(ss6));
        String ss7 ="a aaa rrrr rrrr  aa rrrr aaa a a aa a ";
        System.out.println("a aaa rrrr rrrr  aa rrrr aaa a a aa a  --->"+normalizeStr(ss7));
    }


}
