import java.util.*;
class stack{
    static int a[]=new int[5],top=-1;
    static void push(int element){
        if(top==a.length)
            System.out.println("stack is full");
        else{
            top++;
            a[top]=element;
        }
    }
    static void pop(){
        if(top<0)
            System.out.println("stack is empty");
        else
            top--;
    }
    static void display(){
        if(top<0)
            System.out.println("stack is empty");
        else
            for(int i=0;i<=top;i++)
                System.out.println(a[i]);
    }
    public static void main(String[] args){
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        pop();
        display();
    }
}
