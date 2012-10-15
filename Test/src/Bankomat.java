import java.util.Scanner;
public class Bankomat
{
    public static void main(String[] args)
    {
    	Scanner keyboard = new Scanner(System.in);
    	//Variabeldeklaration.
    	int theChoice = 0;
    	int amount = 0;
    	int[] trans = new int[10];
    	int sum = 0;
    	int balance = 0;
		//Så länge som valet (theChoice) inte är 4 fortsätter programmet att exekveras.
    	while (theChoice != 4)
    	{
    		//Metoden menu anropas och menyn visas.
    		theChoice = menu();
			switch(theChoice)
			{
    		case 1:
    			System.out.println("Du valde Insättning. Vilken summa vill du sätta in?: ");
    			//Summan av insättningen sparas i variabeln sum.
    			sum = keyboard.nextInt();
				amount = (int) + sum;
				//Metoden makeTransaction anropas för att spara summan av insättningen sist bland
				//de transaktioner som sparats i fältet trans.
				makeTransaction(amount, trans);
				break;
    		case 2:
    			System.out.println("Du valde Uttag. Vilken summa vill du ta ut?: ");
    			sum = keyboard.nextInt();
    			amount = (int) - sum;
    			makeTransaction(amount, trans);
    			break;
    		case 3:
    			//Metoden showTransactions anropas för att presentera de senaste transaktionerna
    			//och saldot.
    			showTransactions(trans, balance);
    			break;
    		case 4:
    			//Exekveringen av programmet avslutas.
    			System.out.println("Du valde att avsluta.");
    			break;
			}

    	}
    }  		//Metoden menu som hanterar óch visar upp menyn.
		    public static int menu()
    		{
    			int theChoice = 0;
    			Scanner keyboard = new Scanner(System.in);
    			System.out.println("1. Insättning");
    			System.out.println("2. Uttag");
    			System.out.println("3. Saldobesked");
    			System.out.println("4. Avsluta");
    			System.out.print("Ditt val: ");
    			theChoice = keyboard.nextInt();

    			return theChoice;
    		}
    		//Metoden showTransactions som presenterar de senaste transaktionerna
    		//och saldot.
   			public static void showTransactions(int[] trans, int balance)
    		{
    			System.out.println();
				System.out.println("Tidigare transaktioner: ");
				System.out.println();

				for(int i = 0; i < trans.length; i++)
				{
					System.out.print(trans[i] + "\n");
					balance = balance + trans[i];
				}
				System.out.println();
				System.out.println("Saldo: " + balance + " kr" + "\n");
				System.out.println();
			}
			//Metoden makeTransaction som placeras amout sist bland de transaktioner
			//som finns sparade i fältet trans.
   			public static void makeTransaction(int amount, int[] trans)
    		{
    			//Anropar metoden findNr för att se om det fanns plats ledig för den nya
    			//transaktionen som isådanafall sparas där. Om inte, returneras värdet -1 och
    			// man anropar metoden moveTrans.
    			int position = findNr(trans);
				if (position == -1)
				{
					moveTrans(trans);
				}
				else
				{
					trans[position] = amount;
				}
    		}
    		//Metoden finrNr som returnerar positionen för var transaktionen ska
    		//placeras.
    		public static int findNr(int[] trans)
    		{
    			int position = -1;
				//Stegar igenom fältet för att hitta första lediga plats för den nya
				//transaktionen. Positionen (den lediga platsen) returneras, annars
				//returneras -1.
				for(int i = 0; i < trans.length; i++)
				{
					if (trans[i] == 0)
					{
						position = i;
					}
			}
			return position;

    		}
    		//Metoden moveTrans som gör plats för den nya transaktionen.
    		public static void moveTrans(int[] trans)
    		{
				for (int i = 0; i < (trans.length-1); i++)
				trans[i] = trans[i+1];


    		}

}