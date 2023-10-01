class Answer {
    public static void arrayOutOfBoundsException() {
        int[] arr = new int[5];
        // Попытка обратиться к элементу, находящемуся за пределами массива
        int value = arr[10];
    }

    public static void divisionByZero() {
        int numerator = 10;
        int denominator = 0;
        // Попытка деления на ноль
        int result = numerator / denominator;
    }

    public static void numberFormatException() {
        String str = "abc";
        // Попытка преобразования строки в число, которое не может быть числом
        int num = Integer.parseInt(str);
    }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
