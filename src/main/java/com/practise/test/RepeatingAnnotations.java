package com.practise.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;

public class RepeatingAnnotations {
	
	@Target( ElementType.TYPE )
	@Retention( RetentionPolicy.RUNTIME )
	private @interface Filters {
	Filter[] value();
	}
	
	@Target( ElementType.TYPE )
	@Retention( RetentionPolicy.RUNTIME )
	@Repeatable( Filters.class )
	private @interface Filter {
	String value();
	};
		
	@Filter( "filter1" )
	@Filter( "filter2" )
	public interface Filterable {
	}
	
	public static void main(String[] args) {
	for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
	System.out.println( filter.value() );
	}
	}
	}

 interface ss
{
	
}

