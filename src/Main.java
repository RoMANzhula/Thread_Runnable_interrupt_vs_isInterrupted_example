public class Main {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock(); //створюємо новий об'єкт типу та поведінки класу Часи
        Thread clockThread = new Thread(clock); //створюємо новий дочірній потік для запуску об'єкта класу Часи
        clockThread.start(); //запускаємо (стартуємо) цей потік

        Thread.sleep(10_000); //зупиняємо головний потік на 10 секунд
        clockThread.interrupt(); //для потоку, створеного для запуску годин, викликаємо метод interrupt(), який
        //в свою чергу зупиняє роботу потоку, і всі потоки завершують свою роботу
    }
}
