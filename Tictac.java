import java.util.*;
class Tictac{
	ArrayList<Integer> playerpos = new ArrayList<Integer>();
	ArrayList<Integer> cpupos = new ArrayList<Integer>();
	public static  void main(String args[])
	{
	 char[][] board = {{' ','|',' ','|',' '},
			   {'_','+','_','+','_'},
		           {' ','|',' ','|',' '},
			   {'_','+','_','+','_'},{' ','|',' ','|',' '}};
	  printboard(board);
	 while(true)
         {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("enter position:");
	 int pos = sc.nextInt();
	 if(!checkpos(board,pos)){
		 System.out.println("enter position:");
		 pos = sc.nextInt();
	 }
	 placepiece(board,pos,"player");
	 Random rm = new Random();
	 int cpupos = rm.nextInt(9)+1;
	 if(!checkpos(board,cpupos)){
		cpupos = rm.nextInt(9)+1;
	 }
	 System.out.println(cpupos);
	 placepiece(board,cpupos,"cpu");
	 printboard(board);
	 String res = checkwinner(board);
	 if(res.length()>0)
	 {
		System.out.println(res);
		break;
         }
	 }
	} 
	public static void placepiece(char[][] board,int pos,String user)
	{
		char symbol='x';
		if(user.equals("player"))
		{
			symbol='X';
		}
		else if(user.equals("cpu"))
		{
			symbol = 'O';
		}
		int k=0;
		 for(int i=0;i<5;i++)
		 {
			if(i%2==0)
			{
			for(int j=0;j<5;j++)
			{
				if(j%2==0)
				{
				  k+=1;
				  if(k==pos)
				  {
					board[i][j]=symbol;
				  }
				}
			}
		        }
		 }




	}
        public static void printboard(char[][] board)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static String checkwinner(char[][] board)
	{
	   char c = 'a';
	for(int i=0;i<5;i++)
	{
	  if(i%2==0)
          {
		if((board[i][0] == board[i][2]) && (board[i][2] == board[i][4]))
		{
		c=board[i][0];
		
		}
  	   }
	}
	for(int j=0;j<5;j++)
	{
	if(j%2==0)
	{
		if((board[0][j] == board[2][j]) && (board[2][j] == board[4][j]))
		{
			c=board[0][j];
		 
		}
	}
	}
	if((board[0][0]== board[2][2]) && (board[2][2] == board[4][4]))
	{
 	c=board[0][0];

	}

	if((board[0][4]== board[2][2]) && (board[2][2] == board[4][0]))
	{
 	c=board[4][0];
	}
	if(c=='X')
	{
 		return "player wins";
	}
	else if(c=='O')
	{
	 return "cpu wins";
	}
	else if(c=='a'){
	//System.out.println("its a tie");
	}
	 return "";
	}
	public static Boolean checkpos(char[][] board,int pos)
	{
		int k=0;
		for(int i=0;i<5;i++)
		{
			if(i%2==0)
			{
			 for(int j=0;j<5;j++)
			 {
				if(j%2==0)
				{
					k+=1;
					if(k==pos)
					{
					   if(board[i][j]=='X' || board[i][j]=='O') return false;
					}
				}
			}
		      }
		}
		return true;
	}
}
