import java.util.Scanner;

public class Test {
    public static void inputMas(Student[] list){ //заполнение массива
        Scanner in = new Scanner(System.in);
        System.out.println("Input 10 student's values:");
        for (int i = 0; i < 10; i++) //заполнение массива
            list[i] = new Student(in.nextInt(), 0);
    }

    public static void printMas(Student[] list){ //вывод массива
        System.out.println("Array is sorted:");
        for (int i = 0; i < 10; i++) //вывод массива
            System.out.print(list[i].getId() + " ");
    }

    public static void inputMas2(SortingStudentsByGPA[] list){ //заполнение массива
        Scanner in = new Scanner(System.in);
        System.out.println("Input 10 student's values:");
        for (int i = 0; i < 10; i++) //заполнение массива
            list[i] = new SortingStudentsByGPA(0, in.nextInt());
    }

    public static void printMas2(SortingStudentsByGPA[] list){ //вывод массива
        System.out.println("Array is sorted:");
        for (int i = 0; i < 10; i++) //вывод массива
            System.out.print(list[i].score + " ");
    }

    public static void main(String[] args) {
        //упражнение 1
        System.out.println("Exercise 1");
        Student[] iDNumber = new Student[10]; //массив на 10 студентов
        inputMas(iDNumber);
        Sorting s = new Sorting();
        s.insertionSort(iDNumber); //сортировка массива вставками
        printMas(iDNumber);

        //упражнение 2
        System.out.println("\nExercise 2");
        SortingStudentsByGPA[] scores = new SortingStudentsByGPA[10];
        inputMas2(scores);
        SortingStudentsByGPA.quickSort(scores, 0, scores.length - 1); //быстрая сортировка
        printMas2(scores);

        //упражнение 3
        System.out.println("\nExercise 3");
        Student[] s1 = new Student[10]; //первый исходный массив
        Student[] s2 = new Student[10]; //второй исходный массив
        Student[] s3 = new Student[20]; //массив для слияния двух
        inputMas(s1);
        inputMas(s2);
        for (int i = 0; i < 20; i++) {
            if (i < 10)
                s3[i] = new Student(s1[i].getId(), 0);
            else
                s3[i] = new Student(s2[i - 10].getId(), 0);
        }
        Student[] sortS1 = s.mergesort(s1); //сортировка слиянием первого массива
        Student[] sortS2 = s.mergesort(s2); //сортировка слиянием второго массива
        Student[] sortS3 = s.mergesort(s3);
        System.out.println("Merged arrives: ");
        for (int i = 0; i < 20; i++) //вывод массива
            System.out.print(sortS3[i].getId() + " ");
    }
}
