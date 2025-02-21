public class BagDriver{
    public static void main(String[] args) {
        useUnion();
        useUnion2();
        useIntersection();
        useIntersection2();  
        useDifference();
        useDifference2();
    }

    //linkedBag union arraybag
    public static void useUnion(){
        BagInterface<Integer> linkedBag = new LinkedBag<>();
        BagInterface<Integer> arrBag = new ResizableArrayBag<>();

        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);

        arrBag.add(3);
        arrBag.add(4);
        arrBag.add(5);

        BagInterface<Integer> newBag = linkedBag.union(arrBag);
        
        System.out.println("linkedBag union arraybag");

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }
    }

    //arraybag union linkedbag
    public static void useUnion2(){
        BagInterface<Integer> linkedBag = new LinkedBag<>();
        BagInterface<Integer> arrBag = new ResizableArrayBag<>();

        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);

        arrBag.add(3);
        arrBag.add(4);
        arrBag.add(5);

        BagInterface<Integer> newBag = arrBag.union(linkedBag);
        
        System.out.println("arraybag union linkedbag");
        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }
    }

    //linkedbag intersect arraybag
    public static void useIntersection(){
        BagInterface<Integer> linkedBag = new LinkedBag<>();
        BagInterface<Integer> arrBag = new ResizableArrayBag<>();

        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);

        arrBag.add(3);
        arrBag.add(4);
        arrBag.add(5);

        BagInterface<Integer> newBag = linkedBag.intersection(arrBag);

        System.out.println("linkedbag intersect arraybag");

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }

    //arraybag intersect linkedbag
    public static void useIntersection2(){
        BagInterface<Integer> linkedBag = new LinkedBag<>();
        BagInterface<Integer> arrBag = new ResizableArrayBag<>();

        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);

        arrBag.add(3);
        arrBag.add(4);
        arrBag.add(5);

        BagInterface<Integer> newBag = arrBag.intersection(linkedBag);

        System.out.println("arraybag intersect linkedbag");

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }

    //linkedbag difference arrbag
    public static void useDifference(){
        BagInterface<Integer> linkedBag = new LinkedBag<>();
        BagInterface<Integer> arrBag = new ResizableArrayBag<>();

        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);

        arrBag.add(3);
        arrBag.add(4);
        arrBag.add(5);

        BagInterface<Integer> newBag = linkedBag.difference(arrBag);

        System.out.println("linkedbag difference arrbag");

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }

    //arraybag difference linkedbag
    public static void useDifference2(){
        BagInterface<Integer> linkedBag = new LinkedBag<>();
        BagInterface<Integer> arrBag = new ResizableArrayBag<>();

        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);

        arrBag.add(3);
        arrBag.add(4);
        arrBag.add(5);

        BagInterface<Integer> newBag = arrBag.difference(linkedBag);

        System.out.println("arraybag difference linkedbag");

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }
}