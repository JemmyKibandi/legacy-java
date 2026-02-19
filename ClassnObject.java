class Student {

    int id;

    void study() {
        System.out.println("Studying");
    }

}

public class ClassnObject {

    public static void main(String[] args) {

        Student s = new Student();

        s.id = 10;

        s.study();

    }

}
