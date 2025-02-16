public class BagDriver{
    public static void main(String[] args) {
        LinkedBag<String> t = new LinkedBag<>();
        t.add("Hi");
        t.add("How");
        t.add("Are");
        t.add("You?");
        t.printList();
    }
}