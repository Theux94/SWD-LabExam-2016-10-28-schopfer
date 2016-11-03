package test.at.fhj.itm.swd;

import at.fhj.itm.swd.Factory;

public class FactorySingletonTest extends AbstractFactoryTest
{
	@Override
	protected Factory getFactory()
	{
		return Factory.getInstance();
	}

}
