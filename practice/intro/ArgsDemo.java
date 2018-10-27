public class ArgsDemo {
	public static void main(String[] args) {
		int sumArgs = 0;
		for (int i = 0; i < args.size(); i ++) {
			sumArgs = sumArgs + Integer.parseInt(args[i]);
		}
		System.out.println(sumArgs);
	}
}