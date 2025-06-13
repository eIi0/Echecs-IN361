package partie2;

import java.util.ArrayList;

public class Fou implements IPiece
{

	static public final int PIECE_BLANCHE = 0x2657;
	static public final int PIECE_NOIRE = 0x265D;

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
		if (Math.abs(colonneArrivee - colonneDepart) != Math.abs(ligneArrivee - ligneDepart))
		{
			return false;
		}

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

		if (NoActionBoolean)
		{
			possiblePosition.append("Aucune position possible");
		}
		System.out.println(possiblePosition);
	}

}
