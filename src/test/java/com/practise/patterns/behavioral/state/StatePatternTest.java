package com.practise.patterns.behavioral.state;

import org.junit.Assert;
import org.junit.Test;


public class StatePatternTest {

	@Test
	public void shouldTestStatePattern() {
		DeliveryContext ctx = new DeliveryContext(null, "Test Package transaction");
        
        Assert.assertEquals("Package is acknowledged !!", ctx.update());
        Assert.assertEquals("Package is shipped !!", ctx.update());
        Assert.assertEquals("Package is in transition !!", ctx.update());
        Assert.assertEquals("Package is out of delivery !!", ctx.update());
        Assert.assertEquals("Package is delivered!!", ctx.update());
	}

}
