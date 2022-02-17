package com.store.error;

public enum ProductServiceErrorCode {

	INVALID_NAME("invalid Data passed"),
	INVALID_DATA("invlid data");	
	
	public final String label;
	
	private ProductServiceErrorCode(String label) {
		this.label = label;
	}
}
