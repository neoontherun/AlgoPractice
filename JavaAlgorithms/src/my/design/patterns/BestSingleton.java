package my.design.patterns;

public class BestSingleton {

	private BestSingleton() {
	}

	private static class SingletonHelper {
		private static final BestSingleton INSTANCE = new BestSingleton();
	}

	public static BestSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}