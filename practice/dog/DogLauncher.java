public class DogLauncher {
	public static void main(String[] args) {
		Dog dogo = new Dog(20);
		Dog barko = new Dog(43);
		Dog bigDog = Dog.maxDog(dogo, barko);
		bigDog.makeNoise();

	}
}