import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LabClassUI extends JPanel implements LabClass {
    private List<Student> students = new ArrayList<Student>(); //список студентов
    int width = 800, height = 600; //размеры окна

    JLabel mainLabel = new JLabel("Добавьте студентов!");
    JLabel innLabel = new JLabel("Введите ИНН"); //надпись для инн
    JLabel nameLabel = new JLabel("Введите ФИО"); //надпись для имени
    JLabel listLabel = new JLabel("Список студентов"); //текущий список студентов
    JLabel messageLabel = new JLabel(""); //сообщение об ошибках

    JTextField name = new JTextField(); //поле для ввода имени
    JTextField inn = new JTextField(); //поле для ввода инн

    JTextArea studentList = new JTextArea(); //вывод списка студентов

    JButton adding = new JButton("Добавить студента"); //кнопка добавить студента
    JButton finding = new JButton("Найти студента"); //кнопка найти студента
    JButton sorting = new JButton("Отсортировать список студентов"); //кнопка отсортировать студентов

    JPanel[] pnl = new JPanel[6];
    JPanel[] pnlButton = new JPanel[3];
    JPanel[] pnlInput = new JPanel[6];


    LabClassUI(){
        setPreferredSize(new Dimension(width, height));
        setLayout(new GridLayout(2, 3));
        Font font = new Font("Times New Roman", Font.BOLD, 18); //используемый шрифт
        for (int i = 0; i < pnl.length; i++){
            pnl[i] = new JPanel();
            pnl[i].setBackground(new Color(250, 202, 180));
            add(pnl[i]);
        }
        //устанавливаем размеры надписей и кнопок
        adding.setPreferredSize(new Dimension(250,50));
        finding.setPreferredSize(new Dimension(250,50));
        sorting.setPreferredSize(new Dimension(250,50));
        mainLabel.setPreferredSize(new Dimension(200, 50));
        name.setPreferredSize(new Dimension(150, 50));
        inn.setPreferredSize(new Dimension(150, 50));

        for (int i = 0; i < pnlButton.length; i++){
            pnlButton[i] = new JPanel();
            pnlButton[i].setBackground(new Color(250, 202, 180));
            pnl[3].add(pnlButton[i]);
        }
        //устанавливаем шрифты
        mainLabel.setFont(font);
        innLabel.setFont(font);
        nameLabel.setFont(font);
        listLabel.setFont(font);
        messageLabel.setFont(font);
        inn.setFont(font);
        name.setFont(font);
        studentList.setFont(font);
        //цвет кнопок
        adding.setBackground(new Color(245, 146, 81));
        finding.setBackground(new Color(245, 146, 81));
        sorting.setBackground(new Color(245, 146, 81));

        pnl[1].setLayout(new BorderLayout());
        pnl[1].add(mainLabel, BorderLayout.CENTER);
        pnlButton[0].add(adding);
        pnlButton[1].add(finding);
        pnlButton[2].add(sorting);

        for (int i = 0; i < pnlInput.length; i++){
            pnlInput[i] = new JPanel();
            pnlInput[i].setLayout(new BorderLayout());
            pnlInput[i].setBackground(new Color(250, 202, 180));
            pnl[4].add(pnlInput[i]);
        }
        pnlInput[2].add(nameLabel, BorderLayout.NORTH);
        pnlInput[2].add(name, BorderLayout.CENTER);
        pnlInput[3].add(innLabel, BorderLayout.NORTH);
        pnlInput[3].add(inn, BorderLayout.CENTER);
        pnlInput[4].add(messageLabel);

        pnl[5].setLayout(new BorderLayout());
        pnl[5].add(listLabel, BorderLayout.NORTH);
        pnl[5].add(studentList, BorderLayout.CENTER);


        adding.addActionListener(new AbstractAction() { //кнопка добавления студента
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                String Fio = name.getText();
                String Inn = inn.getText();
                Student stu = new Student(Inn, Fio);
                AddStudent(stu); //добавляем студента
                inn.setText(""); //очищаем заполненные поля
                name.setText("");
                PrintStudents(); //выводим новый список
            }
        });

        sorting.addActionListener(new AbstractAction() { //кнопка сортировки
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                SortStudents(); //сортировка
                PrintStudents(); //вывод списка
            }
        });

        finding.addActionListener(new AbstractAction() { //кнопка поиска
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                String Fio = name.getText();
                String Inn = inn.getText();
                Student stu = new Student(Inn, Fio);
                FindStudent(stu);
                inn.setText("");
                name.setText("");
            }
        });
    }
    @Override
    public void FindStudent(Student s) { //поиск студента
        boolean f = true; //признак, что студент найден
        try{
            for (Student student: students){ //ищем по списку студентов
                if (student.getName().equals(s.getName())){ //если имя совпало с искомым
                    f = false; //студент найден
                    if(s.getInn().equals(student.getInn())){
                        mainLabel.setText("Заказ оформлен!");
                    } else
                        throw new EmptyStringException();
                    break;
                }
            }
            if (f) //если студент не найден
                throw new StudentNotFoundException();
        } catch (StudentNotFoundException err){
            messageLabel.setText("Такого студента нет в базе"); //выдаем сообщение
        } catch (EmptyStringException err){
            messageLabel.setText("Ваш ИНН не действителен"); //выдаем сообщение
        }
    }

    @Override
    public void AddStudent(Student s) {
        try {
            if (!(s.getName().equals("") || s.getInn().equals(""))) {
                students.add(s);
                mainLabel.setText("Студент успешно добавлен!");
            } else {
                throw new EmptyStringException();
            }
        }
        catch (EmptyStringException err) {
            messageLabel.setText("Заполните все поля");
            mainLabel.setText("Не удалось добавить студента");
        }
    }

    @Override
    public void SortStudents() {
        Comparator<Student> comp = new SortingStudent();
        students.sort(comp);
        mainLabel.setText("Список успешно отсортирован!");
    }

    @Override
    public void PrintStudents(){
        studentList.setText("");
        for (Student student: students){
            String s = "";
            s = student.toString();
            studentList.append(s);
        }
    }
}
