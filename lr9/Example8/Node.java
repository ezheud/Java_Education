package lr9.Example8;

public class Node {
    public int data;       // Данные узла
    public Node next;      // Ссылка на следующий узел

    // Конструктор для создания узла с данными
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}