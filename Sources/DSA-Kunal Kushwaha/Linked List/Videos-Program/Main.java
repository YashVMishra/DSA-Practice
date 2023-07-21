public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 3);
        list.insert(5, 4);
        list.insertRec(7, 2);

        // list.display();

        // Doubly_LL list = new Doubly_LL();
        // list.insert(1, 0);
        // list.insert(2, 1);
        // list.insert(3, 2);
        // list.insert(4, 3);
        // list.insert(5, 4);
        // list.insert(6, 5);

        // list.display();

        // Circular_LL list = new Circular_LL();
        // list.insertLast(5);
        // list.insertLast(6);
        // list.insertLast(7);
        // list.insertLast(8);
        // list.delete(5);

        list.display();
    }

}