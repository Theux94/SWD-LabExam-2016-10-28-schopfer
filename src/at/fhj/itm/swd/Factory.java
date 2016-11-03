package at.fhj.itm.swd;
import at.fhj.itm.swd.Group;
import at.fhj.itm.swd.User;
import at.fhj.itm.swd.IntegerSequence;


public class Factory implements FactoryMethods {
	
	private static Factory instance = new Factory();//Singleton
	
	IntegerSequence iSforGroup;
	IntegerSequence iSforUser;
	
	public static Group createDefaultGroup(int id, String name){
		Group g=new Group(id, name);
		return g;
	};
	
	public Group createGroup(String name) {
		
		Group g=new Group(iSforGroup.getNextValue(), name);
		return g;
	};

	public static User createDefaultUser(int id, String username, String password){
		User u = new User(id, username, password);
		return u;
	}

	public User createUser(String username, String password) {
	
		User u = new User(iSforUser.hashCode(), username, password);
		return u;
	}

	public static Factory getInstance() {
		return instance;
	}



	}

