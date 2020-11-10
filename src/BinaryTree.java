class TreeNode{
    TreeNode left;
    TreeNode right;
    int value;
    TreeNode(int x) { value = x; left = null; right = null; }
}

public class BinaryTree {

    static int[] tree;

    int minValue(){
        return tree[0];
    }

    public BinaryTree(int arr[]){

        int size = arr.length;
        int startIdx = (size / 2) - 1;
        tree = new int[size];

        for (int i=0; i < size; i++){
            tree[i] = arr[i];
        }

        for (int i=startIdx; i >= 0; i--){
            heapify(tree, size, i);
        }

    }

    private void heapify(int[] tree, int size, int i) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && tree[left] < tree[smallest])
            smallest = left;
        if (right < size && tree[right] < tree[smallest])
            smallest = right;

        if (smallest != i){
            int swap = tree[i];
            tree[i] = tree[smallest];
            tree[smallest] = swap;

            heapify(tree, size, smallest);

        }

    }

    static void printHeap()
    {
        System.out.println("Array representation of Heap:");
        for (int i = 0; i < tree.length; ++i)
            System.out.print(tree[i] + " ");
        System.out.println();
    }

    public void bubbleUp(int processID) {
        int buddy = processID % 2 == 0 ? processID + 1 : processID -1;
        int min = Math.min(tree[processID], tree[buddy]);


    }
}
