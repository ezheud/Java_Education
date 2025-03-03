package lr9.Example7;

import java.util.LinkedList;

//LinkedList будет работать быстрее в данной задаче, так как удаление элементов из середины списка выполняется быстрее,
// чем в ArrayList.
//ArrayList будет медленнее из-за необходимости сдвигать элементы при каждом удалении.

public class example7 {
    public static void main(String[] args) {
        int N = 10; // Количество человек
        LinkedList<Integer> circle = new LinkedList<>();

        // Заполняем круг номерами от 1 до N
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        int index = 0;
        while (circle.size() > 1) {
            index = (index + 1) % circle.size(); // Вычеркиваем каждого второго
            circle.remove(index);
        }

        System.out.println("Оставшийся человек: " + circle.get(0));
    }
}