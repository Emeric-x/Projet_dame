package model;


import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;
	}

	@Override
	public char getColonne() {
		char colonne = ' ';
		
		colonne = this.coord.getColonne();

		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = -1;
		
		ligne = this.coord.getLigne();

		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;
		
		if(getColonne() == coord.getColonne() && getLigne() == coord.getLigne())
			hasThisCoord = true;

		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = null;
		
		color = this.pieceColor;

		return color;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = null;

		st = "["+this.coord.toString()+", "+this.pieceColor+"]";

		return st;
	}

	@Override
	public void move(Coord coord) {
		this.coord.setLigne(coord.getLigne());
		this.coord.setColonne(coord.getColonne());
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		int ascii = (int)getColonne() - (int)targetCoord.getColonne();

		if(Coord.coordonnees_valides(targetCoord))
		{
			if(isPieceToCapture && Math.abs(ascii) == 2)
			{
				ret = true;
			}
			if(!isPieceToCapture && Math.abs(ascii) == 1)
			{
				ret = true;
			}
		}

		return ret;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 

		// TODO Atelier 2

		return coordsOnItinery;
	}

	
}

