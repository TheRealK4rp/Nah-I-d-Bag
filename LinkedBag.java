import java.util.HashMap;

public class LinkedBag<T> implements BagInterface<T>{
    private Node<T> head;
    private int bagSize = 0;

    public LinkedBag(){
    }
    
    public LinkedBag(T first){
        head = new Node<>(first);
        bagSize++;
    }
    
    @Override
    public boolean add(T item){
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        /*
        if(isEmpty()){
            head = node;
        }else{
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        } */
        bagSize++;
        return true;
    }

    public void printList(){
        Node<T> temp = head;
        while(temp != null){
            temp = temp.next;
            System.out.println(temp.data);
        }
        
    }


    class Node<O>{
        public O data;
        public Node<O> next;

        public Node(O data){
            this.data = data;
            this.next = null;
        }

        public Node(O data, Node<O> next){
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return bagSize;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T remove() {
        if(isEmpty()) throw new NullPointerException("Empty Bag");
        T tempData = head.data;
        head = head.next;
        bagSize--;
        return tempData;
    }

    @Override
    public boolean remove(T anItem) {
        if(head == null){
            return false;
        }

        if(head.data == anItem){
            head = head.next;
            return true;
        }
        Node<T> temp = head;
        Node<T> save = temp.next;
        while(save != null){
            if(save.data == anItem){
                temp.next = save.next;
                bagSize--;
                return true;
            }else{
                temp = save;
                save = save.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        bagSize = 0;
    }

    @Override
    public int getFrequencyOf(T anItem) {
        int result = 0;
        Node<T> temp = head;
        while(temp != null){
            if (temp.data == anItem) {
                result++;                
            }
            temp = temp.next;
        }
        return result;
    }

    @Override
    public boolean contains(T anItem) {
        Node<T> temp = head;
        while(temp != null){
            if (temp.data == anItem) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //Time complexity: O(n), adding all of the contents into a new bag is size n + n = O(n)
    @Override
    public BagInterface<T> union(BagInterface<T> other) {
        BagInterface<T> newBag = new LinkedBag<>();
        BagInterface<T> newOther = new LinkedBag<>();

        Node<T> temp = head;
        while(temp != null){
            newBag.add(temp.data);
            temp = temp.next;
        }

        while(!other.isEmpty()){
            T data = other.remove();
            newOther.add(data);
            newBag.add(data);
        }

        while(!newOther.isEmpty()){
            other.add(newOther.remove());
        }

        return newBag;
    }


    //time complexity: O(n^2), for every item in the bag they count how many are in it. Because .getFrequency is O(n) itself, this has to go through every item, therefore O(n^2)
    @Override
    public BagInterface<T> intersection(BagInterface<T> other) {
        BagInterface<T> newBag = new LinkedBag<>();
        HashMap<T, Integer> map = new HashMap<>();
        Node<T> temp = head;
        
        while(temp != null){
            map.putIfAbsent(temp.data, other.getFrequencyOf(temp.data));
            if(map.get(temp.data) >= 1){
                newBag.add(temp.data);
                map.put(temp.data, map.getOrDefault(temp.data, 1) -1);
            }
            temp = temp.next;
        }
        return newBag;
    }

    //time complexity: O(n^2), for every item in the bag they count how many are in it. Because .getFrequency is O(n) itself, this has to go through every item, therefore O(n^2)
    @Override
    public BagInterface<T> difference(BagInterface<T> other) {
        BagInterface<T> newBag = new LinkedBag<>();
        HashMap<T, Integer> map = new HashMap<>();
        Node<T> temp = head;

        while(temp != null){
            map.putIfAbsent(temp.data, other.getFrequencyOf(temp.data));
            if(map.get(temp.data) < 1){
                newBag.add(temp.data);
            }
            map.put(temp.data, map.getOrDefault(temp.data, 1) -1);
            temp = temp.next;
        }
        return newBag;
    }
}