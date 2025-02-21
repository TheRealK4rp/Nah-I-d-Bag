public class ResizableArrayBag<T> implements BagInterface<T>{

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

    @Override
    public boolean add(T item){
        isFull();
        bag[size] = item;
        size++;
        return true;
    }

    @Override
    public boolean remove(T item){
        boolean removed = false;
        for(int i = 0;i < size;i++){
            if(item.equals(bag[i])){
                bag[i] = bag[size-1];
                removed = true;
                size--;
                break;
            }
        }
        return removed;
    }

    @Override
    public T remove(){
        if(isEmpty()) throw new NullPointerException("Bag Empty");
        T item = bag[size-1];
        bag[size-1] = null;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty(){
        return size <= 0;
    }

    
    public void isFull(){
        if(size == hiddenSize){
            hiddenSize *= 2;

            @SuppressWarnings("unchecked")
            T[] tBag = (T[]) new Object[hiddenSize];
            
            for(int i = 0; i<size-1;i++){
                tBag[i] = bag[i];
            }

            bag = tBag;
        }
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] tBag = (T[]) new Object[size];
        for(int i = 0; i<size;i++){
            tBag[i] = bag[i];
        }
        return tBag;
    }


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
            if(item == bag[i]){
                count++;
            }
        }
        return count;
    }
    
    @Override
    public boolean contains(T item){
        for(int i = 0;i < size;i++){
            if(item == bag[i]){
                return true;
            }
        }
        return false;
    }

    //Time complexity is O(n) as add and remove happen in O(1) time and this program loops through linearly. 
    public BagInterface<T> union(BagInterface<T> otherBag){
        BagInterface<T> unionBag = new ResizableArrayBag<>(otherBag.size() + size);
        BagInterface<T> newOther = new ResizableArrayBag<>(otherBag.size());

        for(int i = 0; i<size;i++){
            unionBag.add(bag[i]);
        }
        int otherBagSize = otherBag.size();
        for(int i = 0;i<otherBagSize;i++){
            T item = otherBag.remove();
            newOther.add(item);
            unionBag.add(item);
        }
        while(!newOther.isEmpty()){
            otherBag.add(newOther.remove());
        }
        return unionBag;
    }

    //Time complexity is O(n^2) as it will have to go through each item in the bag and then search the entire bag for the frequency of said item. 
    //Since .getFrequencyOf() is in O(n), this function is O(n^2) 
    public BagInterface<T> intersection(BagInterface<T> otherBag){
        BagInterface<T> intersectionBag = new ResizableArrayBag<>(otherBag.size() + size);
        BagInterface<T> newOther = new ResizableArrayBag<>(otherBag.size());

        for(T item: bag){
            for(int i = 0; i<otherBag.getFrequencyOf(item);i++){
                intersectionBag.add(item);
                newOther.add(item);
                otherBag.remove(item);
            }
        }

        while(!newOther.isEmpty()){
            otherBag.add(newOther.remove());
        }
        return intersectionBag;

    }

    //Time complexity is O(n^2) as it will have to go through each item in the bag and then search the entire bag for the frequency of said item. 
    //Since .getFrequencyOf() is in O(n), this function is O(n^2)
    public BagInterface<T> difference(BagInterface<T> otherBag){
        BagInterface<T> differenceBag = new ResizableArrayBag<>(otherBag.size() + size);
        BagInterface<T> newOther = new ResizableArrayBag<>(otherBag.size());

        for(T item: bag){
            if(this.getFrequencyOf(item) > otherBag.getFrequencyOf(item)){
                for(int i = 0; i <this.getFrequencyOf(item) - otherBag.getFrequencyOf(item);i++){
                    differenceBag.add(item);
                    newOther.add(item);
                    otherBag.remove(item);
                }
            }
        }
        while(!newOther.isEmpty()){
            otherBag.add(newOther.remove());
        }
        return differenceBag;

    }

}