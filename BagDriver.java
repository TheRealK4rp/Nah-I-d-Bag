import java.util.ArrayList;
public class BagDriver{
    public static void main(String[] args){
        ResizableArrayBag<String> test = new ResizableArrayBag<>();
        test.add("Hi");
        test.add("Hi");
        test.add("No");
        test.add("something");
        System.out.println(test.remove());
        Object[] out = test.toArray();
        System.out.println(out[0]);
        ArrayList<String> t = new ArrayList<>();
        t.remove("yes");
    }    
}