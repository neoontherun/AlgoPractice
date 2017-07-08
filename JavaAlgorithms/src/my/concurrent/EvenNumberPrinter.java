package my.concurrent;

import java.util.concurrent.Semaphore;

public class EvenNumberPrinter implements Runnable {

	int i = 2;
	
	Semaphore permit;
	
	public EvenNumberPrinter(Semaphore permit) {
		this.permit = permit;
	}

	@Override
	public void run() {
		while (i < 100) {
			try {
				permit.acquire();
				System.out.println(i);
				i += 2;
				permit.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}