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
        LocalDateTime now = LocalDateTime.now();
        int timeStamp = ((now.getDayOfMonth() - 1) * 24 + now.getHour()) * 60 + now.getMinute();
        timeStamp = timeStamp << 16;
        int valueWithTimestamp = timeStamp ^ value;

        return tree.insertIntoTree(processID, valueWithTimestamp);

    }

    public boolean delete(int processID){
        return tree.deleteFromTree(processID);
    }

    public int findMin(){
        return tree.minValue();
    }

}
