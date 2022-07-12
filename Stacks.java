// Queues; Data Structure; Scott Schmidt

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class printer
{
    static int currentID = 0;
    private int custID;
    private int age;
    private int arrivalTime;

    public printer(int custAge, int arrTime)
    {
        custID = ++currentID;
        age = custAge;
        arrivalTime = arrTime;
    }

    public int getID()
    {
        return custID;
    }

    public int getAge()
    {
        return age;
    }

    public int getArrivalTime()
    {
        return arrivalTime;

    }

    public String toString()
    {
        return "CustID = " + custID + ", Arrival Time = " + arrivalTime + ", Age = " + age;
    }

}


public class generateJob
{
    static private final int nbEvents = 50;
    static private final int maxAge = 100;
    static int currTime = 0;
    static int nbOldprinterToServe = 2;

    static private Queue<printer> queueOld = new LinkedList<printer>();
    static private Queue<printer> queueYoung = new LinkedList<printer>();

    static Random rand = new Random();

    void printQueue(Queue<printer> q)
    {
        for (printer cust : q)
        {
            System.out.println("printer #" + cust.getID() + ", Arrival Time = " + cust.getArrivalTime() + ", Age = "
                    + cust.getAge());
        }
    }

    private static void generateNewprinter()
    {
        int age;
        // Generate random integers in range 0 to maxAge;
        System.out.print("New printer: ");
        age = rand.nextInt(maxAge);
        printer cust = new printer(age, ++currTime);
        if (age > 50)
            queueOld.add(cust);
        else
            queueYoung.add(cust);
        System.out.println(cust);
    }

    private static void serveWaitingprinter()
    {
        printer cust;
        currTime++;
        if (queueOld.isEmpty() || (nbOldprinterToServe == 0))
        {
            cust = queueYoung.poll();
            System.out.println("Now serving printer " + cust);
            nbOldprinterToServe = 2;
        }
        else
        {
            nbOldprinterToServe--;
            cust = queueOld.poll();
            System.out.println("Now serving printer " + cust);
        }
    }

    public static void main(String[] args)
    {
        int nextEvent;
        for (int i = 0; i < nbEvents; i++)
        {
            nextEvent = rand.nextInt(2);
            if (nextEvent == 0)
                generateNewprinter();
            else
                serveWaitingprinter();
        }
    }
}
