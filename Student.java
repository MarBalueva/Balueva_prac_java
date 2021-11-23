public class Student {
    private String inn; //ИНН
    private String name; //ФИО

    public Student(String inn, String name) {
        this.inn = inn;
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Имя: " + name + '\n' + "ИНН: " + inn + '\n';
    }
}
