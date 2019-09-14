package modelo;

public class Transition {

	
	private String input;
	private String output;
	private State origin;
	private State destination;
	/**
	 * @return the symbol
	 */
	public String getInput() {
		return input;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setInput(String input) {
		this.input = input;
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
	
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public Transition(String input, State origin, State destination) {
		super();
		this.input = input;
		this.origin = origin;
		this.destination = destination;
	}
	/**
	 * Constructor para un automata de Mealy
	 * @param input
	 * @param ooutput
	 * @param origin
	 * @param destination
	 */
	public Transition(String input, String output,State origin, State destination) {
		super();
		this.input = input;
		this.output = output;
		this.origin = origin;
		this.destination = destination;
	}
	
	
	
	
}
