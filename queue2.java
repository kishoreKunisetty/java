//this is a circular queue programme 
import java.util.*;
class queue{
    static int q[] = new int[5],front=-1,rear=-1;
    static  void enqueue(int item){
        rear=(rear+1)%5;
        if(front==(rear+1)%5)
            System.out.println("queue os full");
        else
            q[rear]=item;
        if(front==-1)
            front++;
    }
    static void dequeue(){
        if(front==(rear+1)%5)
            { System.out.println("queue is empty");}
        else{
            if(front==rear)
                { front=-1;rear=-1;}
            else
                {front=(front+1)%5;}
        }
    }
   // prints all in Queue 
    static void display(){
        if(front==(rear+1)%5)
            System.out.println("queue is empty");
            else{
                for(int i=front;i!=rear+1;i=(i+1)%5)
                    System.out.println(q[i]);
            }
    }
    //to try the queue made
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("enter the coresponding number to perform the required action");
            System.out.println("1) enqueue \n2) dequeue \n3)display \n4)exit");
            int i=sc.nextInt();
            switch(i){
                case 1:System.out.println("enter the number:");
                    int item=sc.nextInt();
                    enqueue(item);
                    break;
                case 2:dequeue();
                    break;
                case 3:display();
                    break;
            }
            if(i==4)
                break;
        }while(true);
    }
}
