import java.util.Vector;  //Import Vector to use as an itemQueue
import java.util.Random;  //Uses random to create a random object and make producers wait for a random amount of time

public class Producer extends Thread {
  //Three class variables: itemQueue, a list of items, and a name for each producer
  private Vector<String> itemQueue; 
  private String[] items = new String[]{"soap","shampoo","deodorant", "apple", "orange", "banana"};
  public String name;

  public Producer (String n, Vector itemQ){
    //Constructor to accept a name and the itemQueue
    this.name = n;
    itemQueue = itemQ;
  }

  public void run(){
    //run class used for multithreading, starts the produce method
    produce();
  }


  private void produce(){
    try {Thread.sleep(new Random().nextInt(10));} catch (Exception ex){} //sleep for a random amount of time before producing
    String item = items[new Random().nextInt(6)]; //pull a random item from the item list
    itemQueue.add(item); //add the item to the queue
    synchronized(itemQueue){ //synchronize the print statement to avoid threads printing in the wrong order
      System.out.println(name + " added a(n) " + item + " to the Queue."); //prints what was added to the Queue
    }
  }
  
}