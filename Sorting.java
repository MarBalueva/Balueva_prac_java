import java.util.Arrays;

public class Sorting {
    public static void insertionSort(Student[] arr) { //сортировка вставками
        for (int i = 1; i < arr.length; i++) {
            Student currElem = arr[i];
            int prevKey = i - 1;
            while (prevKey >= 0 && arr[prevKey].getId() > currElem.getId()) {
                arr[prevKey + 1] = arr[prevKey];
                prevKey--;
            }
            arr[prevKey + 1] = currElem;
        }
    }

    public static Student[] mergesort(Student[] arr1){
        Student[] buf1 = Arrays.copyOf(arr1, arr1.length); //массив для сортировки
        Student[] buf2 = new Student[arr1.length]; //буффер, размер равен массиву для сортировки
        Student[] result = mergesortInner(buf1, buf2, 0, arr1.length); //отсортированный массив
        return result;
    }

    public static Student[] mergesortInner(Student[] buf1, Student[] buf2, int startInd, int endInd) {
        if (startInd >= endInd - 1)
            return buf1;
        //если массив уже отсортирован
        int middle = startInd + (endInd - startInd) / 2; //центральный элемент
        Student[] sorted1 = mergesortInner(buf1, buf2, startInd, middle); //делим пополам одну полповину
        Student[] sorted2 = mergesortInner(buf1, buf2, middle, endInd); //делим пополам другую половину
        //слияние
        int ind1 = startInd;
        int ind2 = middle;
        int destInd = startInd;
        Student[] result = sorted1 == buf1 ? buf2 : buf1;
        while (ind1 < middle && ind2 < endInd){ //сортируем внутри группы
            result[destInd++] = sorted1[ind1].getId() < sorted2[ind2].getId()
                    ? sorted1[ind1++] : sorted2[ind2++];
        }
        while (ind1 < middle)
            result[destInd++] = sorted1[ind1++];
        while (ind2 < endInd)
            result[destInd++] = sorted2[ind2++];
        return result;
    }
}
