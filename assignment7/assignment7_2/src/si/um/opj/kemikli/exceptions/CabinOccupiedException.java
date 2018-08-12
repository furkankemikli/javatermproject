package si.um.opj.kemikli.exceptions;

public class CabinOccupiedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3472710539373506051L;
	int cabin;
	
	public CabinOccupiedException(int a) {
		cabin = a;
	}
	
	@Override
	public String toString() {
		return "CabinOccupiedException: Cabin " + cabin + " is occupied.";
	}
}
