import java.util.*;

public class Test_queue {
    public static Integer whoIsWin(Integer pl1, Integer pl2) {
        if (pl1 == 0 && pl2 == 9)
            return pl1;
        if (pl2 == 0 && pl1 == 9)
            return pl2;
        return pl1 > pl2 ? pl1 : pl2;
    }
    public static void main(String[] args) {
        //упражнение 2
        Queue<Integer> player1 = new LinkedList<>(); //очередь первого игрока
        Queue<Integer> player2 = new LinkedList<>(); //очередь второго игрока
        System.out.println("Input 5 cards for the first player:");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
            player1.add(in.nextInt());
        System.out.println("Input 5 cards for the second player:");
        for (int i = 0; i < 5; i++)
            player2.add(in.nextInt());
        int k = 0; //количество ходов
        while (player1.isEmpty() != true) //ход игры
            if (player2.isEmpty() != true) {
                k++;
                int f_pl = player1.peek(); //карта первого игрока
                int s_pl = player2.peek(); //второго игрока
                if (whoIsWin(f_pl, s_pl) == f_pl) {
                    Queue<Integer> pl_1_reserve = new LinkedList<>(); //очередь для сохранения карт первого игрока
                    player1.remove(); //удаляем карту у первого игрока
                    int st_size = player1.size(); //размер очереди (количество переписываемых данных)
                    for (int i = 0; i < st_size; i++) { //переписываем данные из очереди первого игрока в резервный стек
                        pl_1_reserve.add(player1.peek());
                        player1.remove();
                    }
                    for (int i = 0; i < st_size; i++) { //возвращаем старые карты первого игрока обратно в очередь
                        player1.add(pl_1_reserve.peek());
                        pl_1_reserve.remove();
                    }
                    if (k % 2 == 1) {
                        player1.add(f_pl); //кладем в очередь первого игрока карту второго игрока
                        player1.add(s_pl); //кладем в очередь первого игрока его карту
                    }
                    else {
                        player1.add(s_pl); //кладем в очередь первого игрока карту второго игрока
                        player1.add(f_pl); //кладем в очередь первого игрока его карту
                    }
                    player2.remove(); //удаляем карту у второго игрока (меньшую)
                }
                else {
                    Queue<Integer> pl_2_reserve = new LinkedList<>(); //очередь для сохранения карт второго игрока
                    player2.remove(); //удаляем карту у второго игрока
                    int st_size = player2.size(); //размер очереди (количество переписываемых данных)
                    for (int i = 0; i < st_size; i++) {//переписываем данные из очереди второго игрока в резервный стек
                        pl_2_reserve.add(player2.peek());
                        player2.remove();
                    }
                    for (int i = 0; i < st_size; i++) { //возвращаем старые карты первого игрока обратно в очередь
                        player2.add(pl_2_reserve.peek());
                        pl_2_reserve.remove();
                    }
                    if (k % 2 == 1) {
                        player2.add(f_pl); //кладем в очередь первого игрока карту второго игрока
                        player2.add(s_pl); //кладем в очередь первого игрока его карту
                    }
                    else {
                        player2.add(s_pl); //кладем в очередь первого игрока карту второго игрока
                        player2.add(f_pl); //кладем в очередь первого игрока его карту
                    }
                    player1.remove(); //удаляем карту у первого игрока(меньшую)
                }
                if (k >= 106) {
                    System.out.println("botva");
                    return;
                }
            }
            else break;
        if (player1.isEmpty() == true)
            System.out.println("second " + k);
        else
        if (player2.isEmpty() == true)
            System.out.println("first " + k);
    }
}