package test.at.fhj.itm.swd;

import at.fhj.itm.swd.Factory;

public class FactoryTest extends AbstractFactoryTest
{
	@Override
	protected Factory getFactory()
	{
		return new Factory();
	}

}
