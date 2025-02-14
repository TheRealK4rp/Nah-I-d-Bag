public class LinkedBag<T>{
    T data;
    LinkedBag<T> next;

    public LinkedBag(){
        data = null;
        next = null;
    }
    
    public LinkedBag(T item){
        data = item;
        next = null;
    }

    //uh i think this is how it works
    public boolean add(T item){
        LinkedBag<T> n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = new LinkedBag<>(item);
        return true;
    }

    public void printList(){
        LinkedBag<T> n = this;
        while(n.next != null){
            n = n.next;
            System.out.println(n.data);
        }
        
    }
}