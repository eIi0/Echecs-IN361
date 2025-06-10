package partie1;

import java.util.ArrayList;

public class Cavalier implements IPiece
{

	static public final int PIECE_BLANCHE = 0x2658;
	static public final int PIECE_NOIRE = 0x265E;

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
	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		StringBuilder possiblePosition = new StringBuilder();
		possiblePosition.append("Position possible : ");
		boolean NoActionBoolean = true;

		int[][] directions =
		{
				{ -1, 2 }, // haut gauche
				{ 1, 2 }, // haut droite
				{ -1, -2 }, // bas gauche
				{ 1, -2 }, // bas droite
				{ -2, -1 }, // gauche bas
				{ -2, 1 }, // gauche haut
				{ 2, 1 }, // droite haut
				{ 2, -1 } // droite bas
		};

		for (int i = 0; i < directions.length; i++)
		{
			int colonneArrivee = colonne + directions[i][0];
			int ligneArrivee = ligne + directions[i][1];
			if (colonneArrivee < 8 && colonneArrivee >= 0 && ligneArrivee < 8 && ligneArrivee >= 0
					&& (PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class)
							|| PlateauUtils.getPiece(plateau, colonne, ligne).getColor() != PlateauUtils
									.getPiece(plateau, colonneArrivee, ligneArrivee).getColor()))
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonneArrivee) + (ligneArrivee + 1) + " ");
				NoActionBoolean = false;
			}
		}

		if (NoActionBoolean)
		{
			possiblePosition.append("Aucune position possible");
		}

		System.out.println(possiblePosition);
	}

	@Override
	public boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart, int colonneArrivee,
			int ligneArrivee)
	{
		int[][] directions =
		{
				{ -1, 2 }, // haut gauche
				{ 1, 2 }, // haut droite
				{ -1, -2 }, // bas gauche
				{ 1, -2 }, // bas droite
				{ -2, -1 }, // gauche bas
				{ -2, 1 }, // gauche haut
				{ 2, 1 }, // droite haut
				{ 2, -1 } // droite bas
		};

		for (int i = 0; i < directions.length; i++)
		{
			int colonneArriveeLoop = colonneDepart + directions[i][0];
			int ligneArriveeLoop = ligneDepart + directions[i][1];

			if (colonneArriveeLoop < 8 && colonneArriveeLoop >= 0 && ligneArriveeLoop < 8 && ligneArriveeLoop >= 0
					&& (PlateauUtils.getPieceClass(plateau, colonneArriveeLoop, ligneArriveeLoop).equals(Blank.class)
							|| PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart).getColor() != PlateauUtils
									.getPiece(plateau, colonneArriveeLoop, ligneArriveeLoop).getColor()))
			{
				if (ligneArriveeLoop == ligneArrivee && colonneArrivee == colonneArriveeLoop)
				{
					return true;
				}
			}
		}
		return false;
	}
}
