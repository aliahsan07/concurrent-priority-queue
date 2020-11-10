import java.time.Instant;
import java.util.Date;

public class PriorityQueue {

    static volatile int min = Integer.MAX_VALUE;

    int[] slots;

    BinaryTree tree;

    public PriorityQueue(int processes){
        this.slots = new int[processes];

        for (int i=0; i < processes; i++){
            slots[i] = Integer.MAX_VALUE;
        }

        tree = new BinaryTree(slots);
//        tree.printHeap();
    }

    public boolean insert(int processID, int value){
        if (slots[processID] != Integer.MAX_VALUE){
            int i = (int) (new Date().getTime()/1000);
            i = (i << 32) >> 32;
            value = value << 32;
            value = value ^ i;
            slots[processID] = value;
            // propagate the value up
            tree.bubbleUp(processID);

            return true;
        }



        return false;
    }

    public boolean delete(int processID){
        if (slots[processID] != Integer.MAX_VALUE){
            slots[processID] = Integer.MAX_VALUE;
            // propagate the value up
            return true;
        }
        return false;
    }

    public int findMin(){
        return tree.minValue() >> 32;
    }

}
