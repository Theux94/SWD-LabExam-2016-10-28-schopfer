package at.fhj.itm.swd;
import at.fhj.itm.swd.Group;
import at.fhj.itm.swd.User;
import at.fhj.itm.swd.IntegerSequence;


public class Factory implements FactoryMethods {
	

	
	private static Factory instance = new Factory();
	
	protected Factory(){
	}

	@Override
	public Group createGroup(String name) {
		return new Group(IntegerSequence.getNextValue(), name);
	}

	@Override
	public User createUser(String username, String password) {
		return new User(IntegerSequence.getNextValue(), username, password);
	}

	
	public static Factory getInstance() {
		return instance;
	}

	}

