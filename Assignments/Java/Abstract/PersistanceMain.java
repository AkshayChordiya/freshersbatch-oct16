
/**
	Persistance Abstract Program
	@author Akshay Chordiya
*/
public class PersistanceMain {
	
	public static final int PERSISTANCE_FILE = 0;
	public static final int PERSISTANCE_DB = 1;
	
	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		PersistanceMain pm = new PersistanceMain();
		pm.main();
    }
	
	public void main() {
		Persistence persist = new PersistenceFactory().getPersitanceInstance(PERSISTANCE_DB);
		persist.persist();
	}
	
	class PersistenceFactory {
		
		public Persistence getPersitanceInstance(int type) {
			switch (type) {
				case PERSISTANCE_FILE:
					return new FilePersistence();
				case PERSISTANCE_DB:
					return new DatabasePersistence();
			}
			return null;
		}
	}
	
	public abstract class Persistence {
		public abstract void persist();
	}
	
	public class FilePersistence extends Persistence {
		public void persist() {
			System.out.println("Data persisted into file");
		}
	} 
	
	public class DatabasePersistence extends Persistence {
		public void persist() {
			System.out.println("Data persisted into database");
		}
	} 
	

}