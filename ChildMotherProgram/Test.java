package ChildMotherProgram;

public class Test {
    public static void main(String[] args) {
        Plate plate = new Plate();

        Mother mother = new Mother(plate);
        Child child = new Child(plate);

        Thread motherThread = new Thread(mother, "Mother");
        Thread childThread = new Thread(child, "Child");

        motherThread.start();
        childThread.start();
    }
}