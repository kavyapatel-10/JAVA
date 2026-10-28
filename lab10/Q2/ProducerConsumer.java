import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer{

    public static void main(String[] args){
        SharedBuffer buffer = new SharedBuffer(5);
        int totalitems = 10;
    
        Thread producerthread = new Thread(() ->{
            try{
                for(int i =1;i<=totalitems;i++){
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        },"Producer");

        Thread consumerthread = new Thread(() -> {
            try{
                for(int i = 1; i<= totalitems;i++){
                    buffer.consume();
                    Thread.sleep(150);
                }
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
            }
        },"Consumer");

        producerthread.start();
        consumerthread.start();


    }
}

class SharedBuffer{
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    SharedBuffer(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException{

        while(buffer.size() == capacity){
            System.out.println(Thread.currentThread().getName() + " buffer full...");
            wait();

        }
        buffer.add(value);
        System.out.println(Thread.currentThread().getName() + "produced: "+value);

        notify();
    }

    public synchronized int consume() throws InterruptedException{
        while(buffer.isEmpty()){
            System.out.println(Thread.currentThread().getName() + "buffer Empty, waiting...");
            wait();
        }

        int value = buffer.poll();
        System.out.println(Thread.currentThread().getName() + "consumed: "+ value);

        notify();
        return value;
    }
} 