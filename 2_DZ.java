class Answer {
    public static int[] subArrays(int[] a, int[] b) {
        // Проверяем, равны ли длины массивов
        if (a.length != b.length) {
            // Если длины не равны, вернем массив длины 1 со значением 0
            return new int[]{0};
        }

        // Создаем новый массив для хранения разностей
        int[] c = new int[a.length];

        // Вычисляем разности элементов и записываем их в массив c
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }

        return c;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int[] result = Answer.subArrays(array1, array2);

        // Выводим результат
        for (int value : result) {
            System.out.print(value + " ");
