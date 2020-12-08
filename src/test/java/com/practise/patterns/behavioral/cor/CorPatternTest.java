package com.practise.patterns.behavioral.cor;

import org.junit.Assert;
import org.junit.Test;


public class CorPatternTest {


	@Test
	public void shouldTestChainOfResposibilityPattern() throws Exception {
		
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setType(ServiceLevel.LEVEL_TWO);
		serviceRequest.getSupportService().handleRequest();
		Assert.assertEquals("Level 2 request has been resolved by Supervisor !!",
				serviceRequest.getConclusion());
		
		serviceRequest.setType(ServiceLevel.LEVEL_ONE);
		serviceRequest.getSupportService().handleRequest();
		Assert.assertEquals("Level 1 request has been resolved by Front desk !!",
				serviceRequest.getConclusion());
		
		serviceRequest.setType(ServiceLevel.LEVEL_FOUR);
		serviceRequest.getSupportService().handleRequest();
		Assert.assertEquals("Level 4 request has been resolved by Director !!",
				serviceRequest.getConclusion());
		
		serviceRequest.setType(ServiceLevel.LEVEL_THREE);
		serviceRequest.getSupportService().handleRequest();
		Assert.assertEquals("Level 3 reuqest has been resoved by Manager !!",
				serviceRequest.getConclusion());
	}

	@Test
	public void shouldThrowExpectionWhenLevelUnknown() {
	    ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setType(ServiceLevel.INVALID_REQUEST);
		
		Assert.assertThrows(
				"Your problem is none of our business :: INVALID_REQUEST",
				IllegalArgumentException.class, () -> {
					serviceRequest.getSupportService().handleRequest();
				});
	}

}
