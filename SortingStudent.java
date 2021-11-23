import java.util.Comparator;

public class SortingStudent implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        return s1.getName().hashCode() - s2.getName().hashCode();
    }
}
