import java.util.*;
class main{
    static int top=-1;
    static char[] stack=new char[25];
    static void push(char ch){
        if(top>24)
            System.out.println("stack is full");
        else
        {
            top++;
            stack[top]=ch;
        }
    }
    static char pop(){
        if(top<0)
        { System.out.println("Stack is empty");
            return ' ';}
        else{
            char ch=stack[top];
            top--;
            return ch;
        }
    }
    static void display(){
        if(top==-1)
            System.out.println("stack is empty");
        else {
            for(char i :stack)
                System.out.print(i+" ");
            System.out.println();
        }
    }
    static int pres(char ch){
        switch(ch){
            case '+':
            case '-': return 1;
            case '*':
            case '/':
            case '%':   return 2;
        default : return 3;
        }
    }
    static boolean isAlpha(char ch){
        if (ch<123&&ch>96||ch<91&&ch>64)
            return true;
        else
            return false;
    }
    static void postfix(String s){
        String output="";
        push('(');
        for(int i=0;i<s.length();i++){
            if(isAlpha(s.charAt(i)))
            {  output+=s.charAt(i);}
            else if (s.charAt(i)=='(')
                push(s.charAt(i));
            else if(s.charAt(i)==')'){
                while(stack[top]!='('){
                   output+=pop();
                }pop();
            }
            else{
                while(pres(s.charAt(i))<pres(stack[top])&&stack[top]!='('){
                    output+=pop();
                    if(top==-1)
                        break;
                }
                push(s.charAt(i));
            }
        }
        while(top!=0)
            output+=pop();
        System.out.println("\n"+output);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        sc.close();
        postfix(input);
    }
}
