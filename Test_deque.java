import java.util.*;

public class Test_deque {
    public static Integer whoIsWin(Integer pl1, Integer pl2) {
        if (pl1 == 0 && pl2 == 9)
            return pl1;
        if (pl2 == 0 && pl1 == 9)
            return pl2;
        return pl1 > pl2 ? pl1 : pl2;
    }
    public static void main(String[] args) {
        //упражнение 3
        Deque<Integer> player1 = new LinkedList<>(); //дек первого игрока
        Deque<Integer> player2 = new LinkedList<>(); //дек второго игрока
        System.out.println("Input 5 cards for the first player:");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) //заполнили карты первого игрока
            player1.addLast(in.nextInt());
        System.out.println("Input 5 cards for the second player:");
        for (int i = 0; i < 5; i++) //заполнили карты второго игрока
            player2.addLast(in.nextInt());
        int k = 0; //количество ходов
        while (player1.isEmpty() != true) //ход игры
            if (player2.isEmpty() != true) {
                k++;
                int f_pl = player1.peekFirst(); //карта первого игрока
                int s_pl = player2.peekFirst(); //второго игрока
                if (whoIsWin(f_pl, s_pl) == f_pl) {
                    player1.removeFirst(); //удаляем карту у первого игрока
                    if (k % 2 == 1) {
                        player1.addLast(f_pl); //кладем в дек первого игрока карту второго игрока
                        player1.addLast(s_pl); //кладем в дек первого игрока его карту
                    }
                    else {
                        player1.addLast(s_pl); //кладем в дек первого игрока карту второго игрока
                        player1.addLast(f_pl); //кладем в дек первого игрока его карту
                    }
                    player2.removeFirst(); //удаляем карту у второго игрока (меньшую)
                }
                else {
                    player2.remove(); //удаляем карту у второго игрока
                    if (k % 2 == 1) {
                        player2.addLast(f_pl); //кладем в дек первого игрока карту второго игрока
                        player2.addLast(s_pl); //кладем в дек первого игрока его карту
                    }
                    else {
                        player2.addLast(s_pl); //кладем в дек первого игрока карту второго игрока
                        player2.addLast(f_pl); //кладем в дек первого игрока его карту
                    }
                    player1.removeFirst(); //удаляем карту у первого игрока(меньшую)
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
