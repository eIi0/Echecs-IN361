package partie2;

import java.util.ArrayList;

public class Tour implements IPiece
{

	static public final int PIECE_BLANCHE = 0x2656;
	static public final int PIECE_NOIRE = 0x265C;

	private int color; // 0 = white - 1 = black - 2 = blank

	public Tour()
	{
		super();
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

	@Override
	public boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart, int colonneArrivee,
	                       int ligneArrivee)
	{
		if (colonneDepart != colonneArrivee && ligneDepart != ligneArrivee)
		{
			return false;
		}

		int deltaColonne = Integer.compare(colonneArrivee, colonneDepart);
		int deltaLigne = Integer.compare(ligneArrivee, ligneDepart);

		int currentColonne = colonneDepart + deltaColonne;
		int currentLigne = ligneDepart + deltaLigne;

		while (currentColonne != colonneArrivee || currentLigne != ligneArrivee)
		{
			IPiece currentPiece = PlateauUtils.getPiece(plateau, currentColonne, currentLigne);
			if (!(currentPiece instanceof Blank))
			{
				return false;
			}
			currentColonne += deltaColonne;
			currentLigne += deltaLigne;
		}

		IPiece destination = PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee);
//		System.out.println(destination);
		return (destination instanceof Blank) || (destination.getColor() != this.getColor());
	}

	@Override
	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		StringBuilder possiblePosition = new StringBuilder();
		possiblePosition.append("Positions possibles : ");
		boolean actionPossible = false;

		int[][] directions =
		{
				{ 1, 0 }, // droite
				{ -1, 0 }, // gauche
				{ 0, 1 }, // bas
				{ 0, -1 } // haut
		};

		for (int[] dir : directions)
		{
			int x = colonne + dir[0];
			int y = ligne + dir[1];

			while (x >= 0 && x < 8 && y >= 0 && y < 8)
			{
				IPiece current = PlateauUtils.getPiece(plateau, x, y);

				if (current.getClass().equals(Blank.class))
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(x) + (y + 1) + " ");
					actionPossible = true;
				}
				else
				{
					if (current.getColor() != this.color)
					{
						possiblePosition.append(PlateauUtils.getColumnLetter(x) + (y + 1) + " ");
						actionPossible = true;
					}
					break;
				}

				x += dir[0];
				y += dir[1];
			}
		}

		if (actionPossible)
		{
			System.out.println(possiblePosition.toString());
		}
		else
		{
			System.out.println("Aucune action possible");
		}
	}
}
