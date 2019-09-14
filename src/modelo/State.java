package modelo;
 /**
  * Clase que representa un estado de un AFD ya sea Moore o Mealy
  * @author David Obando
  *
  */
public class State {
	
	private String name;
	private String output;
	private boolean isInitial;
	
	
	public State(String name) {
		
		this.name = name;
		this.isInitial = false;
	}
	/**
	 * Constructor para un automata de Moore
	 * @param name
	 * @param output
	 */
   public State(String name,String output) {
		
		this.name = name;
		this.output=output;
		this.isInitial = false;
		
	}

	
	public String getOutput() {
		return output;
	}


	public void setOutput(String output) {
		this.output = output;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isInitial() {
		return isInitial;
	}
	
	public void setInitial(boolean isInitial) {
		this.isInitial = isInitial;
	}
	
	
	
	
	

}
