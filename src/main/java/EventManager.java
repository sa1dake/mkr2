import java.util.ArrayList;
import java.util.List;

/**
 * Менеджер Подій (Subject/Singleton).
 * Реалізує шаблон Singleton, забезпечуючи єдиний екземпляр у програмі.
 * Виступає як видавець (Subject) у шаблоні Observer, керуючи підписниками.
 */
public class EventManager {

    private static EventManager instance;

    private final List<Observer> subscribers = new ArrayList<>();

    /**
     * Приватний конструктор, щоб запобігти створенню екземплярів ззовні.
     */
    private EventManager() {}

    /**
     * Повертає єдиний екземпляр EventManager.
     *
     * @return Єдиний екземпляр EventManager.
     */
    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    /**
     * Додає модуль до списку підписників (Observer).
     *
     * @param observer Об'єкт, який реалізує інтерфейс Observer і бажає отримувати сповіщення.
     */
    public void subscribe(Observer observer) {
        subscribers.add(observer);
        System.out.println("-> Підписано: " + observer.getClass().getSimpleName());
    }

    /**
     * Видаляє модуль зі списку підписників.
     *
     * @param observer Об'єкт, який потрібно відписати.
     */
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
        System.out.println("-> Відписано: " + observer.getClass().getSimpleName());
    }

    /**
     * Сповіщає всіх підписаних Observer про нову подію.
     *
     * @param eventType Тип події.
     * @param message Деталі події.
     */
    public void notifySubscribers(String eventType, String message) {
        System.out.println("\n--- EventManager: Нова подія: " + eventType + " ---");
        for (Observer subscriber : subscribers) {
            subscriber.handleEvent(eventType, message);
        }
    }
}