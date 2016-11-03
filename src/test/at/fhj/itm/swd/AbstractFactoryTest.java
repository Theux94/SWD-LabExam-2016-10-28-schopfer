package test.at.fhj.itm.swd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.fhj.itm.swd.Factory;
import at.fhj.itm.swd.Group;
import at.fhj.itm.swd.IntegerSequence;
import at.fhj.itm.swd.User;

public abstract class AbstractFactoryTest
{
    protected Group group;
    protected Factory factory;
    
    protected abstract Factory getFactory();
    
    @Before
    public void setup()
    {
    	IntegerSequence.setInitValue(1);
    	
    	factory = getFactory();
        group = factory.createGroup("students");
        
        User u1 = factory.createUser("homer", "***");
        group.addUser(u1);
        u1.setGroup(group);
        
        User u2 = factory.createUser("marge", "***");
        group.addUser(u2);
        u2.setGroup(group);
    }

    
    @Test
    public void testUserToString()
    {
    	User u = Factory.getInstance().createUser("lisa", "**********");
    	
    	Assert.assertEquals("4,lisa,**********", u.toString());
    }
    
    
    @Test
    public void testGroupToString()
    {    	
    	final String EXPECTED = "1,students,2,homer,***3,marge,***";
    	Assert.assertEquals(EXPECTED, group.toString());
    }
    
    
    @Test
    public void testNavigation()
    {
        Assert.assertEquals(2, group.getUsers().size());
        
        Assert.assertEquals("homer",group.getUsers().get(0).getUsername());
        Assert.assertEquals("marge",group.getUsers().get(1).getUsername());

        User u1 = group.getUsers().get(0);
        Assert.assertEquals("homer", u1.getUsername());        
        Assert.assertEquals("students", u1.getGroup().getName());
    }
}
