public class ResizableArrayBag<T>{// implements BagInterface<T>{

    private int size;
    private T[] bag;
    private int hiddenSize;
    public static final int DEFAULT_RESIZABLE_ARRAY_BAG_SIZE = 5;

    public ResizableArrayBag() {
        this(DEFAULT_RESIZABLE_ARRAY_BAG_SIZE);
    }

    public ResizableArrayBag(int s) {
        size = 0;
        hiddenSize = s;

        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[hiddenSize];
        bag = tBag;
    }

    @Override
    public int size(){
        return size;
    }

    //error handling needed for half these lol
    @Override
    public boolean add(T item){
        isFull();
        bag[size] = item;
        size++;
        return true;
    }

    //removes all of a certain item
    public boolean remove(T item){
        boolean removed = false;
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                bag[i] = bag[size-1];
                removed = true;
                break;
            }
        }
        return removed;
    }

    //removes all of a random item 
    public T remove(){
        int index = (int) (Math.random()*size);
        T item = bag[index];
        bag[index] = bag[size-1];
        size--;
        return item;
    }

    @Override
    public boolean isEmpty(){
        return size <= 0;
    }

    // this should work.... just allocates more memory for the list // might be better to multiply the size but eh idk
    public void isFull(){
        if(size == hiddenSize){
            hiddenSize += 5;

            @SuppressWarnings("unchecked")
            T[] tBag = (T[]) new Object[hiddenSize];
            
            for(int i = 0; i<size-1;i++){
                tBag[i] = bag[i];
            }

            bag = tBag;
        }
    }

    // just fyi this can only return Object[] array
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[size+1];
        for(int i = 0; i<size;i++){
            tBag[i] = bag[i];
        }
        return tBag;
    }


    // everything below this comment is untested
    @Override
    public void clear(){
        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[hiddenSize];
        bag = tBag;

        size = 0;
    }

    @Override
    public int getFrequencyOf(T item){
        int count = 0;
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T item){
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                return true;
            }
        }
        return false;
    }

}