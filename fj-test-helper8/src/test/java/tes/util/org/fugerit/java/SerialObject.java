package tes.util.org.fugerit.java;

import java.io.Serializable;

public class SerialObject implements Serializable {

	private static final long serialVersionUID = -616598362961164L;

	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "SerialObj [field=" + this.getField() + "]";
	}
	
}
