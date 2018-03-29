package interfaces;

public interface Edible {

	/** Constants are allowed in interfaces and they make your program easier to read */
	public final static boolean COOKED = true;
	public final static boolean NOT_COOKED = false;

	/** Eats this Edible object */
	public void doEat();

}
