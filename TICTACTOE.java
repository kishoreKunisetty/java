import java.util.*;
class tictactoe{
    public static final int X=1,O=-1;
    public static final int EMPTY=0;
    private static int board[][]=new int[3][3];
    private int player;
    public tictactoe(){
        clearBoard();
    }
    public void clearBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=EMPTY;
            }
        }
        player=X;
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void putmark(int i,int j) throws IllegalArgumentException{
        if((i<0)||(i>2)||(j<0)||(j>2))
            throw new IllegalArgumentException("Invalid board position");
        if(board[i][j]!=EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        board[i][j]=player;
        player=-player;
    }
    public static boolean iswin(int mark){
        return((board[0][0]+board[0][1]+board[0][2]==mark*3)||
               (board[1][0]+board[1][1]+board[1][2]==mark*3)||
               (board[2][0]+board[2][1]+board[2][2]==mark*3)||
               (board[0][0]+board[1][0]+board[2][0]==mark*3)||
               (board[0][1]+board[1][1]+board[2][1]==mark*3)||
               (board[0][2]+board[1][2]+board[2][2]==mark*3)||
               (board[0][0]+board[1][1]+board[2][2]==mark*3)||
               (board[2][0]+board[1][1]+board[0][2]==mark*3));
    }
    public int winner(){
        if(iswin(X))
            return X;
        else if(iswin(O))
            return O;
        else
            return 0;
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                switch (board[i][j]){
                    case X:  sb.append("X");break;
                    case O:  sb.append("O");break;
                    case EMPTY: sb.append(" ");break;
            }if(j<2)sb.append("|");
            }if (i<2)sb.append("\n----\n");
        }return sb.toString();
    }
    public static void main(String[] args ){
        Scanner sc=new Scanner(System.in);
        tictactoe game=new tictactoe();
        boolean cut=false;
        loop:
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print("enter the value row:");
                int n=sc.nextInt();
                System.out.print("enter the value column:");
                int c=sc.nextInt();
                game.putmark(n,c);
                System.out.println(game);
                if(iswin(X)){
                    System.out.println("X wins");
                    cut=true;
                    break loop;
                }
                else if(iswin(O)){
                    System.out.println("O wins");
                    cut=true;
                    break loop;
                }
            }
        }
        if(!cut)
        {int winning = game.winner();
        String[] outcome={"O wins","Tie","X wins"};
            System.out.println(outcome[1+winning]);}
    }
}
