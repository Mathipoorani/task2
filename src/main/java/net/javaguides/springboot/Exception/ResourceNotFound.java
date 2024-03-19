package net.javaguides.springboot.Exception;

public class ResourceNotFound extends RuntimeException{

	public String resourceName;
	public String fieldName;
	public Object fieldValue;
	
	public ResourceNotFound(String resourceName, String fieldName) {
		super(String.format(resourceName, fieldName));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	
	
}
