package partie1;

public class DemoPartie1
{

	public static void main(String[] args)
	{

		Plateau plateau = new Plateau();
		plateau.affichePlateau();

		jouer(plateau, "E2", "E4");   // pion blanc
		jouer(plateau, "D7", "D5");   // pion noir
		jouer(plateau, "E4", "D5");   // capture de pion
		jouer(plateau, "G1", "F3");   // cavalier blanc
		jouer(plateau, "B8", "C6");   // cavalier noir
		jouer(plateau, "F1", "C4");   // fou blanc
		jouer(plateau, "D8", "D6");   // reine noire
		jouer(plateau, "A1", "A3");   // tour blanche
		jouer(plateau, "E8", "E7");   // roi noir
		jouer(plateau, "D1", "E2");   // reine blanche
		jouer(plateau, "C8", "F5");   // fou noir
		jouer(plateau, "B1", "C3");   // cavalier blanc
		jouer(plateau, "a8", "D8");   // tour noire
	}

	private static void jouer(Plateau p, String depart, String arrivee)         //plus simple de passer par cet utilitaire, la méthode que j'utilisais initialement fonctionner avec un Scanner
	{
		int departCol = PlateauUtils.getColumnNumber(depart.substring(0, 1));
		int departRow = Integer.parseInt(depart.substring(1)) - 1;
		int arriveeCol = PlateauUtils.getColumnNumber(arrivee.substring(0, 1));
		int arriveeRow = Integer.parseInt(arrivee.substring(1)) - 1;
		IPiece piece = PlateauUtils.getPiece(p.getPlateau(), departCol, departRow);

		System.out.printf((piece.getColor() == 0 ? "Blanc" : "Noir") + ">>>   : " + depart + " -> " + arrivee);

		if (piece.canMove(p.getPlateau(), departCol, departRow, arriveeCol, arriveeRow))
		{
			PlateauUtils.invertPieces(p.getPlateau(), departCol, departRow, arriveeCol, arriveeRow);
		}
		else
		{
			System.out.println("Mouvement interdit");
		}
		p.affichePlateau();
		System.out.println();
	}
}
