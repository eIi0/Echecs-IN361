package partie2;

import java.util.ArrayList;

public class Blank implements IPiece
{

	private int color;

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
	public void affiche()
	{
		System.out.print(Character.toChars(0x2610));
	}

	@Deprecated
	@Override
	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int ligne, int colonne)
	{
		//
	}

	@Override
	public boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int ligneDepart, int colonneDepart, int ligneArrivee,
	                       int colonneArrivee)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
