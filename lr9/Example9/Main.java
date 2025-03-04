package lr9.Example9;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Создаем коллекции
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Количество элементов для тестирования
        int n = 100000;

        // Замер времени для операций с ArrayDeque
        System.out.println("ArrayDeque:");
        System.out.println("Добавление в начало: " + addToBeginning(arrayDeque, n) + " мс");
        System.out.println("Добавление в конец: " + addToEnd(arrayDeque, n) + " мс");
        System.out.println("Удаление из начала: " + removeFromBeginning(arrayDeque, n) + " мс");
        System.out.println("Удаление из конца: " + removeFromEnd(arrayDeque, n) + " мс");

        // Замер времени для операций с TreeSet
        System.out.println("\nTreeSet:");
        System.out.println("Добавление элементов: " + addToTreeSet(treeSet, n) + " мс");
        System.out.println("Удаление элементов: " + removeFromTreeSet(treeSet, n) + " мс");
        System.out.println("Получение элементов: " + getFromTreeSet(treeSet, n) + " мс");

        // Замер времени для операций с ArrayList
        System.out.println("\nArrayList:");
        System.out.println("Добавление в начало: " + addToBeginning(arrayList, n) + " мс");
        System.out.println("Добавление в середину: " + addToMiddle(arrayList, n) + " мс");
        System.out.println("Добавление в конец: " + addToEnd(arrayList, n) + " мс");
        System.out.println("Удаление из начала: " + removeFromBeginning(arrayList, n) + " мс");
        System.out.println("Удаление из середины: " + removeFromMiddle(arrayList, n) + " мс");
        System.out.println("Удаление из конца: " + removeFromEnd(arrayList, n) + " мс");
        System.out.println("Получение по индексу: " + getByIndex(arrayList, n) + " мс");
    }

    // Методы для ArrayDeque

    // Добавление в начало ArrayDeque
    private static long addToBeginning(ArrayDeque<Integer> deque, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            deque.addFirst(i);
        }
        return System.currentTimeMillis() - start;
    }

    // Добавление в конец ArrayDeque
    private static long addToEnd(ArrayDeque<Integer> deque, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            deque.addLast(i);
        }
        return System.currentTimeMillis() - start;
    }

    // Удаление из начала ArrayDeque
    private static long removeFromBeginning(ArrayDeque<Integer> deque, int n) {
        for (int i = 0; i < n; i++) {
            deque.addLast(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            deque.removeFirst();
        }
        return System.currentTimeMillis() - start;
    }

    // Удаление из конца ArrayDeque
    private static long removeFromEnd(ArrayDeque<Integer> deque, int n) {
        for (int i = 0; i < n; i++) {
            deque.addLast(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            deque.removeLast();
        }
        return System.currentTimeMillis() - start;
    }

    // Методы для ArrayList

    // Добавление в начало ArrayList
    private static long addToBeginning(ArrayList<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0, i); // Добавляем в начало
        }
        return System.currentTimeMillis() - start;
    }

    // Добавление в середину ArrayList
    private static long addToMiddle(ArrayList<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(list.size() / 2, i); // Добавляем в середину
        }
        return System.currentTimeMillis() - start;
    }

    // Добавление в конец ArrayList
    private static long addToEnd(ArrayList<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(i); // Добавляем в конец
        }
        return System.currentTimeMillis() - start;
    }

    // Удаление из начала ArrayList
    private static long removeFromBeginning(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.remove(0); // Удаляем из начала
        }
        return System.currentTimeMillis() - start;
    }

    // Удаление из середины ArrayList
    private static long removeFromMiddle(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.remove(list.size() / 2); // Удаляем из середины
        }
        return System.currentTimeMillis() - start;
    }

    // Удаление из конца ArrayList
    private static long removeFromEnd(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.remove(list.size() - 1); // Удаляем из конца
        }
        return System.currentTimeMillis() - start;
    }

    // Получение элемента по индексу в ArrayList
    private static long getByIndex(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.get(i); // Получаем элемент по индексу
        }
        return System.currentTimeMillis() - start;
    }

    // Методы для TreeSet

    // Добавление элементов в TreeSet
    private static long addToTreeSet(TreeSet<Integer> set, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    // Удаление элементов из TreeSet
    private static long removeFromTreeSet(TreeSet<Integer> set, int n) {
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            set.remove(i);
        }
        return System.currentTimeMillis() - start;
    }

    // Получение элементов из TreeSet
    private static long getFromTreeSet(TreeSet<Integer> set, int n) {
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            set.contains(i); // Проверяем наличие элемента
        }
        return System.currentTimeMillis() - start;
    }
}