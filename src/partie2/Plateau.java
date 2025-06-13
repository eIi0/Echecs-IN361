package partie2;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau
{

	private Pion pionNA7;
	private Pion pionNB7;
	private Pion pionNC7;
	private Pion pionND7;
	private Pion pionNE7;
	private Pion pionNF7;
	private Pion pionNG7;
	private Pion pionNH7;

	private Tour tourNA8;
	private Cavalier cavalierNB8;
	private Fou fouNC8;
	private Reine reineND8;
	private Roi roiNE8;
	private Fou fouNF8;
	private Cavalier cavalierNG8;
	private Tour tourNH8;

	private Blank blankA3;
	private Blank blankB3;
	private Blank blankC3;
	private Blank blankD3;
	private Blank blankE3;
	private Blank blankF3;
	private Blank blankG3;
	private Blank blankH3;

	private Blank blankA4;
	private Blank blankB4;
	private Blank blankC4;
	private Blank blankD4;
	private Blank blankE4;
	private Blank blankF4;
	private Blank blankG4;
	private Blank blankH4;

	private Blank blankA5;
	private Blank blankB5;
	private Blank blankC5;
	private Blank blankD5;
	private Blank blankE5;
	private Blank blankF5;
	private Blank blankG5;
	private Blank blankH5;

	private Blank blankA6;
	private Blank blankB6;
	private Blank blankC6;
	private Blank blankD6;
	private Blank blankE6;
	private Blank blankF6;
	private Blank blankG6;
	private Blank blankH6;

	private Pion pionBA2;
	private Pion pionBB2;
	private Pion pionBC2;
	private Pion pionBD2;
	private Pion pionBE2;
	private Pion pionBF2;
	private Pion pionBG2;
	private Pion pionBH2;

	private Tour tourBA1;
	private Cavalier cavalierBB1;
	private Fou fouBC1;
	private Reine reineBD1;
	private Roi roiBE1;
	private Fou fouBF1;
	private Cavalier cavalierBG1;
	private Tour tourBH1;

	private ArrayList<ArrayList<IPiece>> plateau;

	public Plateau()
	{

		this.plateau = initPlateau();
	}

	private ArrayList<ArrayList<IPiece>> initPlateau()
	{
		ArrayList<ArrayList<IPiece>> plateau = new ArrayList<>();

		// création des objets + set des couleurs de pieces
		tourNA8 = new Tour();
		tourNA8.setColor(1);
		cavalierNB8 = new Cavalier();
		cavalierNB8.setColor(1);
		fouNC8 = new Fou();
		fouNC8.setColor(1);
		reineND8 = new Reine();
		reineND8.setColor(1);
		roiNE8 = new Roi();
		roiNE8.setColor(1);
		fouNF8 = new Fou();
		fouNF8.setColor(1);
		cavalierNG8 = new Cavalier();
		cavalierNG8.setColor(1);
		tourNH8 = new Tour();
		tourNH8.setColor(1);

		pionNA7 = new Pion();
		pionNA7.setColor(1);
		pionNB7 = new Pion();
		pionNB7.setColor(1);
		pionNC7 = new Pion();
		pionNC7.setColor(1);
		pionND7 = new Pion();
		pionND7.setColor(1);
		pionNE7 = new Pion();
		pionNE7.setColor(1);
		pionNF7 = new Pion();
		pionNF7.setColor(1);
		pionNG7 = new Pion();
		pionNG7.setColor(1);
		pionNH7 = new Pion();
		pionNH7.setColor(1);

		pionBA2 = new Pion();
		pionBA2.setColor(0);
		pionBB2 = new Pion();
		pionBB2.setColor(0);
		pionBC2 = new Pion();
		pionBC2.setColor(0);
		pionBD2 = new Pion();
		pionBD2.setColor(0);
		pionBE2 = new Pion();
		pionBE2.setColor(0);
		pionBF2 = new Pion();
		pionBF2.setColor(0);
		pionBG2 = new Pion();
		pionBG2.setColor(0);
		pionBH2 = new Pion();
		pionBH2.setColor(0);

		tourBA1 = new Tour();
		tourBA1.setColor(0);
		cavalierBB1 = new Cavalier();
		cavalierBB1.setColor(0);
		fouBC1 = new Fou();
		fouBC1.setColor(0);
		reineBD1 = new Reine();
		reineBD1.setColor(0);
		roiBE1 = new Roi();
		roiBE1.setColor(0);
		fouBF1 = new Fou();
		fouBF1.setColor(0);
		cavalierBG1 = new Cavalier();
		cavalierBG1.setColor(0);
		tourBH1 = new Tour();
		tourBH1.setColor(0);

		blankA3 = new Blank();
		blankA3.setColor(2);
		blankB3 = new Blank();
		blankB3.setColor(2);
		blankC3 = new Blank();
		blankC3.setColor(2);
		blankD3 = new Blank();
		blankD3.setColor(2);
		blankE3 = new Blank();
		blankE3.setColor(2);
		blankF3 = new Blank();
		blankF3.setColor(2);
		blankG3 = new Blank();
		blankG3.setColor(2);
		blankH3 = new Blank();
		blankH3.setColor(2);

		blankA4 = new Blank();
		blankA4.setColor(2);
		blankB4 = new Blank();
		blankB4.setColor(2);
		blankC4 = new Blank();
		blankC4.setColor(2);
		blankD4 = new Blank();
		blankD4.setColor(2);
		blankE4 = new Blank();
		blankE4.setColor(2);
		blankF4 = new Blank();
		blankF4.setColor(2);
		blankG4 = new Blank();
		blankG4.setColor(2);
		blankH4 = new Blank();
		blankH4.setColor(2);

		blankA5 = new Blank();
		blankA5.setColor(2);
		blankB5 = new Blank();
		blankB5.setColor(2);
		blankC5 = new Blank();
		blankC5.setColor(2);
		blankD5 = new Blank();
		blankD5.setColor(2);
		blankE5 = new Blank();
		blankE5.setColor(2);
		blankF5 = new Blank();
		blankF5.setColor(2);
		blankG5 = new Blank();
		blankG5.setColor(2);
		blankH5 = new Blank();
		blankH5.setColor(2);

		blankA6 = new Blank();
		blankA6.setColor(2);
		blankB6 = new Blank();
		blankB6.setColor(2);
		blankC6 = new Blank();
		blankC6.setColor(2);
		blankD6 = new Blank();
		blankD6.setColor(2);
		blankE6 = new Blank();
		blankE6.setColor(2);
		blankF6 = new Blank();
		blankF6.setColor(2);
		blankG6 = new Blank();
		blankG6.setColor(2);
		blankH6 = new Blank();
		blankH6.setColor(2);

		// ajout des pieces sur l'echequier
		ArrayList<IPiece> ligne1 = new ArrayList<>();
		ligne1.add(tourBA1);
		ligne1.add(cavalierBB1);
		ligne1.add(fouBC1);
		ligne1.add(reineBD1);
		ligne1.add(roiBE1);
		ligne1.add(fouBF1);
		ligne1.add(cavalierBG1);
		ligne1.add(tourBH1);

		ArrayList<IPiece> ligne2 = new ArrayList<>();
		ligne2.add(pionBA2);
		ligne2.add(pionBB2);
		ligne2.add(pionBC2);
		ligne2.add(pionBD2);
		ligne2.add(pionBE2);
		ligne2.add(pionBF2);
		ligne2.add(pionBG2);
		ligne2.add(pionBH2);

		ArrayList<IPiece> ligne3 = new ArrayList<>();
		ligne3.add(blankA3);
		ligne3.add(blankB3);
		ligne3.add(blankC3);
		ligne3.add(blankD3);
		ligne3.add(blankE3);
		ligne3.add(blankF3);
		ligne3.add(blankG3);
		ligne3.add(blankH3);

		ArrayList<IPiece> ligne4 = new ArrayList<>();
		ligne4.add(blankA4);
		ligne4.add(blankB4);
		ligne4.add(blankC4);
		ligne4.add(blankD4);
		ligne4.add(blankE4);
		ligne4.add(blankF4);
		ligne4.add(blankG4);
		ligne4.add(blankH4);

		ArrayList<IPiece> ligne5 = new ArrayList<>();
		ligne5.add(blankA5);
		ligne5.add(blankB5);
		ligne5.add(blankC5);
		ligne5.add(blankD5);
		ligne5.add(blankE5);
		ligne5.add(blankF5);
		ligne5.add(blankG5);
		ligne5.add(blankH5);

		ArrayList<IPiece> ligne6 = new ArrayList<>();
		ligne6.add(blankA6);
		ligne6.add(blankB6);
		ligne6.add(blankC6);
		ligne6.add(blankD6);
		ligne6.add(blankE6);
		ligne6.add(blankF6);
		ligne6.add(blankG6);
		ligne6.add(blankH6);

		ArrayList<IPiece> ligne7 = new ArrayList<>();
		ligne7.add(pionNA7);
		ligne7.add(pionNB7);
		ligne7.add(pionNC7);
		ligne7.add(pionND7);
		ligne7.add(pionNE7);
		ligne7.add(pionNF7);
		ligne7.add(pionNG7);
		ligne7.add(pionNH7);

		ArrayList<IPiece> ligne8 = new ArrayList<>();
		ligne8.add(tourNA8);
		ligne8.add(cavalierNB8);
		ligne8.add(fouNC8);
		ligne8.add(reineND8);
		ligne8.add(roiNE8);
		ligne8.add(fouNF8);
		ligne8.add(cavalierNG8);
		ligne8.add(tourNH8);

		plateau.add(ligne1);
		plateau.add(ligne2);
		plateau.add(ligne3);
		plateau.add(ligne4);
		plateau.add(ligne5);
		plateau.add(ligne6);
		plateau.add(ligne7);
		plateau.add(ligne8);

		return plateau;
	}

	public void affichePlateau()
	{
		for (int i = 8; i > 0; i--)
		{
			System.out.println();
			System.out.print(i + "|");
			ArrayList<IPiece> ligne = plateau.get((i - 1));
			for (int j = 0; j < 8; j++)
			{
				ligne.get(j).affiche();
				System.out.print("|");
			}
		}
		System.out.println();
		System.out.print(" |A|B|C|D|E|F|G|H|");
	}

	public void movePiece(Scanner sc, boolean isWhiteToMove)
	{
		System.out.println();

		boolean loopColor = true;

		String pieceABougerString = null;
		String pieceABougerColumn = null;
		String pieceABougerLine = null;
		IPiece pieceABouger = null;

		while (loopColor)
		{
			while (true)
			{
				System.out.println("Pièce à bouger : ");
				pieceABougerString = sc.next();
				if (pieceABougerString.length() != 2)
				{
					System.out.println("Mauvais String renseigné : lettre (A->H) + chiffre (1->8)");
				}
				else
				{
					break;
				}

			}

			pieceABougerColumn = pieceABougerString.substring(0, 1);
			pieceABougerLine = pieceABougerString.substring(1, 2);

			pieceABouger = PlateauUtils.getPiece(plateau, PlateauUtils.getColumnNumber(pieceABougerColumn),
					Integer.parseInt(pieceABougerLine) - 1);

			if (pieceABouger == null || pieceABouger instanceof Blank)
			{
				System.out.println("Aucune pièce à cette position");
				continue;
			}

			int pieceColor = pieceABouger.getColor();

			if ((pieceColor == 0 && isWhiteToMove) || (pieceColor == 1 && !isWhiteToMove))
			{
				loopColor = false;
			}
			else
			{
				System.out.println("Mauvaise couleur");
			}
		}

		pieceABouger.whereToMove(plateau, PlateauUtils.getColumnNumber(pieceABougerColumn),
				Integer.parseInt(pieceABougerLine) - 1);

		boolean loopCanMove = true;

		String pieceNouvellePositionString = null;
		while (loopCanMove)
		{
			while (true)
			{
				System.out.println("Déplacer en : ");
				pieceNouvellePositionString = sc.next();
				if (pieceNouvellePositionString.length() != 2)
				{
					System.out.println("Mauvais String renseigné : lettre (A->H) + chiffre (1->8)");
				}
				else
				{
					break;
				}

			}

			String pieceNouvellePositionColumn = pieceNouvellePositionString.substring(0, 1);
			String pieceNouvellePositionLine = pieceNouvellePositionString.substring(1, 2);

			boolean moveAllowed = pieceABouger.canMove(plateau, PlateauUtils.getColumnNumber(pieceABougerColumn),
					Integer.parseInt(pieceABougerLine) - 1, PlateauUtils.getColumnNumber(pieceNouvellePositionColumn),
					Integer.parseInt(pieceNouvellePositionLine) - 1);

			if (moveAllowed)
			{
				PlateauUtils.invertPieces(plateau, PlateauUtils.getColumnNumber(pieceABougerColumn),
						Integer.parseInt(pieceABougerLine) - 1,
						PlateauUtils.getColumnNumber(pieceNouvellePositionColumn),
						Integer.parseInt(pieceNouvellePositionLine) - 1);
				loopCanMove = false;
			}
			else
			{
				System.out.println("Mauvaise position");
			}
		}
	}
}
