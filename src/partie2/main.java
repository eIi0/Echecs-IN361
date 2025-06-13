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
			System.out.println("nom de la pièce (sans le .txt)");
			String read = readFile("/home/elio/IdeaProjects/Echecs-IN361/src/partie2/piecescustoms/" + scanner.nextLine() + ".txt");

			CustomPiece pieces = gson.fromJson(read, new TypeToken<CustomPiece>() {}.getType());
//			PlateauUtils.replace(plateau, )

		}

//		while (true)
//		{
//			plat.affichePlateau();
//			plat.movePiece(scanner, (nbCout % 2) == 0);
//			nbCout++;
//		}

	}

	static String readFile(String path)
			throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}

}
