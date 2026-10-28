import java.util.concurrent.*;

public class ThreadPoolRunner{
    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Submiting tasks");

        for(int i=0;i<=10;i++){
            final int taskid = i;
            executor.submit(new Runnable(){
                public void run(){
                    String threadname = Thread.currentThread().getName();
                     System.out.println("Task " + taskid + " is running on " + threadname);

                     try{
                        Thread.sleep(1000);

                     }catch(InterruptedException e){
                         System.err.println("Task " + taskid + " was interrupted.");
                        Thread.currentThread().interrupt();
                     }
                     System.out.println("Task " + taskid + " has completed.");
                }
            });
        }
    


executor.shutdown();
try{

    if(!executor.awaitTermination(60,TimeUnit.SECONDS)){
        executor.shutdownNow();
    }
}catch(InterruptedException ie){
    executor.shutdownNow();
    Thread.currentThread().interrupt();
}

System.out.println("All tasks finished, executor shut down.");

    }
}