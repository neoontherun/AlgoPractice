package my.concurrent;

import java.util.concurrent.Semaphore;

public class SequenceNumberPrinter {

	public static void main(String[] args) {
		Semaphore permit = new Semaphore(1, true);
		Thread evenThread = new Thread(new EvenNumberPrinter(permit));
		Thread oddThread = new Thread(new OddNumberPrinter(permit));
		oddThread.start();
		evenThread.start();
	}
}
