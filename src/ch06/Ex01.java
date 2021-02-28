package ch06;

class Fruit{
	
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public static Fruit createFruit(String name) {
		Fruit fruit = new Fruit();
		fruit.name = name;
		return fruit;
	}
}

class Ex01 {

	public static void main(String[] args) {
		Fruit fruit = Fruit.createFruit("Pineapple");
		System.out.println(fruit.getName());
	}

}
