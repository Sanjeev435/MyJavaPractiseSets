package com.practise.patterns.creational.builder;

import org.junit.Assert;
import org.junit.Test;


public class SimpleBuilderPatternTest {
	
	@Test
	public void shouldCreateObjectwithBuilderPattern(){
		
		SimpleBuilderPattern builder = new SimpleBuilderPattern.Builder("Ram", "VI")
				.age(12)
				.bloodGroup("A+")
				.gender("Male")
				.height(161)
				.rollNum(10)
				.section("D")
				.build();
		
		Assert.assertEquals(builder.getName(), "Ram");
		Assert.assertEquals(builder.getClassName(), "VI");
		
		Assert.assertEquals(builder.getGender(), "Male");
		Assert.assertEquals(builder.getBloodGroup(), "A+");
		
		Assert.assertEquals(builder.getAge(), 12);
		Assert.assertEquals(builder.getSection(), "D");
		
		Assert.assertEquals(builder.getHeight(), 161);
		Assert.assertEquals(builder.getRollNum(), 10);
		
	}

}
