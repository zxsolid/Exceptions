package Seminar3.appPacket;

import Seminar3.exception.InterruptApp;
import Seminar3.exception.InvalidUserDataException;

import java.util.regex.Pattern;

public class UserInput {
    // Константы для проверки количества введенных данных
    private static final int REQUIRED_FIELD_COUNT = 6;
    private static final int MINIMUM_FIELD_COUNT = 5;

    // Метод для получения данных пользователя из консоли
    public static UserData getUserDataFromConsole() throws InvalidUserDataException, InterruptApp {
        String input = ConsoleInput.Input("Введите данные пользователя через пробел или EXIT для выхода\n" +
                "(Фамилия Имя Отчество дд.мм.гггг +7НомерТелефона М/Ж(M/F))\n::");

        // Выход из приложения
        if ("exit".equalsIgnoreCase(input)) {
            throw new InterruptApp();
        }
        // Разделение введенной строки на отдельные поля
        String[] fields = input.split(" ");

        // Проверка количества введенных данных
        if (fields.length < MINIMUM_FIELD_COUNT) {
            throw new InvalidUserDataException("Вы ввели слишком мало данных");
        }
        if (fields.length > REQUIRED_FIELD_COUNT) {
            throw new InvalidUserDataException("Вы ввели слишком много данных");
        }

        // Извлечение данных из полей
        String lastName = fields[0];
        String firstName = fields[1];
        String middleName = fields[2];

        String birthDate;
        String phoneNumber;
        char gender;

        birthDate = fields[3];
        if (isNotValidDate(birthDate)) {
            throw new InvalidUserDataException("Неверный формат поля ДАТА\n(вводите дату в формате ДД.ММ.ГГГГ)");
        }
        phoneNumber = fields[4];
        if (phoneNumber.length() != 12) {
            throw new InvalidUserDataException("Неверный формат поля НОМЕР ТЕЛЕФОНА \n(вводите номер в федеральном формате через +7");
        }
        gender = Character.toUpperCase(fields[5].charAt(0));
        if (gender != 'М' && gender != 'Ж' && gender != 'M' && gender != 'F') {
            throw new InvalidUserDataException("Неверный формат поля ПОЛ\n(вводите М/Ж или M/F");
        }

        return new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }

    // проверка формата для даты рождения
    public static boolean isNotValidDate(String dateString) {
        Pattern datePattern = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
        return !datePattern.matcher(dateString).matches();
    }
}