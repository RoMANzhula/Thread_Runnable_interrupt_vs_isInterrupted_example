public class Main {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock(); //создаем новый обьект типа и поведения класса Часы
        Thread clockThread = new Thread(clock); //создаем новую дочернюю нить для запуска обьекта класса Часы
        clockThread.start(); //запускаем (стартуем) данный поток

        Thread.sleep(10_000); //усыпляем главный поток на 10 секунд
        clockThread.interrupt(); //для потока(нити), созданного для запуска часов, вызываем метод interrupt(), который
        //в свою очередь останавливает работу потока и все потоки завершают свою работу
    }
}