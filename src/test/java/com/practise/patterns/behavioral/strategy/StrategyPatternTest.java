package com.practise.patterns.behavioral.strategy;

import org.junit.Assert;
import org.junit.Test;

public class StrategyPatternTest {


	@Test
	public void shouldTestStrategyPattern() {
		
		SocialMediaContext context = new SocialMediaContext();
		 
        // Setting Facebook strategy.
        context.setSocialmediaStrategy(new FacebookStrategy());
        Assert.assertEquals("Connecting with Jack through Facebook", context.connect("Jack"));
 
        // Setting Twitter strategy.
        context.setSocialmediaStrategy(new TwitterStrategy());
        Assert.assertEquals("Connecting with Jack through Twitter", context.connect("Jack"));
 
        // Setting GooglePlus strategy.
        context.setSocialmediaStrategy(new GooglePlusStrategy());
        Assert.assertEquals("Connecting with Jack through GooglePlus", context.connect("Jack"));
 
	}

}
