package model;


import java.util.Objects;

/**
 * @author francoiseperrin
 *
 * Coordonnées des PieceModel
 */
public class Coord implements Comparable<Coord>{
	
	private char colonne; 	// ['a'..'j']
	private int ligne;		// [10..1]
	static final int MAX = ModelConfig.LENGTH;	// 10

	public Coord(char colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}

	public void setColonne(char colonne) {
		this.colonne = colonne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public char getColonne() {
		return colonne;
	}

	public int getLigne() {
		return ligne;
	}


	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}


	/**
	 * @param coord
	 * @return true si 'a' <= col < 'a'+MAX et 1 < lig <= MAX
	 */
	public static boolean coordonnees_valides(Coord coord){

		boolean ret = false;

		if((coord.colonne >= 'a' && coord.colonne < 'a' + MAX) && (coord.ligne > 1 && coord.ligne <= MAX))
		{
			ret = true;
		}
		
		return ret;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * La méthode compareTo() indique comment comparer un objet à l'objet courant
	 * selon l'ordre dit naturel
	 * Dans cet application, nous décidons que l'ordre naturel est celui 
	 * correspondant au N° de la case d'un tableau 2D représenté par la Coord
	 * ainsi le N° 1 correspond à la Coord ['a', 10], le N° 100 correspond à la Coord ['j', 1]  
	 */
	@Override
	public int compareTo(Coord o) {
		int ret = 999;

		int numCoord1 = (this.colonne - 'a') * MAX + this.ligne;
		int numCoord2 = (o.colonne - 'a') * MAX + o.ligne;

		if (numCoord1 < numCoord2) {
			ret = -1;
		} else if (numCoord1 > numCoord2) {
			ret = 1;
		} else
			ret = 0;
		
		return ret ;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coord coord = (Coord) o;
		return colonne == coord.colonne && ligne == coord.ligne;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colonne, ligne);
	}
}
