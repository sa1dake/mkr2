/**
 * Модуль Авторизації. Є Спостерігачем, який обробляє події,
 * пов'язані з авторизацією, а також може сам генерувати події.
 */
public class AuthModule implements Observer {
    private final String name = "AuthModule";

    /**
     * Обробляє отримані події.
     *
     * @param eventType Тип події.
     * @param message Деталі події.
     */
    @Override
    public void handleEvent(String eventType, String message) {
        // генерує повідомлення та виводить на екран
        if (eventType.equals("USER_LOGIN")) {
            System.out.println("  [" + name + "]: Користувач успішно авторизувався.");
        } else if (eventType.equals("ACCESS_ERROR")) {
            System.out.println("  [" + name + "]: !!! ПОМИЛКА: Спроба несанкціонованого доступу.");
        }
    }

    /**
     * Ініціює процес авторизації користувача і, у разі успіху, 
     * сповіщає EventManager про подію "USER_LOGIN".
     *
     * @param username Ім'я користувача, який авторизується.
     */
    public void authorizeUser(String username) {
        System.out.println("\n*** " + name + " генерує подію: " + username + " увійшов.");
        EventManager.getInstance().notifySubscribers("USER_LOGIN", "Користувач '" + username + "' увійшов.");
    }
}