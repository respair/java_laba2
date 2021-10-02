public class List {
    private Object[] arraylist;
    private int size = 0;

    public List(){}

    public List(Object[] arr){
        int size = arr.length;
        arraylist = new Object[size];
        for(int i=0; i < size; i++){
            arraylist[i] = arr[i];
        }
        this.size = size;
    }
    public List(Object[] arr, int size){
        arraylist = new Object[size];
        this.size = size;
        int size_arr = arr.length;
        if(size_arr < size)
            for(int i=0; i < size; i++){
                if(i<size_arr)
                    arraylist[i] = arr[i];
                else
                    arraylist[i] = null;
            }
        if(size_arr >= size)
            for(int i=0; i < size; i++){
                arraylist[i] = arr[i];
            }
    }
    public void add(Object obj) {
        if(!isEmpty()) {
            this.size = this.size + 1;
            Object[] arraytime;
            arraytime = new Object[this.size];
            System.arraycopy(arraylist, 0, arraytime, 0, this.size - 1);
            arraytime[this.size - 1] = obj;
            arraylist = null;
            arraylist = new Object[this.size];
            System.arraycopy(arraytime, 0, arraylist, 0, this.size);
            arraytime = null;
        }
        else{
            this.size=1;
            arraylist = new Object[1];
            arraylist[0]=obj;
        }
    }
    public void add(Object obj, int index) {
        this.size = this.size + 1;
        if (index >= this.size - 1 || index < 0)
            add(obj);
        else {
            Object[] arraytime;
            arraytime = new Object[this.size];
            System.arraycopy(arraylist, 0, arraytime, 0, this.size - 1);
            Object time;
            for (int k = index; k < this.size; k++) {
                time = arraytime[k];
                arraytime[k] = obj;
                obj = time;
            }
            arraylist = null;
            arraylist = new Object[this.size];
            System.arraycopy(arraytime, 0, arraylist, 0, this.size);
            arraytime = null;
        }
    }
    public Object remove(int index){
        if(index>this.size-1 || index<0)
            return null;
        if(index==this.size-1){
            this.size=size-1;
            Object time = arraylist[this.size];
            arraylist[this.size]=null;
            return time;
        }
        else {
            Object time;
            this.size = this.size - 1;
            time = arraylist[index + 1];
            Object t=arraylist[index];
            for (int k = index + 1; k <= this.size; k++) {
                arraylist[k - 1] = time;
                if(k+1<this.size+1)
                    time = arraylist[k + 1];
            }
            arraylist[this.size] = null;
            return t;

        }

    }
    public Object get(int index){
        if(index>=0 && index <= this.size-1)
            return arraylist[index];
        else
            return null;
    }
    public Object set(Object obj, int index){
        Object t = get(index);
        if(index>=0 && index < this.size-1)
            arraylist[index]=obj;
        return t;
    }
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.size == 0)
            return true;
        else
            return false;

    }
    public boolean contains(Object obj){
        for(int i = 0; i< this.size; i++)
            if(get(i)==obj)
                return true;
        return false;
    }
    public int indexOf(Object obj){
        if(!contains(obj))
            return -1;
        else {
            for (int i = 0; i < this.size; i++)
                if (get(i) == obj)
                    return i;
            return -1;
        }
    }
    @Override
    public String toString() {
        String str="";
        for(int i = 0; i<this.size;i++) {
            str = str + arraylist[i];
            if(i<this.size-1) str=str+", ";
        }
        return str;

    }
}
