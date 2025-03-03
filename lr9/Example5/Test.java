package lr9.Example5;

public class Test {
    public static void main(String[] args) {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }
        Node ref = head;
        System.out.println("Односвязный список с хвоста");
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}