package lr9.Example8;

public class LinkedList {
    private Node head;  // Голова списка

    // а) Методы с использованием цикла

    // Создание списка с головы (добавление элементов в начало)
    public void createHead(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            AddFirst(values[i]);  // Добавляем элементы с начала
        }
    }

    // Создание списка с хвоста (добавление элементов в конец)
    public void createTail(int[] values) {
        for (int value : values) {
            AddLast(value);  // Добавляем элементы в конец
        }
    }

    // Преобразование списка в строку (вывод элементов)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");  // Добавляем данные узла в строку
            current = current.next;  // Переходим к следующему узлу
        }
        return sb.toString();
    }

    // Добавление элемента в начало списка
    public void AddFirst(int data) {
        Node newNode = new Node(data);  // Создаем новый узел
        newNode.next = head;  // Новый узел указывает на текущую голову
        head = newNode;  // Новый узел становится головой
    }

    // Добавление элемента в конец списка
    public void AddLast(int data) {
        Node newNode = new Node(data);  // Создаем новый узел
        if (head == null) {
            head = newNode;  // Если список пуст, новый узел становится головой
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;  // Переходим к последнему узлу
            }
            current.next = newNode;  // Добавляем новый узел в конец
        }
    }

    // Вставка элемента на указанную позицию
    public void Insert(int data, int position) {
        if (position == 0) {
            AddFirst(data);  // Если позиция 0, добавляем в начало
        } else {
            Node newNode = new Node(data);  // Создаем новый узел
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current == null) {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
                current = current.next;  // Переходим к узлу перед нужной позицией
            }
            newNode.next = current.next;  // Новый узел указывает на следующий узел
            current.next = newNode;  // Предыдущий узел указывает на новый узел
        }
    }

    // Удаление первого элемента списка
    public void RemoveFirst() {
        if (head != null) {
            head = head.next;  // Голова списка становится следующим узлом
        }
    }

    // Удаление последнего элемента списка
    public void RemoveLast() {
        if (head == null || head.next == null) {
            head = null;  // Если список пуст или содержит один элемент, очищаем его
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;  // Переходим к предпоследнему узлу
            }
            current.next = null;  // Удаляем последний узел
        }
    }

    // Удаление элемента на указанной позиции
    public void Remove(int position) {
        if (position == 0) {
            RemoveFirst();  // Если позиция 0, удаляем первый элемент
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
                current = current.next;  // Переходим к узлу перед нужной позицией
            }
            current.next = current.next.next;  // Удаляем узел, перепрыгивая через него
        }
    }

    // б) Методы с использованием рекурсии

    // Рекурсивное создание списка с головы
    public void createHeadRec(int[] values, int index) {
        if (index < values.length) {
            AddFirst(values[index]);  // Добавляем элемент в начало
            createHeadRec(values, index + 1);  // Рекурсивный вызов для следующего элемента
        }
    }

    // Рекурсивное создание списка с хвоста
    public void createTailRec(int[] values, int index) {
        if (index < values.length) {
            AddLast(values[index]);  // Добавляем элемент в конец
            createTailRec(values, index + 1);  // Рекурсивный вызов для следующего элемента
        }
    }

    // Рекурсивное преобразование списка в строку
    public String toStringRec(Node current) {
        if (current == null) {
            return "";  // Базовый случай: если узел пуст, возвращаем пустую строку
        }
        return current.data + " " + toStringRec(current.next);  // Рекурсивно собираем строку
    }

    // Обертка для рекурсивного вывода списка
    public String toStringRec() {
        return toStringRec(head);  // Запуск рекурсии с головы списка
    }

    // Основной метод для тестирования
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Пример использования методов с циклами
        list.createHead(new int[]{1, 2, 3});
        System.out.println("Список после createHead: " + list.toString());

        list.createTail(new int[]{4, 5, 6});
        System.out.println("Список после createTail: " + list.toString());

        list.AddFirst(0);
        System.out.println("Список после AddFirst: " + list.toString());

        list.AddLast(7);
        System.out.println("Список после AddLast: " + list.toString());

        list.Insert(10, 3);
        System.out.println("Список после Insert: " + list.toString());

        list.RemoveFirst();
        System.out.println("Список после RemoveFirst: " + list.toString());

        list.RemoveLast();
        System.out.println("Список после RemoveLast: " + list.toString());

        list.Remove(2);
        System.out.println("Список после Remove: " + list.toString());

        // Пример использования методов с рекурсией
        LinkedList listRec = new LinkedList();
        listRec.createHeadRec(new int[]{1, 2, 3}, 0);
        System.out.println("Список после createHeadRec: " + listRec.toStringRec());

        listRec.createTailRec(new int[]{4, 5, 6}, 0);
        System.out.println("Список после createTailRec: " + listRec.toStringRec());
    }
}