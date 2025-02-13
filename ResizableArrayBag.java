public class ResizableArrayBag<T> implements BagInterface<T>{

    private int size;
    private Object[] bag;
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

    public boolean isEmpty(){
        return size <= 0;
    }

    public void isFull(){
        if(size == hiddenSize){

        }
    }

    public T[] toArray(){
        
    }
}