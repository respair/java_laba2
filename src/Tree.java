public class Tree {

    private int count=0;

    public class Node {

        public Node(){}

        public Node(Object d, int in){
            this.data = d;
            this.key = in;
        }

        private int key; //ключ узла
        private Object data; //некоторые данные в узле
        private Node leftChild=null; //левый потомок
        private Node rightChild=null; //правый потомок

        @Override
        public String toString() {
            return "KEY: " + key + " DATA: " + data;
        }

        public Node leftChild(){
            return leftChild;
        }
        public Node rightChild(){
            return rightChild;
        }

        public Object getValue(){
            return data;
        }
        public int getIndex(){
            return key;
        }

        public void setRight(Node right){
            rightChild = right;
        }
        public void setLeft(Node left){
            leftChild = left;
        }
        public Node getParent(){
            // Node n = new Node(this.data,this.key);
            //Tree t = new Tree(this);
            return Tree.this.getParent(this);
        }
        public Tree subtree(){
            //  Node n = new Node(this.data,this.key);
            //  System.out.println("left child: " + this.leftChild());
            return new Tree(this);
        }
        public List path(){
            Node parent = this.getParent();
            List l = new List();
            l.add(parent);
            l.add(this);
            return l;
        }
        public void printPath(){
            List l = this.path();
            System.out.println(l.get(0)+"-->"+l.get(1));
        }

        private List pathIn(Node node){
            Node currentNode = root;
            Object value = node.getValue();
            List a = new List();
            a.add(root.getIndex());
            while (currentNode.getValue() != value) {
                if ( (int)value < (int)currentNode.getValue()) {
                    currentNode = currentNode.leftChild();
                    a.add(currentNode.getIndex());
                }
                else {
                    a.add(currentNode.getIndex());
                    currentNode = currentNode.rightChild();
                }

                if (currentNode == null)
                    return null;
            }
            return a;
        }
        public Node findParent(Node another){
            List a1 = pathIn(this);
            List a2 = pathIn(another);
            if(a1==null || a2==null) return root;
            if(another.getIndex()==this.getIndex()) return this.getParent();
            for(int i=a1.size()-1;i>=0;i--){
                for(int j=a2.size()-1;j>=0;j--){
                    if(a1.get(i)==a2.get(j) && (int)a1.get(i)!=this.getIndex() &&
                            (int)a2.get(j)!=another.getIndex()) return getChild((int)a1.get(i));
                    else if(a1.get(i)==a2.get(j) && (int)a1.get(i)==this.getIndex())
                        return getChild((int)a1.get(i)).getParent();
                    else if(a1.get(i)==a2.get(j) && (int)a2.get(j)==another.getIndex())
                        return getChild((int)a1.get(i)).getParent();
                }
            }
            return null;
        }
    }



    private Node root;

    public Tree(){}

    public Tree(Object d, int key){
        root = new Node(d,key);
        count+=1;
    }

    public Tree(Node d){
        root = d;
        count = countNodes(d);
        //     System.out.println(count);
    }

    public int countNodes(Node root) {
        if (root == null) { return 0; }
        return 1 + countNodes(root.leftChild()) + countNodes(root.rightChild());
    }

    public void addChild(Node item) {
        Node newNode = item;
        int k=item.getIndex();
        if (root == null) {
            root = newNode;
            count+=1;
        }
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if(item.getValue() == current.getValue())    // если такой элемент уже есть, не сохраняем
                    return;
                else  if ((int)item.getValue() < (int)current.getValue()) {   // влево
                    current = current.leftChild();
                    //  System.out.println("+");
                    if (current == null){
                        // System.out.println("++");
                        parent.leftChild = newNode;
                        count+=1;
                        return;
                    }
                }
                else { // вправо
                    current = current.rightChild();
                    if (current == null) {
                        //parent.setRight(newNode);
                        parent.rightChild = newNode;
                        count+=1;
                        return;
                    }
                }
            }
        }
    }

    public Node find(Object value){
        Node currentNode = root;
        while (currentNode.getValue() != value) {
            if ( (int)value < (int)currentNode.getValue())
                currentNode = currentNode.leftChild();
            else
                currentNode = currentNode.rightChild();

            if (currentNode == null)
                return null;
        }
        return currentNode;
    }
    private Node find(Node root, int v){
        //int h=0;
        while(root!=null){
            // root=root.rightChild();
            if(root.rightChild()!=null)
                if(root.rightChild().getIndex()==v)
                    return root.rightChild();
            if(root.leftChild()!=null)
                if(root.leftChild().getIndex()==v)
                    return root.leftChild();
            Node n1 = find(root.rightChild(),v);
            Node n2 = find(root.leftChild(),v);
            if(n1!=null) return n1;
            else if(n2!=null) return n2;
            else return null;
        }
        return null;
    }
    public Node getChild(int index){
        Node current = root;
        if(root.getIndex()==index) return root;
        else {
            return find(current,index);
        }

    }


    public Node getParent(Node item){
        Node currentNode = root;
        Node parentNode = root;
        //Node node = getChild(index);
        Object value=item.getValue();
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if ((int) value < (int) currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.leftChild();
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChild();
            }
            if (currentNode == null)
                return null; // yзел не найден
        }
        return parentNode;

    }

    private Node findHeir(Node node) { //ищем крайнего левого потомка правого потомка удаляемого узла и если это не правый потомок
        // удаляемого узла делаем правый потом удаляемого узла правым потомком найденного конечного левого потомка
        //аналогично с левым потомком удаляемго узла - он становится левым потомком найденного узла
        // и если у этого левого потомка уже был какой-то правый потомок делаем его левым потомком родителя найденнного узла
        Node parent = node;
        Node heir = node;
        Node currentNode = node.rightChild(); // перешли к правому потомку
        while (currentNode != null) { // пока существуют левые потомки
            parent = heir;// родительский узел отстает на два от каррент
            heir = currentNode; //искомый отстает на 1
            currentNode = currentNode.leftChild(); // переход к левому потомку (индификатор конца левых потомков)
        }
        if (heir != node.rightChild()) {
            parent.setLeft(heir.rightChild());
            heir.setRight(node.rightChild());
            heir.setLeft(node.leftChild());
        }
        return heir;
    }

    public boolean removeChild(int index){
        Node currentNode = root;
        Node parentNode = root;
        Node node = getChild(index);
        Object value=node.getValue();
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if ((int)value < (int)currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.leftChild();
            }
            else {
                isLeftChild = false;
                currentNode = currentNode.rightChild();
            }
            if (currentNode == null)
                return false;
        }

        if (currentNode.leftChild() == null && currentNode.rightChild() == null) { // узел просто удаляется, если не имеет потомков
            if (currentNode == root) // если узел - корень, то дерево очищается
                root = null;
            else if (isLeftChild)
                parentNode.setLeft(null); // если нет - узел отсоединяется, от родителя
            else
                parentNode.setRight(null);
        }
        else if (currentNode.rightChild() == null) { // узел заменяется левым поддеревом, тк правого потомка нет, левый есть
            if (currentNode == root)
                root = currentNode.leftChild();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.leftChild());
            else
                parentNode.setRight(currentNode.leftChild());
        }
        else if (currentNode.leftChild() == null) { // узел меняется на правое поддерево
            if (currentNode == root)
                root = currentNode.rightChild();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.rightChild());
            else
                parentNode.setRight(currentNode.rightChild());
        }
        else { // если есть два потомка, узел заменяется преемником (конечным левым узлом правого потомка удаляемого узла у
            // которого правый узел указывает на правого потомка удаляемого узла
            Node heir = findHeir(currentNode);
            if (currentNode == root)
                root = heir;
            else if (isLeftChild)
                parentNode.setLeft(heir);
            else
                parentNode.setRight(heir);
        }
        if(currentNode != null) currentNode = null;
        count-=1;
        return true;


    }
    public boolean removeChild(Node value){
        return removeChild(value.getIndex());
    }
    private void toList(Node node, List list){
        if(node!=null){
            // list.add(node.getValue());
            if(node.rightChild()!=null)
                list.add(node.rightChild()); //.getValue());
            // toList(node.rightChild,list);
            if(node.leftChild()!=null)
                list.add(node.leftChild());//.getValue());
            if(node.rightChild()!=null)
                toList(node.rightChild(),list);
            if(node.leftChild()!=null)
                toList(node.leftChild(),list);
        }
        // else return;
    }
    public List toList(){
        List list = new List();
        list.add(root);//.getValue());
        toList(root,list);
        return list;
    }
    public boolean isEmpty(){
        if(count==0) return true;
        else return false;
    }
    public int size(){
        return count;
    }

}