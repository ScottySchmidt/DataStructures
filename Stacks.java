// Queues; Data Structure; Scott Schmidt

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class printer
{
    static int currentID = 0;
    private int printID;
    private int page;
    private int arrivalTime;

    public printer(int custpage, int arrTime)
    {
        printID = ++currentID;
        page = custpage;
        arrivalTime = arrTime;
    }

    public int getID()
    {
        return printID;
    }

    public int getpage()
    {
        return page;
    }

    public int getArrivalTime()
    {
        return arrivalTime;

    }

    public String toString()
    {
        return "printID = " + printID + ", Arrival Time = " + arrivalTime + ", page = " + page;
    }

}


public class generateJob
{
    static private final int nbEvents = 30;
    static private final int maxpage = 50;
    static int currTime = 0;
    static int nbOldprinterToServe = 2;

    static private Queue<printer> queueOld = new LinkedList<printer>();
    static private Queue<printer> queueYoung = new LinkedList<printer>();

    static Random rand = new Random();

    void printQueue(Queue<printer> q)
    {
        for (printer cust : q)
        {
            System.out.println("printer #" + cust.getID() + ", Arrival Time = " + cust.getArrivalTime() + ", page = "
                    + cust.getpage());
        }
    }

    private static void generateNewprinter()
    {
        int page;
        // Generate random integers in range 0 to maxpage;
        System.out.print("New printer: ");
        page = rand.nextInt(maxpage);
        printer cust = new printer(page, ++currTime);
        if (page > 50)
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
