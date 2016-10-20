package com.annotation;

class TryingAnnotations {
	private String name;

	public TryingAnnotations(String name) {
		super();
		this.name = name;
	}

	@Deprecated
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}

public class AnnotationMain {

	public static void main(String[] args) {
		TryingAnnotations annotations = new TryingAnnotations("Annotation"); 
		System.out.println("Using deprecated method = " + annotations.getName());
		System.out.println("Using override method" + annotations);
	}

}
