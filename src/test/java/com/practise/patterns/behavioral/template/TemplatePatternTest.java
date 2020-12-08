package com.practise.patterns.behavioral.template;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;


public class TemplatePatternTest {


	@Test
	public void shouldTestTemplatePattern() {
		
		House house = new ConcreteWallHouse();
        List<String> processesExecutedForConcreate = house.buildhouse();
        
        Assert.assertTrue(CollectionUtils.isNotEmpty(processesExecutedForConcreate));
        Assert.assertEquals(7, processesExecutedForConcreate.size());
        Assert.assertEquals("Base has been constructed.", processesExecutedForConcreate.get(0));
        Assert.assertEquals("Roof has been constructed.", processesExecutedForConcreate.get(1));
        Assert.assertEquals("Constructing Concrete Wall for my House", processesExecutedForConcreate.get(2));
        Assert.assertEquals("Constructing Windows for Concrete Wall House", processesExecutedForConcreate.get(3));
        Assert.assertEquals("Constructing Doors for Concrete Wall House", processesExecutedForConcreate.get(4));
        Assert.assertEquals("Painting Concrete Wall House", processesExecutedForConcreate.get(5));
        Assert.assertEquals("Decorating Concrete Wall House", processesExecutedForConcreate.get(6));
        

        house = new GlassWallHouse();
        List<String> processesExecutedForGlass = house.buildhouse();
        
        Assert.assertTrue(CollectionUtils.isNotEmpty(processesExecutedForGlass));
        Assert.assertEquals(7, processesExecutedForGlass.size());
        Assert.assertEquals("Base has been constructed.", processesExecutedForGlass.get(0));
        Assert.assertEquals("Roof has been constructed.", processesExecutedForGlass.get(1));
        Assert.assertEquals("Constructing Glass Wall for my House", processesExecutedForGlass.get(2));
        Assert.assertEquals("Constructing Windows for Glass Wall House", processesExecutedForGlass.get(3));
        Assert.assertEquals("Constructing Doors for Glass Wall House", processesExecutedForGlass.get(4));
        Assert.assertEquals("Painting Glass Wall House", processesExecutedForGlass.get(5));
        Assert.assertEquals("Decorating Glass Wall House", processesExecutedForGlass.get(6));
	}

}
