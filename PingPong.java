class Ping extends Thread{ //класс, выводящий "Ping"
    public void run(){
        while (true){ //условие бесконечного цикла
            System.out.println("Ping"); //вывод надписи
            try{
                sleep(1000); //задержка потока
            }
            catch (Exception e){} //обработка возможного исключения
        }
    }
}

class Pong extends Thread{ //класс, выводящий "Pong"
    public void run(){
        while (true){ //условие бесконечного цикла
            System.out.println("Pong"); //вывод надписи
            try{
                sleep(1000); //задержка потока
            }
            catch (Exception e){} //обработка возможного исключения
        }
    }
}

public class PingPong {
    public static void main(String[] args) throws Exception{
        Ping ping = new Ping();
        Pong pong = new Pong();
        ping.start(); //запускаем первый поток
        Thread.sleep(500); //задержка перед запуском второго потока
        pong.start(); //запускаем второй поток
        ping.join(); //первый поток в ожидании завершения второго потока
    }
}
