package com.practise.patterns.builder;

public class SimpleBuilderPattern {
	
	// Mandatory parameters
	private final String name;
	private final String className;
	
	// Non-mandatory parameters
	private final int age;
	private final int height;
	private final int rollNum;
	private final String gender;
	private final String section;
	private final String bloodGroup;
	
	
	private SimpleBuilderPattern(Builder builder) {
		name = builder.name;
		className = builder.className;
		
		age = builder.age;
		height = builder.height;
		gender = builder.gender;
		section = builder.section;
		rollNum = builder.rollNum;
		bloodGroup = builder.bloodGroup;
	}
	
	
	public static class Builder{
		// Mandatory parameters
		private String name;
		private String className;
		
		// Non-mandatory parameters
		private int age;
		private int height;
		private int rollNum;
		private String gender;
		private String section;
		private String bloodGroup;
		
		public Builder(String name, String className) {
			this.name = name;
			this.className = className;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder rollNum(int rollNum) {
			this.rollNum = rollNum;
			return this;
		}
		
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		
		public Builder gender(String gender) {
			this.gender = gender;
			return this;
		}
		
		public Builder section(String section) {
			this.section = section;
			return this;
		}
		
		public Builder bloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
			return this;
		}
		
		public SimpleBuilderPattern build() {
			return new SimpleBuilderPattern(this);
		}
	}
	
	
	// Getters to get the object
	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getRollNum() {
		return rollNum;
	}

	public String getGender() {
		return gender;
	}

	public String getSection() {
		return section;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

}
