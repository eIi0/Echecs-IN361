package partie2;

import java.util.ArrayList;

public class PlateauUtils
{
	static public final String[] POSITION_NUMBER_TO_LETTER =
			{"A", "B", "C", "D", "E", "F", "G", "H"};

	public static IPiece getPiece(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		return plateau.get(ligne).get(colonne);
	}

	public static void setPiece(ArrayList<ArrayList<IPiece>> plateau, IPiece piece, int colonne, int ligne)
	{
		plateau.get(ligne).set(colonne, piece);
	}

	public static Class<? extends IPiece> getPieceClass(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		try
		{
			return plateau.get(ligne).get(colonne).getClass();

		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println(PlateauUtils.getColumnLetter(colonne) + ligne);
			return IPiece.class;
		}
	}

	public static int getPieceColor(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne)
	{
		return plateau.get(ligne).get(colonne).getColor();
	}

	public static String getColumnLetter(int position)
	{
		return POSITION_NUMBER_TO_LETTER[position];
	}

	public static int getColumnNumber(String letter)
	{
		for (int i = 0; i < POSITION_NUMBER_TO_LETTER.length; i++)
		{
			if (POSITION_NUMBER_TO_LETTER[i].equalsIgnoreCase(letter))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param ligne et colonne commencent a 0, faire -1 lors de l'appel de la
	 *              méthode
	 */
	public static void invertPieces(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart,
	                                int colonneArrivee, int ligneArrivee)
	{
		IPiece pieceDepartChangement = PlateauUtils.getPiece(plateau, colonneDepart, ligneDepart);
		if (PlateauUtils.getPieceClass(plateau, colonneArrivee, ligneArrivee).equals(Blank.class))
		{
			IPiece pieceBlankChangement = PlateauUtils.getPiece(plateau, colonneArrivee, ligneArrivee);
			PlateauUtils.setPiece(plateau, pieceBlankChangement, colonneDepart, ligneDepart);
			PlateauUtils.setPiece(plateau, pieceDepartChangement, colonneArrivee, ligneArrivee);
		}
		else
		{
			IPiece pieceBlankChangement = new Blank();
			pieceBlankChangement.setColor(2);
			PlateauUtils.setPiece(plateau, pieceBlankChangement, colonneDepart, ligneDepart);
			PlateauUtils.setPiece(plateau, pieceDepartChangement, colonneArrivee, ligneArrivee);
		}
	}

	public static boolean pasObstacle(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart,
	                                  int colonneArrivee, int ligneArrivee)
	{
		if (colonneDepart == colonneArrivee || ligneDepart == ligneArrivee) // lignes
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

			return (destination instanceof Blank) || (destination.getColor() != getPieceColor(plateau, colonneDepart, ligneDepart));
		}

		if (Math.abs(colonneArrivee - colonneDepart) == Math.abs(ligneArrivee - ligneDepart)) // diagonales
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

	public static void replacePiece(Plateau plateau, IPiece piece, int colonne, int ligne)
	{
		plateau.getPlateau().get(ligne).set(colonne, piece);
	}
}
