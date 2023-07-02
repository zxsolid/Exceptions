package Seminar2;

/* Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя
 */
public class Task4 {
    public static void main(String[] args) {
        String str;
        while (true) {
            try {
                str = ConsoleInput.inputString("Введите строку: ");
                break;
            } catch (StringInputException e) {
                System.out.println("Строка не должна быть пустой");
                ;
            }
        }
        System.out.println("Введена строка:"+str);
    }
}