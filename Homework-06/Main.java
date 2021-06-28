import java.util.Vector;

class Main {
  /*
  kicks off the producer and consumer threads, and displays some results. An infinite loop might be appropriate here. At least two producers and three consumers must operate 
  */

  //MAIN CODE
public static void main(String args[]) 
{
  Vector<String> itemQueue = new Vector<String>();
  
  //loop to run producers and consumers as many times as needed
  for (int i = 0; i < 5; i++)
  { 
    //initialize all producers and consumers 
    Producer p1 = new Producer("Producer one", itemQueue); 
    Producer p2 = new Producer("Producer two", itemQueue);
    Consumer c1 = new Consumer("Consumer one", itemQueue);
    Consumer c2 = new Consumer("Consumer two", itemQueue);
    Consumer c3 = new Consumer("Consumer three", itemQueue);
     //start all producers and consumers
    p1.start(); 
    p2.start();
    c1.start();
    c2.start();
    c3.start();
    //end all producers and consumers
    try{p1.join();} catch(InterruptedException ex){} 
    try{p2.join();} catch(InterruptedException ex){}
    try{c1.join();} catch(InterruptedException ex){}
    try{c2.join();} catch(InterruptedException ex){}
    try{c3.join();} catch(InterruptedException ex){}
  }
  //display final queue after all the threads are done
  System.out.println("Queue: " + itemQueue); 
}
  
}




/*

PROMPT:

1.PM, Dev Ops, QA, presentation. This person doesn’t necessarily have to write code and is responsible for pulling everything together.
2.producer class(es)
3.consumer class(es)
4.main class that sets up the work environment, kicks off the producer and consumer threads, anddisplays some results. An infinite loop might beappropriate here. At least two producers and three consumers must operate concurrently. 

Implement your solution in a language selected by your group.Any language is fine.

The Producer class can generate random items to put into the queue.Actually, it doesn’t have to be a queue. Just make sure it’s thread-safe!

The Consumer class can remove the itemsfrom the queueand print them or tally them or do something visually interesting. 

*/