public class BagDriver{
    public static void main(String[] args) {
        useDifference();
    }

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

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }

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

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }


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

        while(!newBag.isEmpty()){
            System.out.println(newBag.remove());
        }

    }
}