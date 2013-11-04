package com.thinksoft.polapp;

public class SampleDataClientes {
	
	private String name;
	private String apellido;
	 
	private boolean selected;
 
	public SampleDataClientes(String name, String apellido, boolean selected) {
		super();
		this.name = name;
		this.selected = selected;
		this.apellido =apellido;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getApellido() {
		return apellido;
	}
 
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
 
	public boolean isSelected() {
		return selected;
	}
 
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
