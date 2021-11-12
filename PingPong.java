public class PingPong implements Runnable{
    private Object local; //объект специального суперкласса
    private String name; //имя потока

    public PingPong(Object local, String name){ //конструктор
        this.local = local; //заполнение полей
        this.name = name;
    }

    @Override
    public void run(){
        synchronized (local){ //блокирование доступа другому потоку, если эту часть кода уже использует один поток
            while (true){ //условие бесконечного цикла
                System.out.println(name); //выводим имя потока
                try {
                    Thread.sleep(1000); //остановка одного потока на заданное время (переключаемся на другой поток)
                }
                catch (InterruptedException e1){} //обработка исключений
                local.notify(); //продолжение работы потока, для которого был вызван метод wait()

                try{
                    local.wait(1000); //освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()
                }
                catch (InterruptedException e){} //обработка исключений
            }
        }
    }

    public static void main(String[] args) {
        Object local = new Object(); //объект суперкласса
        Thread ping = new Thread(new PingPong(local, "Ping")); //поток "Ping"
        Thread pong = new Thread(new PingPong(local, "Pong")); //поток "Pong"
        ping.start(); //запускаем потоки
        pong.start();
    }
}
