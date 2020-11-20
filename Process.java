public class Process extends Thread {


    private final int ID;
    static private  PriorityQueue priorityQueue;

    public synchronized boolean insertIntoQueue(int value){
        return priorityQueue.insert(ID, value);
    }

    public synchronized boolean deleteFromQueue(){
        return priorityQueue.delete(ID);
    }


    public Process(int ID, PriorityQueue queue){
        this.ID = ID;
        this.priorityQueue = queue;
    }

}
