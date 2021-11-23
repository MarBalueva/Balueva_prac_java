import javax.swing.*;

public class LabClassDriver {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Students"); //создаем новую рамку
        jFrame.setSize(600, 800); //устанавливаем размеры
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //завершение по закрытию рамки
        jFrame.getContentPane().add(new LabClassUI()); //наполнение содержимым
        jFrame.pack(); //устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов
        jFrame.setVisible(true); //состояние видимости
    }
}
