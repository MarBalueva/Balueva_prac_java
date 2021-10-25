class Student {
    private int id = 0; //ID номер (задание 1)
    private Integer score = 0; //итоговый балл (задание 2)

    public Student(int id, int score) {
        this.score = score;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
