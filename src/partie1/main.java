package partie1;

import java.util.Scanner;

public class main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Plateau plat = new Plateau();
		int nbCout = 0;

		while (true)
		{
			plat.affichePlateau();
			plat.movePiece(scanner, (nbCout % 2) == 0);
			nbCout++;
		}
	}

}
