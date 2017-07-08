package my.concurrent;

import java.util.concurrent.Semaphore;

public class OddNumberPrinter implements Runnable {

	int i = 1;

	Semaphore permit;

	public OddNumberPrinter(Semaphore permit) {
		this.permit = permit;
	}

	@Override
	public void run() {
		while (i < 100) {
			try {
				permit.acquire();
				System.out.println(i);
				i+=2;
				permit.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}