//import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<SortingStudentsByGPA>{
    public int id; //ID номер (задание 1)
    public Integer score; //итоговый балл (задание 2)

    public SortingStudentsByGPA(int id, int score) {
        this.score = score;
        this.id = id;
    }

    @Override
    public int compareTo(SortingStudentsByGPA a){
        return this.score.compareTo(a.score);
    }

    public static void quickSort(SortingStudentsByGPA[] arr, int low, int high) {
        if (low >= high)
            return;
        int piv = partition(arr, low, high);
        quickSort(arr, low, piv - 1);
        quickSort(arr, piv + 1, high );
    }

    public static int partition(SortingStudentsByGPA[] arr, int low, int high){
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (arr[i].compareTo(arr[low]) > 0) {
                i++;
            } else if (arr[j].compareTo(arr[low]) <= 0) {
                j--;
            } else if (j < i) {
                break;
            } else
                exchange(arr, i, j);
        }
                    exchange(arr, low, j);
        return j;
        }

    public static void exchange(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
