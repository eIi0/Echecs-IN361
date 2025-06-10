package partie1;

import java.util.ArrayList;

public class PlateauUtils
{
	static public final String[] POSITION_NUMBER_TO_LETTER =
	{ "A", "B", "C", "D", "E", "F", "G", "H" };

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

		} catch (IndexOutOfBoundsException e)
		{
			System.out.println(PlateauUtils.getColumnLetter(colonne) + ligne);
			return IPiece.class;
		}
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
}
