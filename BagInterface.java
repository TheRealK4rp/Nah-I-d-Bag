/** An interface that describes the operations of a bag of objects. */
public interface BagInterface<T>{

    /** Gets the current number of entries in this bag.
        @return The integer number of entries currently in the bag.
    */
    public int size();

    /** Sees whether this bag is empty.
        @return True if the bag is empty, or false if not. 
    */
    public boolean isEmpty();
    
    /** Adds a new entry to this bag.
        @param newEntry The object to be added as a new entry.
        @return True if the addition is successful, or false if not. 
    */
    public boolean add(T newEntry);
    
    /** Removes one unspecified entry from this bag, if possible.
        @return Either the removed entry, if the removal was successful, or null.
    */
    public T remove();
    
    /** Removes one occurrence of a given entry from this bag, if possible.
        @param anEntry The entry to be removed.
        @return True if the removal was successful, or false if not.
    */
    public boolean remove(T anEntry);
    
    /** Removes all entries from this bag. */
    public void clear();
    
    /** Counts the number of times a given entry appears in this bag.
        @param anEntry The entry to be counted.
        @return The number of times anEntry appears in the bag. 
    */
    public int getFrequencyOf(T anEntry);

    /** Tests whether this bag contains a given entry.
        @param anEntry The entry to find.
        @return True if the bag contains anEntry, or false if not. 
    */
    public boolean contains(T anEntry);

    /** Combines all entries of 2 bags without changing the bags itself
        @param other The bag to union with this bag.
        @return new bag that is the combination of both bags
    */
    public BagInterface<T> union(BagInterface<T> other);

    /** Creates a new bag that only contains the same objects that both bags have
        @param other The bag to intersect with this bag
        @return new bag that is the intersection of both bags
    */
    public BagInterface<T> intersection(BagInterface<T> other);

    /** Creates a new bag with entries after removing this bags entries from the other bag
        @param other The bag with entries to remove from this bag
        @return New bag with entries that are the difference between the two bags.
    */
    public BagInterface<T> difference(BagInterface<T> other);
}