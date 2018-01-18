package com.mitrais.rms.model;

public class Employee {
	private Long id;
	private String name;
	private String position;
	private String office;
	/**
	 * @param id
	 * @param name
	 * @param position
	 * @param office
	 */
	public Employee(Long id, String name, String position, String office) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.office = office;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}
	/**
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	
}
