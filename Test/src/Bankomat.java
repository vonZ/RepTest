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
		//S� l�nge som valet (theChoice) inte �r 4 forts�tter programmet att exekveras.
    	while (theChoice != 4)
    	{
    		//Metoden menu anropas och menyn visas.
    		theChoice = menu();
			switch(theChoice)
			{
    		case 1:
    			System.out.println("Du valde Ins�ttning. Vilken summa vill du s�tta in?: ");
    			//Summan av ins�ttningen sparas i variabeln sum.
    			sum = keyboard.nextInt();
				amount = (int) + sum;
				//Metoden makeTransaction anropas f�r att spara summan av ins�ttningen sist bland
				//de transaktioner som sparats i f�ltet trans.
				makeTransaction(amount, trans);
				break;
    		case 2:
    			System.out.println("Du valde Uttag. Vilken summa vill du ta ut?: ");
    			sum = keyboard.nextInt();
    			amount = (int) - sum;
    			makeTransaction(amount, trans);
    			break;
    		case 3:
    			//Metoden showTransactions anropas f�r att presentera de senaste transaktionerna
    			//och saldot.
    			showTransactions(trans, balance);
    			break;
    		case 4:
    			//Exekveringen av programmet avslutas.
    			System.out.println("Du valde att avsluta.");
    			break;
			}

    	}
    }  		//Metoden menu som hanterar �ch visar upp menyn.
		    public static int menu()
    		{
    			int theChoice = 0;
    			Scanner keyboard = new Scanner(System.in);
    			System.out.println("1. Ins�ttning");
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
			//som finns sparade i f�ltet trans.
   			public static void makeTransaction(int amount, int[] trans)
    		{
    			//Anropar metoden findNr f�r att se om det fanns plats ledig f�r den nya
    			//transaktionen som is�danafall sparas d�r. Om inte, returneras v�rdet -1 och
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
    		//Metoden finrNr som returnerar positionen f�r var transaktionen ska
    		//placeras.
    		public static int findNr(int[] trans)
    		{
    			int position = -1;
				//Stegar igenom f�ltet f�r att hitta f�rsta lediga plats f�r den nya
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
    		//Metoden moveTrans som g�r plats f�r den nya transaktionen.
    		public static void moveTrans(int[] trans)
    		{
				for (int i = 0; i < (trans.length-1); i++)
				trans[i] = trans[i+1];


    		}

}