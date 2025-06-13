package partie2;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CustomPiece implements IPiece
{

	private String nom;
	private String unicode;
	private int color;
	private String position;
	private int saut; // 1 = peut sauter, 0 = ne peut pas
	private ArrayList<ArrayList<Integer>> mouvements; // liste de couples [dx, dy]

	public CustomPiece()
	{
	}

	@Override
	public boolean canMove(ArrayList<ArrayList<IPiece>> plateau, int colDepart, int ligneDepart, int colArrivee, int ligneArrivee)
	{
		int dx = colArrivee - colDepart;
		int dy = ligneArrivee - ligneDepart;

		for (ArrayList<Integer> move : mouvements)
		{
			if (dx == move.get(0) && dy == move.get(1))
			{
				;
			}
			if (saut == 1)
			{
				if (colArrivee < 8 & colArrivee >= 0 & ligneArrivee < 8 & ligneArrivee >= 0)
				{
					return true;
				}
			}
			else
			{
				return (PlateauUtils.pasObstacle(plateau, colDepart, ligneDepart, colArrivee, ligneArrivee));
			}
		}
		return false;
	}

	@Override
	public void whereToMove(ArrayList<ArrayList<IPiece>> plateau, int col, int ligne)
	{
		System.out.println("pas encore implémenté");
	}

	@Override
	public void affiche()
	{
		int codePoint = Integer.decode(unicode.replace("U+", "0x"));
		System.out.print(Character.toChars(codePoint));
	}

	@Override
	public void setColor(int color)
	{
		this.color = color;
	}

	public void setColor(String color)
	{
		if (color.equals("black") | color.equals("noir"))
		{
			this.color = 1;
		}
		else        //normalement il faudrait avoir un test pour le blanc
		{
			this.color = 0;
		}
	}

	@Override
	public int getColor()
	{
		return color;
	}


	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setUnicode(String unicode)
	{
		this.unicode = unicode;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public void setMouvements(ArrayList<ArrayList<Integer>> mouvements)
	{
		this.mouvements = mouvements;
	}

	public String getNom()
	{
		return nom;
	}

	public String getPosition()
	{
		return position;
	}

	public ArrayList<ArrayList<Integer>> getMouvements()
	{
		return mouvements;
	}

	public String getUnicode()
	{
		return unicode;
	}
}
