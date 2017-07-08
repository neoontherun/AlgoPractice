package my.puzzles;

public class Power {

	public static void main(String[] args) {
		System.out.println(pow(1, 0));
		System.out.println(pow(-1, 0));
		System.out.println(pow(-1, -1));
		System.out.println(pow(0, -1));
		System.out.println(pow(100, 1));
		System.out.println(pow(100, -1));
		System.out.println(pow(2, -3));
	}

	static double pow(double base, int power) {
		if (power == 0) {
			return 1;
		}
		if (power < 0) {
			return 1/(base * pow(base, -power));
		}
		return base * pow(base, --power);
	}
}
