import java.util.Scanner;
 
 
public class Bank 
{
 
    public static void main(String[] args)
    {
         Scanner keyboard = new Scanner(System.in);
 
         int amount = 0;
         int choice = 0;
         int [] transactions = new int[10];
         int sum;
         int balance = 0;
 
         while (choice != 4)
         {
         	choice = menu();
         	switch(choice)
         	{
         		case 1:
         				System.out.print("Vilken summa vill du sätta in? :");
         				sum = keyboard.nextInt();
         					if(sum == 0)
         					{
         						System.out.print("Du har angett ett felaktigt belopp.");
         						System.out.println();
         						System.out.println();
         					}
         						else
         						{
         							amount = (int) + sum;
         							makeTransactions(amount, transactions);
         						}
         						break;
 
         		case 2:
         				System.out.print("Vilken summa vill du ta ut?: ");
         				sum = keyboard.nextInt();
         					if(sum == 0)
         					{
         						System.out.print("Du har angett ett felaktigt belopp.");
         						System.out.println();
         						System.out.println();
         					}
         						else
         						{
         							amount = (int) - sum;
         							makeTransactions(amount, transactions);
         						}
         						break;
 
         		case 3:
         				showTransactions(transactions, balance);
         				break;
 
         		case 4:
         				System.out.println("du valde att avsluta ");
         				break;
         	}	
 
         }
    }
 
 
    	public static int menu()
    	{
    		Scanner keyboard = new Scanner(System.in);
    		int choice = 0;
 
    		System.out.println("Enkel bankomat ");
    		System.out.println();
    		System.out.println("1. Insättning ");
    		System.out.println("2. Uttag ");
    		System.out.println("3. Saldobesked ");
    		System.out.println("4. Avsluta ");
    		System.out.println();
    		System.out.println("Ditt val: ");
 
    		choice = keyboard.nextInt();
    		return choice;
    	}
 
		public static void showTransactions(int [] transactions, int balance)
		{
			System.out.println();
			System.out.println("Tidigare transaktioner :");
			System.out.println();
 
				for(int i = 0; i < transactions.length-1; i++)
				{
					if(transactions[i] == 0)
					{
						System.out.print("");
					}
 
						else
						{
							System.out.print(transactions[i] + "\n");
							balance = balance + transactions[i];
 
						}
 
				}
			System.out.println();
			System.out.println("Saldo: " + balance + " kr" + "\n" );
			System.out.println();		
 
		}
 
		public static void makeTransactions(int amount, int [] transactions)
		{
			int position = findNr(transactions);
			if(position == -1)
			{
				moveTrans(transactions);
					position = findNr(transactions);
					transactions[position] = amount;
			}
			else
			{
				transactions[position] = amount;
			}	
 
		}
 
		public static int findNr(int [] transactions)
		{
			int position = -1;
 
			for(int i = 0; i < transactions.length-1; i++)
			{
				if(transactions[i] == 0)
				{
					position = i;
					break;
				}	
			}
			return position;
		}
 
		public static void moveTrans(int [] transactions)
		{
			for(int i = 0; i < transactions.length-1; i++)
 
				transactions[0] = transactions[i + 1] ;
 
		}
 
 
}