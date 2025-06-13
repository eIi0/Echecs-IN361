package partie2;

import com.google.gson.Gson;
import java.io.FileReader;

public class DemoPartie2
{

	public static void main(String[] args) throws Exception
	{

		Plateau plateau = new Plateau();

		Gson gson = new Gson();
		CustomPiece lion;               // Path a modifier pour vos tests M. Brun :)
		try (FileReader reader = new FileReader("/home/elio/IdeaProjects/Echecs-IN361/src/partie2/piecescustoms/Lion.json"))
		{
			lion = gson.fromJson(reader, CustomPiece.class);
		}

		int col = PlateauUtils.getColumnNumber(lion.getPosition().substring(0, 1));
		int row = Integer.parseInt(lion.getPosition().substring(1)) - 1;

		plateau.getPlateau().get(row).set(col, lion);
		plateau.affichePlateau();

		jouer(plateau, "B1", "D3");   // saut +2,+2
		jouer(plateau, "C7", "C5");   // pion noir
		jouer(plateau, "D3", "B5");   // saut -2,+2 (passe au-dessus du pion)
	}

	private static void jouer(Plateau p, String depart, String arrivee)         //plus simple de passer par cet utilitaire, la méthode que j'utilisais initialement fonctionner avec un Scanner
	{
		int departCol = partie1.PlateauUtils.getColumnNumber(depart.substring(0, 1));
		int departRow = Integer.parseInt(depart.substring(1)) - 1;
		int arriveeCol = partie1.PlateauUtils.getColumnNumber(arrivee.substring(0, 1));
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