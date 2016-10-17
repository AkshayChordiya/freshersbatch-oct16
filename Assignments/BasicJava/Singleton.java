
/**
	Singleton Program
	@author Akshay Chordiya
*/
public final class Singleton {
	
	private static Singleton sSingleton;
	private int variable;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (sSingleton == null) {
			sSingleton = new Singleton();
			return sSingleton;
		}
		return sSingleton;
	}
	
	public void setVariable(int variable) {
		this.variable = variable; 
	}
	
	public int getVariable() {
		return variable; 
	}
	

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		Singleton.getInstance().setVariable(10);
        System.out.println(Singleton.getInstance().getVariable());
    }

}