package partie2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



public class main
{
	private final static String PATH = "/home/elio/IdeaProjects/Echecs-IN361/src/partie2/piecescustoms/";

	public static void main(String[] args) throws IOException
	{
		Gson gson = new Gson();

		Scanner scanner = new Scanner(System.in);
		Plateau plat = new Plateau();
		int nbCout = 0;

		System.out.println("Combien de pièces a ajouter ? ");
		int nb = scanner.nextInt();
		for (int i=0; i< nb; i++)
		{
			System.out.println("Nom de la pièce (case sensitive + mettre l'extension)");
			String val = scanner.next();
			String read = readFile(PATH + val);

			CustomPiece piece = gson.fromJson(read, new TypeToken<CustomPiece>() {}.getType());
			PlateauUtils.replacePiece(plat, piece, PlateauUtils.getColumnNumber(piece.getPosition().substring(0,1)), Integer.parseInt(piece.getPosition().substring(1,2))-1);
		}

		while (true)
		{
			plat.affichePlateau();
			plat.movePiece(scanner, (nbCout % 2) == 0);
			nbCout++;
		}

	}

	static String readFile(String path)
			throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}

}
