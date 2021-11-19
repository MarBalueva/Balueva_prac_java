import java.util.Scanner;

public class Horse {
    private static int n; //количество лошадей

    public static void main(String[] args) {
        System.out.println("Введите количество лошадей: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //чтение количества лошадей
        System.out.println("Результаты гонки (от первого финишируемого к последнему):");
        for (int i = 1; i <= n; i++){ //создание потоков
            Thread t = new Thread(new Race());
            t.setName("Лошадь " + i); //имя потока
            t.start(); //запуск потока
        }
    }
}

class Race extends Thread{
    public synchronized void run() { //новый поток не ждет окончания работы предыдущего
        System.out.println(Thread.currentThread().getName()); //вывод имени потока
        try {
            Thread.sleep(1000); //задержка текущего потока
        }
        catch (InterruptedException e){} //обработка возможных исключений
    }
}
