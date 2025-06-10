package partie1;

import java.util.ArrayList;

public class Roi implements IPiece
{

	static public final int PIECE_BLANCHE = 0x2656;
	static public final int PIECE_NOIRE = 0x265C;

	private int color; // 0 = white - 1 = black

	@Override
	public void setColor(int color)
	{
		this.color = color;
	}

	@Override
	public int getColor()
	{
		return color;
	}

	@Override
	public void affiche()	//Couleurs inversées car IDE en thème foncé
	{
		if (color == 1)
		{
			System.out.print(Character.toChars(PIECE_BLANCHE));
		}
		else
		{
			System.out.print(Character.toChars(PIECE_NOIRE));
		}
	}

	@Override
	public boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart, int colonneArrivee,
			int ligneArrivee)
	{

		System.out.println(PlateauUtils.getColumnLetter(colonneArrivee) + (ligneArrivee + 1));
		if (ligneArrivee < 0 || ligneArrivee > 7 || colonneArrivee < 0 || colonneArrivee > 7)
		{
			return false;
		}

		int deltaColonne = colonneArrivee - colonneDepart;
		int deltaLigne = ligneArrivee - ligneDepart;
		if (deltaColonne > 1 || deltaLigne > 1)
		{
			return false;
		}

		IPiece destination = PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee);
		if (destination.getColor() == color)
		{
			return false;
		}

		return true;
	}

	@Override
	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		StringBuilder possiblePosition = new StringBuilder();
		possiblePosition.append("Position possible : ");
		boolean NoActionBoolean = true;

		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				if (i == 0 && j == 0)
				{
					continue;
				}

				int colonneTemp = colonne + i;
				int ligneTemp = ligne + j;

				if (colonneTemp >= 0 && colonneTemp < 8 && ligneTemp >= 0 && ligneTemp < 8)
				{
					IPiece destination = PlateauUtils.getPiece(plateau, colonneTemp, (ligneTemp));
					if (destination.getColor() != this.color)
					{
						NoActionBoolean = false;
						possiblePosition.append(PlateauUtils.getColumnLetter(colonneTemp) + (ligneTemp + 1) + " ");
					}
				}
			}
		}

		if (NoActionBoolean)
		{
			possiblePosition.append("Aucune position possible");
		}
		System.out.println(possiblePosition);
	}
}
