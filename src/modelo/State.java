package modelo;
 /**
  * Clase que representa un estado de un AFD ya sea Moore o Mealy
  * @author David Obando
  *
  */
public class State {
	
	private String name;
	private boolean isInitial;
	
	
	public State(String name) {
		
		this.name = name;
		this.isInitial = false;
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
