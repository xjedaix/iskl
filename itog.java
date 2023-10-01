import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол");
            String input = scanner.nextLine();

            try {
                String[] userData = input.split(" ");
                if (userData.length != 6) {
                    throw new IllegalArgumentException("Неверное количество данных.");
                }

                String lastName = userData[0];
                String firstName = userData[1];
                String middleName = userData[2];
                Date birthDate = parseDate(userData[3]);
                long phoneNumber = Long.parseLong(userData[4]);
                char gender = parseGender(userData[5]);

                String fileName = lastName + ".txt";
                String userRecord = lastName + firstName + middleName + formatDate(birthDate) + phoneNumber + gender;

                appendToFile(fileName, userRecord);

                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            } catch (ParseException | NumberFormatException e) {
                System.err.println("Ошибка формата данных: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }

            System.out.println("Хотите ввести еще данные? (да/нет)");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("да")) {
                break;
            }
        }

        scanner.close();
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        return dateFormat.parse(dateString);
    }

    private static char parseGender(String genderString) {
        if (genderString.equalsIgnoreCase("m")) {
            return 'm';
        } else if (genderString.equalsIgnoreCase("f")) {
            return 'f';
        } else {
            throw new IllegalArgumentException("Недопустимое значение пола.");
        }
    }

    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        return dateFormat.format(date);
    }

    private static void appendToFile(String fileName, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(content + System.lineSeparator());
        }
    }
}
