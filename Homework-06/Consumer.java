import java.util.Vector;  //Import Vector to use as an itemQueue
import java.util.Random;  //Uses random to make the consumers wait for a random amount of time

public class Consumer extends Thread{
  private Vector<String> Itemqueue;
  private String name;

  public Consumer(String name, Vector ItemQ) { 
    this.name = name;
    Itemqueue = ItemQ;
  }

  public void run(){
    //Run class used for multithreading, starts the consume method
    consume();
  }

  private void consume(){
    try {Thread.sleep(new Random().nextInt(10));} catch (Exception ex){}
    if (Itemqueue.size() > 0){ //If statement to avoid taking from an empty vector
      String item = Itemqueue.get(0); //Get the item on top of the queue
      Itemqueue.remove(0);  //Remove the item on top of the queue
      synchronized(Itemqueue){ //Synchronize the print statement to avoid threads printing in the wrong order
        System.out.println(name + " consumed " + item); //Print which item was taken by the consumer
      }
    }
  }

}

