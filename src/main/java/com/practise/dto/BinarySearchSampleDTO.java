package com.practise.dto;

public class BinarySearchSampleDTO implements Comparable<BinarySearchSampleDTO> {

	String empFirstName;
	String emplastName;
	int id;

	public int compareTo(BinarySearchSampleDTO a) {
		return this.empFirstName.compareTo(a.empFirstName);
	}

	public BinarySearchSampleDTO(String empFirstName, String emplastName, int id) {
		this.empFirstName = empFirstName;
		this.emplastName = emplastName;
		this.id = id;
	}

	/**
	 * @return the empFirstName
	 */
	public String getEmpFirstName() {
		return empFirstName;
	}

	/**
	 * @param empFirstName
	 *            the empFirstName to set
	 */
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	/**
	 * @return the emplastName
	 */
	public String getEmplastName() {
		return emplastName;
	}

	/**
	 * @param emplastName
	 *            the emplastName to set
	 */
	public void setEmplastName(String emplastName) {
		this.emplastName = emplastName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
