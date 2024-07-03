package SchedulingYieldingThreads;

public class Task implements Runnable {
    private String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for (int i=0; i<5; i++){
            System.out.println(name + " - Iteration: " + i);

            //Use yield() to suggest the scheduler to pause the thread
            if (i == 2){
                System.out.println(name + " is yeilding at iteration "+ i);
                Thread.yield();
            }

            //Simulate some work with sleep
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(name+ " has completed execution.");
    }
}
