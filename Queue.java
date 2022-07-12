// Queues; Data Structure; Scott Schmidt
// Live Version: https://code.sololearn.com/cPBuwsrq2PTH
// Python: https://github.com/ScottySchmidt/DataStructures/blob/main/Queues.ipynb

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* 
Constructor printer
@param printID as int
@param page as int 
 */
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
       return "New PrintJob = " + printID + ", time = " + arrivalTime + ", pages = " + page;
    }
}


public class generateJob
{
    static private final int nbEvents = 30;
    static private final int maxpage = 50;
    static int currTime = 0;
    static int printerToServe = 3;

    static private Queue<printer> queueOne = new LinkedList<printer>();
    static private Queue<printer> queueTwo = new LinkedList<printer>();
    static private Queue<printer> queueThree = new LinkedList<printer>();

    static Random rand = new Random();

    void printQueue(Queue<printer> q)
    {
        for (printer print : q)
        {
            System.out.println("PrinterJob #" + print.getID() + ", Arrival Time = " + print.getArrivalTime() + ", page = "
                    + print.getpage());
        }
    }

    private static void generateNewprinter()
    {
        int page;
        // Generate random integers in range 0 to maxpage;
        System.out.print("New printer: ");
        page = rand.nextInt(maxpage);
        printer print = new printer(page, ++currTime);
        if (page < 10) {
            queueOne.add(print);
            System.out.println("Print job" + print.getID() + " inserted into Queue 1");
        } else if ((page > 10) && (page <21) ) {
            queueTwo.add(print);
            System.out.println("Print job" + print.getID() + " inserted into Queue 2");
        } 
        else {
            queueThree.add(print);
            System.out.println("Print job" + print.getID() + " inserted into Queue 3");
        }
        System.out.println(print);
    }

    private static void serveWaitingprinter()
    {
        printer print;
        currTime++;
        if (queueOne.isEmpty() || (printerToServe == 0))
        {
            print = queueTwo.poll();
            System.out.println("Now serving printer " + print);
            printerToServe = 2;
        }
        else
        {
            printerToServe--;
            print = queueOne.poll();
            System.out.println("Now serving printer " + print);
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
