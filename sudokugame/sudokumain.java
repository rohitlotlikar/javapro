import java.util.*;
public class suduko {
    public static void main(String[]args)
    {
        SudokuGridGenerator obj=new SudokuGridGenerator();
        int[] n=new int[81];
        boolean d=true;
        Scanner sc=new Scanner(System.in);
        n=obj.generate();
        char[][] sud={
            {'-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' ','-',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '},
            {' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|',' ','|'},
            {'-',' ','+',' ','-',' ','+',' ','|',' ','+',' ','-',' ','+',' ','-','|','+',' ','-',' ','+',' ','-',' ','+',' '}
            };
            System.out.println("ENTER THE LEVEL OF DIFFICULTY\n1-EASY\n2-MEDIUM\n3-HARD");
            int diff=sc.nextInt();
            while(d)
            {
                if(diff==1)
                {
                    puzzle(sud,n,27);
                    d=false;
                }
                else if(diff==2)
                {
                    puzzle(sud,n,18);
                    d=false;
                }
                else if(diff==3)
                {
                    puzzle(sud,n,9);
                    d=false;
                }else{
                    System.out.println("INVALID IN PUT");
                    d=true;
                }
            }
            sc.close();
            
                

    }

    public static void puzzle(char[][] sud,int[] n,int no)
    {
        Scanner sc=new Scanner(System.in);
        int co=0,nnum=0;
        boolean solve=true;
        Random ran=new Random();
        HashSet<Integer> num=new HashSet<Integer>();
        for(int set=0;set<no+1;set++)
        {
            int nu=ran.nextInt(81);
            num.add(nu);
        }
        for(int i=0;i<sud.length;i++)
        {
            for(int j=0;j<sud[i].length;j++)
            {
                System.out.print(sud[i][j]);
                if(i>0 && i<19 && i%2!=0 && j%2==0)
                {
                    if(num.contains(co))
                    {
                        System.out.print(n[co]);
                        nnum++;
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                    co++;
                }
            }
            System.out.println();
        }
        while(solve)
        {
            System.out.println("ENTER YOUR OPTION\n1-ATTEMPT TO SOLVE\n2-SOLVE FOR ME");
            int op=sc.nextInt();
            switch(op)
            {
                case 1:
                    attempt(sud,n,num,nnum);
                    solve=false;
                    break;
                case 2:
                    print(sud,n);
                    solve=false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
        sc.close();
    }
    public static void attempt(char[][] sud,int[] n,HashSet<Integer> num,int nnum)
    {
        Scanner sc=new Scanner(System.in);
        while(nnum!=81)
        {
            System.out.println("ENTER THE ROW AND COLUMN YOU WANT TO ENTER THE NUMBER \nEg:-r c(Press enter after row and then enter column)(number starts from 0-8)(IF YOU WANT THE SOLUTION PRESS 10 TWICE");
            int r=sc.nextInt();
            int c=sc.nextInt();
            int rc=r*9+c,co=0;
            if(rc!=100)
            {
                System.out.println("ENTER THE NUMBER YOU WANT TO ENTER IN THE PUZZLE");
                int snum=sc.nextInt();
                if(!num.contains(rc))
                {
                    num.add(rc);
                    n[rc]=snum;
                    nnum++;
                }
                for(int i=0;i<sud.length;i++)
                {
                    for(int j=0;j<sud[i].length;j++)
                    {
                        System.out.print(sud[i][j]);
                        if(i>0 && i<19 && i%2!=0 && j%2==0)
                        {
                            if(num.contains(co))
                            {
                                System.out.print(n[co]);
                            }
                            else
                            {
                                System.out.print(" ");
                            }
                            co++;
                        }
                    }
                    System.out.println();
                }
            }
            else
            {
                print(sud,n);
                break;
            }
            
            
        }
        sc.close();
    }
    public static void print(char[][] sud,int[] n)
    {
        int co=0;
        for(int i=0;i<sud.length;i++)
        {
            for(int j=0;j<sud[i].length;j++)
            {
                System.out.print(sud[i][j]);
                if(i>0 && i<19 && i%2!=0 && j%2==0)
                {
                
                    System.out.print(n[co]);
                    co++;
                }
            }
            System.out.println();
        }
        
    }
}
