/**
 * Головний клас програми (Client).
 * Відповідає за ініціалізацію системи, створення об'єктів-Спостерігачів (модулів),
 * підписку їх на єдиний EventManager (Singleton/Subject) та демонстрацію
 * генерації та обробки подій.
 */
public class Main {

    /**
     * Точка входу в програму. Демонструє роботу шаблонів Singleton та Observer.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        EventManager manager = EventManager.getInstance();

        AuthModule authModule = new AuthModule();
        LogModule logModule = new LogModule();
        UserInterface uiModule = new UserInterface();

        System.out.println("--- Налаштування підписників ---");
        manager.subscribe(authModule);
        manager.subscribe(logModule);
        manager.subscribe(uiModule);

        authModule.authorizeUser("sa1dake");

        System.out.println("\n*** Main генерує подію: Користувач вийшов.");
        manager.notifySubscribers("USER_LOGOUT", "Користувач вийшов з системи.");

        System.out.println("\n*** Main генерує подію: Помилка доступу.");
        manager.notifySubscribers("ACCESS_ERROR", "Спроба входу з невірним паролем.");
    }
}