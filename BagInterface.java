public abstract interface BagInterface<T>{

    public int size();
    public boolean isEmpty();
    public boolean add(T newItem);
    public T remove();
    public boolean remove(T anItem);
    public void clear();
    public int getFrequencyOf(T anItem);
    public boolean contains(T anItem);
    
    public BagInterface<T> union(BagInterface<T> other);
    public BagInterface<T> intersection(BagInterface<T> other);
    public BagInterface<T> difference(BagInterface<T> other);
}