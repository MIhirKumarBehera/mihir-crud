package com.hutech.loginproject.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String resourceName, String resourceField, long fieldValue) {
		super(String.format("%s notFound with %s: %s", resourceName,resourceField,fieldValue));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.fieldValue = fieldValue;
	}
	private String resourceName;
	private String resourceField;
	private long fieldValue;

}
