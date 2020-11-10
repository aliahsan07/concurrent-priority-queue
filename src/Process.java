public class Process {


    private final int ID;

    public synchronized boolean insertIntoQueue(int value){

        return false;
    }

    public synchronized boolean deleteFromQueue(){

        return false;
    }


    public Process(int ID){
        this.ID = ID;
    }

}
