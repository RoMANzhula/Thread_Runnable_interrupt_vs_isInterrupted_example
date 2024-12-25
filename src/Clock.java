import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Clock implements Runnable {
    @Override //обов'язковий метод для реалізації інтерфейсу Runnable
    public void run() {
        Thread current = Thread.currentThread(); //для поточного об'єкта цього класу отримуємо поточний об'єкт потоку, що викликав його

        while (!current.isInterrupted()) { //поки цей потік не буде перерваний (тобто, поки метод перевірки isInterrupted() повертає false)
            try { //спробуємо
                Thread.sleep(1000); //засинаємо потік на 1 секунду
            } catch (InterruptedException interruptedException) { //спробуємо ловити перерване виключення
                interruptedException.printStackTrace(); //виводимо стек для цього виключення
                current.interrupt(); //для цього потоку викликаємо метод interrupt(), щоб встановити потоку статус -
                // перервано (щоб повернути true)
            }

            if ((System.currentTimeMillis() / 1000) % 2 == 0) { //якщо поточний час у секундах при залишку від ділення на 2 буде парним, то
                System.out.println("Tik"); //виводимо в консоль "Tik"
            } else { //інакше
                System.out.println("Tak"); //виводимо в консоль "Tak"
            }
        }
    }
}
