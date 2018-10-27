public class Dog {
	/**constructor function below
	  return and return type are not specified for constructor -- it not necessary and program
	  will fail */
	public int weightInPounds;
	public static String binomen = "Canis familiaris";
	
	public Dog(int w) {
		weightInPounds = w;
	}
	public static Dog maxDog(Dog d1, Dog d2) {
		if (d1.weightInPounds > d2.weightInPounds) {
			return d1;
		}
		return d2;
	}

	public void makeNoise() {
		if (weightInPounds < 10) {
			System.out.println("yipyipyipyip");
		} else if (weightInPounds < 30 && weightInPounds >= 10) {
			System.out.println("Bark, Bark");
		} else {
			System.out.println("woof!");
		}
	}
}