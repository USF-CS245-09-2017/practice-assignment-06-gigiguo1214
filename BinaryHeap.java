/*
A class that represent a Binary Heap.
@author Gigi Xiaowan Guo
*/
class BinaryHeap{
    int[] data;
    int cap;
    int size;
    public BinaryHeap(){
        cap = 100000+5;
        size = 0;
        data = new int[cap];
    }
    public BinaryHeap(int cap){
        this.cap = cap;
        size = 0;
        data = new int[cap];
    }
    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return 2 * i + 1;
    }
    int right(int i){
        return 2 * i + 2;
    }
    void resize(){
        cap *= 2;
        int[] cp = new int[cap];
        for(int i = 0;i < size;++i)
            cp[i] = data[i];
        data = cp;
    }
    void swap(int a,int b){
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }
    public void add(int arg){
        if(size >= cap)resize();
        int current = size;
        data[current] = arg;
        size++;
        int p = parent(current);
        while(data[current] < data[p]){
            swap(current, p);
            current = p;
            p = parent(current);
        }
    }
    public int remove(){
        int ans = -1;
        try{
            ans = data[0];
        }catch (Exception e){
            return -1;
        }
        data[0] = data[size-1];
        size--;
        if(size == 0)return ans;
        else fall(0);
        return ans;
    }
    void fall(int pos){
        int l = left(pos);
        int r = right(pos);
        if(l >= size || r >= size)return;
        int small = pos;
        if(data[l] < data[small])small = l;
        if(data[r] < data[small])small = r;
        if(small != pos){
            swap(pos, small);
            fall(small);
        }
    }
}