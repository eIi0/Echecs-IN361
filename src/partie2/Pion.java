package partie2;

import java.util.ArrayList;

public class Pion implements IPiece
{

	static public final int PIECE_BLANCHE = 0x2659;
	static public final int PIECE_NOIRE = 0x265F;

	private int color; // 0 = white - 1 = black

	public Pion()
	{
	}
	
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

	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{

		StringBuilder possiblePosition = new StringBuilder();
		possiblePosition.append("Position possible : ");
		boolean NoActionBoolean = true;

		if (color == 0)
		{
			if (PlateauUtils.getPieceClass(plateau, colonne, ligne + 1).equals(Blank.class)) // Avancer de 1
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonne) + ((ligne + 1) + 1) + " ");
				NoActionBoolean = false;
			}
			if ((colonne + 1) < 8 && (ligne + 1) < 8
					&& !PlateauUtils.getPieceClass(plateau, colonne + 1, ligne + 1).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonne + 1, ligne + 1).getColor() != PlateauUtils.getPiece(plateau, colonne, ligne).getColor()) // Avancer-Droite
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonne + 1) + ((ligne + 1) + 1) + " ");
				NoActionBoolean = false;
			}
			if ((colonne - 1) >= 0 && (ligne + 1) < 8
					&& !PlateauUtils.getPieceClass(plateau, colonne - 1, ligne + 1).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonne - 1, ligne + 1).getColor() != PlateauUtils.getPiece(plateau, colonne, ligne).getColor()) // Avancer-gauche
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonne - 1) + ((ligne + 1) + 1) + " ");
				NoActionBoolean = false;
			}
			if ((ligne + 1) == 2) // cas départ
			{
				if (PlateauUtils.getPieceClass(plateau, colonne, ligne + 2).equals(Blank.class)
						&& PlateauUtils.getPieceClass(plateau, colonne, ligne + 1).equals(Blank.class))
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(colonne) + ((ligne + 1) + 2) + " ");
					NoActionBoolean = false;
				}
			}
			if (NoActionBoolean)
			{
				possiblePosition.append("Aucune position possible");
			}
		}

		if (color == 1)
		{
			if (PlateauUtils.getPieceClass(plateau, colonne, ligne - 1).equals(Blank.class)) // Avancer de 1
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonne) + ((ligne + 1) - 1) + " ");
				NoActionBoolean = false;
			}
			if ((colonne + 1) < 8 && (ligne + 1) < 8
					&& !PlateauUtils.getPieceClass(plateau, colonne + 1, ligne - 1).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonne + 1, ligne - 1).getColor() != PlateauUtils.getPiece(plateau, colonne, ligne).getColor()) // Avancer-Gauche
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonne + 1) + ((ligne + 1) - 1) + " ");
				NoActionBoolean = false;
			}
			if ((colonne - 1) >= 0 && (ligne + 1) < 8
					&& !PlateauUtils.getPieceClass(plateau, colonne - 1, ligne - 1).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonne - 1, ligne - 1).getColor() != PlateauUtils.getPiece(plateau, colonne, ligne).getColor()) // Avancer-Droite
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(colonne - 1) + ((ligne + 1) - 1) + " ");
				NoActionBoolean = false;
			}
			if ((ligne + 1) == 7) // cas départ
			{
				if (PlateauUtils.getPieceClass(plateau, colonne, ligne - 2).equals(Blank.class)
						&& PlateauUtils.getPieceClass(plateau, colonne, ligne - 1).equals(Blank.class))
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(colonne) + ((ligne + 1) - 2) + " ");
					NoActionBoolean = false;
				}
			}
			if (NoActionBoolean)
			{
				possiblePosition.append("Aucune position possible");
			}
		}
		System.out.println(possiblePosition);
	}

	@Override
	public boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart, int colonneArrivee, int ligneArrivee)
	{
		if (color == 0)
		{
			if (ligneArrivee == (ligneDepart + 1) && colonneArrivee == colonneDepart && ligneArrivee <= 7
					&& PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class))
			{
				return true;
			}
			else if (ligneArrivee == (ligneDepart + 1) && colonneArrivee == (colonneDepart + 1) && colonneArrivee <= 7
					&& !PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart).getColor()
		               != PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee).getColor())
			{
				return true;
			}
			else if (ligneArrivee == (ligneDepart + 1) && colonneArrivee == (colonneDepart - 1) && colonneArrivee >= 0
					&& !PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart).getColor()
		               != PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee).getColor())
			{
				return true;
			}
			else
			{
				if ((ligneDepart + 1) == 2)
				{
					if (ligneArrivee == (ligneDepart + 2) && colonneArrivee == colonneDepart
							&& PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneDepart + 1).equals(Blank.class)
							&& PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneDepart + 2).equals(Blank.class))
					{
						return true;
					}
				}
				else
				{
					return false;
				}
			}
		}
		if (color == 1)
		{
			if (ligneArrivee == (ligneDepart - 1) && colonneArrivee == colonneDepart && ligneArrivee >= 0
					&& PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class))
			{
				return true;
			}
			else if (ligneArrivee == (ligneDepart - 1) && colonneArrivee == (colonneDepart + 1) && colonneArrivee <= 7
					&& !PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart).getColor()
		               != PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee).getColor())
			{
				return true;
			}
			else if (ligneArrivee == (ligneDepart - 1) && colonneArrivee == (colonneDepart - 1) && colonneArrivee >= 0
					&& !PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class)
					&& PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart).getColor()
		               != PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee).getColor())
			{
				return true;
			}
			else
			{
				if ((ligneDepart + 1) == 7)
				{	
					if (ligneArrivee == (ligneDepart - 2) && colonneArrivee == colonneDepart
							&& PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneDepart - 1).equals(Blank.class)
							&& PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneDepart - 2).equals(Blank.class))
					{
						return true;
					}
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
}
