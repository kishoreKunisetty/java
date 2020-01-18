import java.util.*;
class queue{
    static int q[]=new int[10],front=-1,rear=-1;
    //push
    static void enqueue(int item){
        rear++;
        if (rear==10)
            System.out.println("queue is full");
        else
           q[rear]=item;
        if(front==-1)
            front++;
    }
    //pop
    static void dequeue(){
        if(front==-1)
            System.out.println("queue is empty");
        else{
                if(front==rear)
                    front=rear=-1;
                else{
                    for(int i=front;i<rear;i++)
                        q[i]=q[i+1];
                }
            }
    }
    //print all
    static void display(){
        if (front==-1)
            System.out.println("queue is empty");
        else{
            for(int i=front;i<=rear;i++)
                System.out.println(q[i]);
        }
    }
    public static void main(String arg[]){
//  try with this
        enqueue(1);
        enqueue(2);
        enqueue(3);
        display();
    }
}
