import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Clock implements Runnable {
    @Override //обязательный метод для реализации класса Runnable
    public void run() {
        Thread current = Thread.currentThread(); //для текущего объекта данного класса получаем текущий объект вызвавшей его нити

        while (!current.isInterrupted()) { //пока данный поток не был прерван (т.е. пока метод проверки isInterrupted() = false)
            try { //будем пытаться
                Thread.sleep(1000); //усыплять поток на 1 секунду
            } catch (InterruptedException interruptedException) { //пытаемся ловить прерванное исключение
                interruptedException.printStackTrace(); //выводим стек для данного исключения
                current.interrupt(); //для данного потока вызываем метод interrupt(), чтобы установить потоку статус -
                // прерван (чтоб вернуть true)
            }

            if ((System.currentTimeMillis() / 1000) % 2 == 0) { //если текущее время в секундах при остатке от деления на 2 будет четным, то
                System.out.println("Tik"); //выводим в консоль Tik
            } else { //иначе
                System.out.println("Tak"); //выводим в консоль Tak
            }


        }
    }
}
