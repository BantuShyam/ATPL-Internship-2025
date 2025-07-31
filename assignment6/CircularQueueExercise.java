public class CircularQueueExercise {
    private int front;
    private int rear;
    private int nums[];
    private int size;
    private int initSize;
    public CircularQueueExercise(int initSize){
        front=0;
        rear=-1;
        this.initSize=initSize;
        this.nums=new int[initSize];
        size=0;
    }

    public  void enQueue(int number){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear=(rear+1)%initSize;
        nums[rear]=number;
        size++;

    }
    public void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty...");
        }
        if(front== rear){
            front=0;
            rear=-1;
            size=0;
        }
        front=(front+1)%initSize;
        size--;
    }
    void top(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        System.out.println(nums[front]);
    }
     boolean isEmpty(){
         return size== 0;
    }
    boolean isFull(){
        return size==initSize;
    }
        public void display(){
            if(isEmpty()){
                System.out.println("queue is empty");
            }
            int count=0;
            int i= front;
            while(count<size){
                System.out.print(nums[i]+" ");
                i=(i+1)%initSize;
                count++;
            }
            System.out.println();
        }
    public static void main(String[] args){
        CircularQueueExercise queue=new CircularQueueExercise(5);
        queue.enQueue(32);
        queue.enQueue(34);
        queue.enQueue(43);
        queue.enQueue(67);
        queue.enQueue(56);
        queue.top();
        queue.deQueue();
        System.out.println(queue.isFull());
        queue.display();
    }
}
