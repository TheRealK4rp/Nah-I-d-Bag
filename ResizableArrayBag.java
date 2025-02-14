public class ResizableArrayBag<T>{// implements BagInterface<T>{

    private int size;
    private T[] bag;
    private int hiddenSize;

    public ResizableArrayBag() {
        size = 0;
        hiddenSize = 5;

        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[hiddenSize];
        bag = tBag;
    }

    public int size(){
        return size;
    }

    public boolean add(T item){
        isFull();
        bag[size] = item;
        size++;
        return true;
    }

    public boolean remove(T item){
        boolean removed = false;
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                bag[i] = bag[size-1];
                size--;
                i--;
                removed = true;
            }
        }
        return removed;
    }

    public T remove(){
        T item = bag[(int) (Math.random()*size)];
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                bag[i] = bag[size-1];
                size--;
                i--;
            }
        }
        return item;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public void isFull(){
        if(size == hiddenSize){
            hiddenSize += 5;

            @SuppressWarnings("unchecked")
            T[] tBag = (T[]) new Object[hiddenSize];
            
            for(int i = 0; i<size-1;i++){
                tBag[i] = bag[i];
            }
        }
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[size+1];
        for(int i = 0; i<size;i++){
            tBag[i] = bag[i];
        }
        return tBag;
    }



    public void clear(){
        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[hiddenSize];
        bag = tBag;

        size = 0;
    }

    public int getFrequencyOf(T item){
        int count = 0;
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                count++;
            }
        }
        return count;
    }

    public boolean contains(T item){
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                return true;
            }
        }
        return false;
    }

}