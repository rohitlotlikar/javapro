import java.util.Scanner;
class tic
{


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int index=1,step;  
        boolean win=false;
        char[][] game={
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '}};

        char[][] gameindex={
        {'1','|','2','|','3'},
        {'-','+','-','+','-'},
        {'4','|','5','|','6'},
        {'-','+','-','+','-'},
        {'7','|','8','|','9'}};
        printindex(gameindex);
        print(game);
        char a='X';
        for(step=1;step<10;step++)
        {
            if(step%2==0)
            {
                a='O';
            }
            else
            {
                a='X';
            }
            System.out.println("ENTER THE INDEX FROM 1-9 TO PUT "+a);
            index=sc.nextInt();
            
            if(index>0 && index<10)
            {
                nextstep(game,a,index);
            }
            else
            {
                step=step-1;
            }
            if(checkwin(game,a))
            {
                System.out.println("THE CHARACTER "+a+" WINS THE GAME");
                win = true;
                break;
            }
            sc.close();

        }
        
        if(step==9 && !win)
        {
            System.out.println("IT'S A DRAW");
        }
    }

    public static void nextstep(char[][] game,char a,int index)
    {   
        switch(index) 
        {
            case 1:
                game[0][0]=a;
                print(game);
                break;
            case 2:
                game[0][2]=a;
                print(game);
                break;    
            case 3:
                game[0][4]=a;
                print(game);
                break;
            case 4:
                game[2][0]=a;
                print(game);
                break;
            case 5:
                game[2][2]=a;
                print(game);
                break;
            case 6:
                game[2][4]=a; 
                print(game);
                break;   
            case 7:
                game[4][0]=a;
                print(game);
                break;
            case 8:
                game[4][2]=a;
                print(game);
                break;
            case 9:
                game[4][4]=a;
                print(game);
                break;
            default:
                System.out.println("INVALID INDEX");
        }
        
    }

    public static boolean checkwin(char[][]game,char a)
    {

        if((game[0][0]==a && game[0][2]==a && game[0][4]==a)||(game[2][0]==a && game[2][2]==a && game[2][4]==a)
           ||(game[4][0]==a && game[4][2]==a && game[4][4]==a)||(game[0][0]==a && game[2][0]==a && game[4][0]==a)
           ||(game[0][2]==a && game[2][2]==a && game[4][2]==a)||(game[0][4]==a && game[2][4]==a && game[4][4]==a)
           ||(game[0][0]==a && game[2][2]==a && game[4][4]==a)||(game[0][4]==a && game[2][2]==a && game[4][0]==a))
        {
            return true;
        } 
        else
        {
            return false;
        }

    }

    public static void print(char[][] game)
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<game[i].length;j++)
            {
                System.out.print(game[i][j]);
            }
            System.out.println();
        }
    }

    public static void printindex(char[][] gameindex)
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<gameindex[i].length;j++)
            {
                System.out.print(gameindex[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
 

}