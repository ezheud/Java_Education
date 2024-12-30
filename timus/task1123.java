import java.util.Scanner;

    public class task1123 {


        // Программа пересчитывает заработную плату сотрудника и придает ей вид палиндрома.


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите заработную плату сотрудника: ");
        String salary = scanner.nextLine().trim();
        String result = nextPalindrome(salary);
        System.out.println(result);
}

    private static String nextPalindrome(String s) {
        int n = s.length();

        // Проверка на палиндром
        if (isPalindrome(s)) {
            return s;
        }

        // Разделяем строку на две части
        String leftHalf = s.substring(0, (n + 1) / 2);
        String palindrome = createPalindrome(leftHalf, n % 2 == 0);

        // Если палиндром меньше текущей зарплаты, увеличиваем левую половину
        if (palindrome.compareTo(s) >= 0) {
            return palindrome;
        }

        // Увеличиваем центральную часть
        String incrementedLeftHalf = increment(leftHalf);
        return createPalindrome(incrementedLeftHalf, n % 2 == 0);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static String createPalindrome(String half, boolean isEven) {
        StringBuilder palindrome = new StringBuilder(half);
        if (isEven) {
            palindrome.append(new StringBuilder(half).reverse());
        } else {
            palindrome.append(new StringBuilder(half).reverse().substring(1));
        }
        return palindrome.toString();
    }

    private static String increment(String s) {
        StringBuilder incremented = new StringBuilder(s);
        int carry = 1, i = incremented.length() - 1;

        while (i >= 0 && carry > 0) {
            int digit = incremented.charAt(i) - '0' + carry;
            if (digit == 10) {
                incremented.setCharAt(i, '0');
                carry = 1;
            } else {
                incremented.setCharAt(i, (char) (digit + '0'));
                carry = 0;
            }
        }

        // Если остался перенос, нужно добавить '1' в начало
        if (carry > 0) {
            incremented.insert(0, '1');
        }
        return incremented.toString();
    }
}
