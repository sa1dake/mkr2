/**
 * Модуль Інтерфейсу Користувача. Є Спостерігачем, який відображає 
 * відповідні повідомлення на екрані користувача при отриманні подій.
 */
public class UserInterface implements Observer {
    private final String name = "UserInterface";

    /**
     * Обробляє отримані події, відображаючи повідомлення користувачу.
     *
     * @param eventType Тип події.
     * @param message Деталі події.
     */
    @Override
    public void handleEvent(String eventType, String message) {
        if (eventType.equals("USER_LOGIN")) {
            System.out.println("  [" + name + "]: Ласкаво просимо! Авторизація успішна.");
        } else if (eventType.equals("USER_LOGOUT")) {
            System.out.println("  [" + name + "]: До побачення. Ви вийшли з системи.");
        }
    }
}