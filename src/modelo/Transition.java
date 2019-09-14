package modelo;

public class Transition {

	
	private String symbol;
	private State origin;
	private State destination;
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the origin
	 */
	public State getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(State origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public State getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(State destination) {
		this.destination = destination;
	}
	public Transition(String symbol, State origin, State destination) {
		super();
		this.symbol = symbol;
		this.origin = origin;
		this.destination = destination;
	}
	
	
	
	
}
