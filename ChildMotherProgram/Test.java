package ChildMotherProgram;

public class Test{
    public static void main(String[] args) {
        Plate plate = new Plate(null, false);

        Mother mother = new Mother(plate);
        Child child = new Child(plate);

        Thread t1 = new Thread(mother, "Mother");
        Thread t2 = new Thread(child, "Child");

        t1.start();
        t2.start();
    }
}

