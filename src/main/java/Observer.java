/**
 * Інтерфейс Спостерігача (Observer).
 * Визначає метод, який має бути викликаний для сповіщення модулів-підписників
 * про будь-яку нову подію в системі.
 */
public interface Observer {

    /**
     * Обробляє подію, що надійшла від EventManager.
     *
     * @param eventType Тип події (наприклад, "USER_LOGIN", "ACCESS_ERROR").
     * @param message Деталізоване повідомлення, пов'язане з подією.
     */
    void handleEvent(String eventType, String message);
}