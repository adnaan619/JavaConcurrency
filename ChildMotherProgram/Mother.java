package ChildMotherProgram;

public class Mother implements Runnable{
    private Plate plate;

    public Mother(Plate plate){
        this.plate = plate;
    }

    @Override
    public void run(){
        for (int i=0; i<10; i++){
            String food = "Food served "+i+"th serve";
            plate.produce(food);
        }
    }
}