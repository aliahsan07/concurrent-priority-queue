import java.util.concurrent.atomic.AtomicReferenceArray;

public class BinaryTree {

    AtomicReferenceArray tree;
    static int nonLeafNodes;
    static int levels;
    static int size;

    int minValue(){
        return (int) tree.get(0) & 0x0000ffff;
    }

    public BinaryTree(int n){

        int closest2Power = (int)Math.ceil(Math.log(n) / Math.log(2));
        levels = closest2Power;
        int leafNodes = (int) Math.pow(2, closest2Power);
        nonLeafNodes = leafNodes - 1;
        size = ((2 * leafNodes) - 1) - leafNodes + n;
        tree = new AtomicReferenceArray(size);
        for (int i=0; i < size; i++){
            tree.set(i, Integer.MAX_VALUE);
        }
//        System.out.println(size);



    }

    boolean insertIntoTree(int processID, int val){
        int slot = nonLeafNodes + processID;

        boolean retValue = true;
        if (!tree.get(slot).equals(Integer.MAX_VALUE)) {
            retValue = false;
        }

        tree.set(slot,val);

        // bubble Up
        int i =0;
        while (i != levels) {
            int buddyIndex = slot % 2 == 0 ? slot - 1 : slot + 1;
            int minValue = val;
            if (buddyIndex < size) {
                minValue = Math.min((Integer) tree.get(slot), (Integer) tree.get(buddyIndex));
            }

            int parentIndex = (int) Math.floor((slot - 1) / 2);
            Object o = tree.get(parentIndex);

            if (!tree.compareAndSet(parentIndex, o, minValue))
                tree.compareAndSet(parentIndex, o, minValue);

            i++;
            slot = parentIndex;

        }

        return retValue;
    }

    boolean deleteFromTree(int processID){
        int slot = nonLeafNodes + processID;

        boolean retValue = true;
        if (tree.get(slot).equals(Integer.MAX_VALUE)) {
            retValue = false;
        }


        tree.set(slot,Integer.MAX_VALUE);
//        printTree();

        // bubble Up
        int i =0;
        while (i != levels) {
            int buddyIndex = slot % 2 == 0 ? slot - 1 : slot + 1;
            int minValue = Integer.MAX_VALUE;
            if (buddyIndex < size) {
                minValue = Math.min((Integer) tree.get(slot), (Integer) tree.get(buddyIndex));
            }

            int parentIndex = (int) Math.floor((slot - 1) / 2);
            Object o = tree.get(parentIndex);

            if (!tree.compareAndSet(parentIndex, o, minValue))
                tree.compareAndSet(parentIndex, o, minValue);

            i++;
            slot = parentIndex;

        }
//        printTree();
        return retValue;
    }


    void printTree()
    {
        System.out.println("Array representation of Tree:");
        for (int i = 0; i < tree.length(); ++i){
            int value =  (int) tree.get(i) & 0x0000ffff;
            System.out.println(value + " ");
        }
    }

}
