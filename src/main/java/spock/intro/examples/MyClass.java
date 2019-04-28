package spock.intro.examples;

public class MyClass {
	public static int max(int a, int b) {
		return Math.max(a, b);
	}
	
	public String getDependencyValue() {
		return dependency.getValue();
	}
	private String message;
	private int count;
	
	private ADependency dependency;
	
}
