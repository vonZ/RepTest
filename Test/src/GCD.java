
public class GCD 
{
	public static void main(String[] args)
	{
		int rest = 0;
		int taljare = 0;
		int namnare = 0;
		int b = (int) rest;
		long  gcd = gcd (taljare, namnare); //Greatest Coomon Divisior
		System.out.println();
		System.out.print("GCD: " + gcd);
		System.out.println();

	}


	//Greatest common divsior
	public static long gcd(long a, long b) 
	{
		if (b==0) 
			return a;
		else
			return gcd(b, a % b);
	}

}
