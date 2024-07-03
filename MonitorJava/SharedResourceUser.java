package MonitorJava;

public class SharedResourceUser extends Thread{
    private final SharedResource sharedResource;

    public SharedResourceUser(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    public void run(){
        for (int i=0; i<3; i++){
            sharedResource.increment();
        }
    }

}