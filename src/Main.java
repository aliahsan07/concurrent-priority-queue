public class Main {


    public static void main(String[] args){

        PriorityQueue queue = new PriorityQueue(5);

        Process p1 = new Process(0, queue);
        Process p2 = new Process(1, queue);
        Process p3 = new Process(2, queue);
        Process p4 = new Process(3, queue);
        Process p5 = new Process(4, queue);


        p1.insertIntoQueue(10);
        System.out.println(queue.findMin());
        p2.insertIntoQueue(2);
        System.out.println(queue.findMin());
        p3.insertIntoQueue(3);
        p1.insertIntoQueue(1);
        System.out.println(queue.findMin());
        p1.deleteFromQueue();
        System.out.println(queue.findMin());
        p5.insertIntoQueue(0);
        System.out.println(queue.findMin());


    }

}
