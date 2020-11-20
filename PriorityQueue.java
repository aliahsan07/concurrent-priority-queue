import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PriorityQueue {

    static volatile int min = Integer.MAX_VALUE;

    BinaryTree tree;

    public PriorityQueue(int processes){

        tree = new BinaryTree(processes);
    }

    public boolean insert(int processID, int value){
        System.out.println("Inserting " + value + " for process " + processID);
        LocalDateTime now = LocalDateTime.now();
        int timeStamp = ((now.getDayOfMonth() - 1) * 24 + now.getHour()) * 60 + now.getMinute();
        int valueWithTimestamp = timeStamp ^ (value << 16);
        return tree.insertIntoTree(processID, valueWithTimestamp);

    }

    public boolean delete(int processID){
        System.out.println("Removing value for process " + processID);
        return tree.deleteFromTree(processID);
    }

    public int findMin(){
        return tree.minValue();
    }

}
