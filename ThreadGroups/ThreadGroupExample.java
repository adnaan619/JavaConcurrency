package ThreadGroups;

public class ThreadGroupExample{
    public static void main(String[] args) {
        ThreadGroup parentGroup = new ThreadGroup("Parent-Group");
        ThreadGroup childGroup = new ThreadGroup("Child-Group");

        Thread t1 = new Thread(parentGroup, new MyRunnable(), "Thread-1");
        Thread t2 = new Thread(parentGroup, new MyRunnable(),"Thread-2");

        t1.start();  
        t2.start();
        
        Thread t3 = new Thread(childGroup, new MyRunnable(), "Thread-3");
        Thread t4 = new Thread(childGroup, new MyRunnable(), "Thread-4");

        t3.start();
        t4.start();

        System.out.println("Active threads in :" + childGroup.getName() + " : " + parentGroup.activeCount());
        System.out.println("Active threads in :" + parentGroup.getName() + " : " + childGroup.activeCount());

        parentGroup.interrupt();
        childGroup.interrupt();
    }

}