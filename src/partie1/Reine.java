package partie1;

import java.util.ArrayList;

public class Reine implements IPiece
{

	static public final int PIECE_BLANCHE = 0x2655;
	static public final int PIECE_NOIRE = 0x265B;

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
		if (colonneDepart == colonneArrivee || ligneDepart == ligneArrivee) // tour
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
			System.out.println(destination);
			return (destination instanceof Blank) || (destination.getColor() != this.getColor());
		}

		if (Math.abs(colonneArrivee - colonneDepart) == Math.abs(ligneArrivee - ligneDepart)) // fou
		{
			int couleurDepart = PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart).getColor();

			for (int i = 1; i < Math.abs(colonneArrivee - colonneDepart); i++)
			{
				int colonneIntermediaire = colonneDepart + i * ((colonneArrivee > colonneDepart) ? 1 : -1);
				int ligneIntermediaire = ligneDepart + i * ((ligneArrivee > ligneDepart) ? 1 : -1);

				if (!PlateauUtils.getPieceClass(plateau, colonneIntermediaire, ligneIntermediaire).equals(Blank.class))
				{
					return false;
				}
			}

			IPiece pieceDestination = PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee);
			if (pieceDestination instanceof Blank)
			{
				return true;
			}
			if (pieceDestination.getColor() != couleurDepart)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return false;
	}

	@Override
	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		StringBuilder possiblePosition = new StringBuilder();
		possiblePosition.append("Position possible : ");
		boolean NoActionBoolean = true;

		int couleurDepart = PlateauUtils.getPiece(plateau, colonne, ligne).getColor();

		for (int i = 1; i < 8; i++) // haut droite
		{
			int nouvelleColonne = colonne + i;
			int nouvelleLigne = ligne + i;

			if (nouvelleLigne < 0 || nouvelleLigne >= 8 || nouvelleColonne < 0 || nouvelleColonne >= 8)
			{
				break;
			}

			if (PlateauUtils.getPieceClass(plateau, nouvelleColonne, nouvelleLigne).equals(Blank.class))
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
				NoActionBoolean = false;
			}
			else
			{
				if (PlateauUtils.getPiece(plateau, nouvelleColonne, nouvelleLigne).getColor() != couleurDepart)
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
					NoActionBoolean = false;
				}
				break;
			}
		}

		for (int i = 1; i < 8; i++) // haut gauche
		{
			int nouvelleColonne = colonne - i;
			int nouvelleLigne = ligne + i;

			if (nouvelleLigne < 0 || nouvelleLigne >= 8 || nouvelleColonne < 0 || nouvelleColonne >= 8)
			{
				break;
			}

			if (PlateauUtils.getPieceClass(plateau, nouvelleColonne, nouvelleLigne).equals(Blank.class))
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
				NoActionBoolean = false;
			}
			else
			{
				if (PlateauUtils.getPiece(plateau, nouvelleColonne, nouvelleLigne).getColor() != couleurDepart)
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
					NoActionBoolean = false;
				}
				break;
			}
		}

		for (int i = 1; i < 8; i++) // bas droite
		{
			int nouvelleColonne = colonne + i;
			int nouvelleLigne = ligne - i;

			if (nouvelleLigne < 0 || nouvelleLigne >= 8 || nouvelleColonne < 0 || nouvelleColonne >= 8)
			{
				break;
			}

			if (PlateauUtils.getPieceClass(plateau, nouvelleColonne, nouvelleLigne).equals(Blank.class))
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
				NoActionBoolean = false;
			}
			else
			{
				if (PlateauUtils.getPiece(plateau, nouvelleColonne, nouvelleLigne).getColor() != couleurDepart)
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
					NoActionBoolean = false;
				}
				break;
			}
		}

		for (int i = 1; i < 8; i++) // bas gauche
		{
			int nouvelleColonne = colonne - i;
			int nouvelleLigne = ligne - i;

			if (nouvelleLigne < 0 || nouvelleLigne >= 8 || nouvelleColonne < 0 || nouvelleColonne >= 8)
			{
				break;
			}

			if (PlateauUtils.getPieceClass(plateau, nouvelleColonne, nouvelleLigne).equals(Blank.class))
			{
				possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
				NoActionBoolean = false;
			}
			else
			{
				if (PlateauUtils.getPiece(plateau, nouvelleColonne, nouvelleLigne).getColor() != couleurDepart)
				{
					possiblePosition.append(PlateauUtils.getColumnLetter(nouvelleColonne) + (nouvelleLigne + 1) + " ");
					NoActionBoolean = false;
				}
				break;
			}
		}

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
					NoActionBoolean = false;
				}
				else
				{
					if (current.getColor() != this.color)
					{
						possiblePosition.append(PlateauUtils.getColumnLetter(x) + (y + 1) + " ");
						NoActionBoolean = false;
					}
					break;
				}

				x += dir[0];
				y += dir[1];
			}
		}

		if (NoActionBoolean)
		{
			possiblePosition.append("Aucune position possible");
		}

		System.out.println(possiblePosition);

	}
}
