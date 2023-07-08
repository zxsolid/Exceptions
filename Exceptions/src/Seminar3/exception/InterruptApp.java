package Seminar3.exception;

/**
 * класс для отслеживания команды выхода из приложения
 */
public class InterruptApp extends RuntimeException{
    public InterruptApp() {
        super("");
    }
}
