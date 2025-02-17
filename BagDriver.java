public class BagDriver{
    public static void main(String[] args){
        LinkedBag<String> a = new LinkedBag<>();
        //a.add("Yes");
        a.add("no");
        a.add("test");
        ResizableArrayBag<String> b = new ResizableArrayBag<>();
        b.add("Hi");
        b.add("bye");
        BagInterface<String> c = b.union(a);
        System.out.println(c.size());
        while(!c.isEmpty()){
            System.out.println(c.remove());
        }
    }
}