/**
 * Модуль Логування. Є Спостерігачем, який записує інформацію про всі
 * отримані події у системний лог.
 */
public class LogModule implements Observer {
    private final String name = "LogModule";

    /**
     * Обробляє отримані події, створюючи запис у лозі.
     *
     * @param eventType Тип події.
     * @param message Деталі події.
     */
    @Override
    public void handleEvent(String eventType, String message) {
        // записує подію в лог
        String logEntry = String.format("[%s] Event: %s | Message: %s",
                java.time.LocalDateTime.now(), eventType, message);

        System.out.println("  [" + name + "]: Лог-запис: " + logEntry);
    }
}