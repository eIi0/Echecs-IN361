package partie2;

import java.util.ArrayList;

public interface IPiece
{
	boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int colonneDepart, int ligneDepart, int colonneArrivee,
			int ligneArrivee);

	void affiche();

	/**
	 * @param ligne et colonne commencent a 0, pour être correct avec la position du
	 *              plateau, faire +1
	 */
	void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int colonne, int ligne);

	void setColor(int color);

	int getColor();

}
