package ch06;

public class Ex05_Initialize {
	
	static{
		System.out.println("1. static initialize");
	}
	
	{
		System.out.println("3. instance initialize");
	}
	
	public Ex05_Initialize(){
		System.out.println("4. constructor initialize");
	}
	
	public static void main(String[] args) {
		System.out.println("2. main method");
		new Ex05_Initialize();
	}

}
