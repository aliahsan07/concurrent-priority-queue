public class Main {


    public static void main(String[] args) throws InterruptedException {

        PriorityQueue queue = new PriorityQueue(5);

        Process p1 = new Process(0, queue);
        Process p2 = new Process(1, queue);
        Process p3 = new Process(2, queue);
        Process p4 = new Process(3, queue);
        Process p5 = new Process(4, queue);




        System.out.println("Empty queue, min value: " + queue.findMin());
        p1.insertIntoQueue(10);
        System.out.println("Min value: " + queue.findMin());
        p2.insertIntoQueue(2);
        System.out.println("Min value: " + queue.findMin());

        p3.insertIntoQueue(3);
        p1.insertIntoQueue(1);
        System.out.println("Min value: " + queue.findMin());

        p1.deleteFromQueue();
        System.out.println("Min value: " + queue.findMin());


        p5.insertIntoQueue(1);
        System.out.println("Min value: " + queue.findMin());
//        queue.tree.printTree();



        System.out.println("<<<<<<<<<<<<< TEST 2 >>>>>>>>>>>>>");
        queue = new PriorityQueue(8);
        Process p6 = new Process(5, queue);
        Process p7 = new Process(6, queue);
        Process p8 = new Process(7, queue);

        int[] values = {3, 4, 2, 11, 9, 5, 2, 4};

        p1.insertIntoQueue(values[0]);
        p2.insertIntoQueue(values[1]);
        p3.insertIntoQueue(values[2]);
        p4.insertIntoQueue(values[3]);
        p5.insertIntoQueue(values[4]);
        p6.insertIntoQueue(values[5]);
        p7.insertIntoQueue(values[6]);
        p8.insertIntoQueue(values[7]);

        System.out.println("Min value: " + queue.findMin());


        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
        p6.join();
        p7.join();
        p8.join();

    }

}
