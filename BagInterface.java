public abstract interface BagInterface<T>{

    public int size();
    public boolean isEmpty();
    public boolean add(T newItem);
    public T remove();
    public boolean remove(T anItem);
    public void clear();
    public int getFrequencyOf(T anItem);
    public boolean contains(T anItem);
    public T[] toArray();

    public BagInterface<T> union();
    public BagInterface<T> intersection();
    public BagInterface<T> difference();
}