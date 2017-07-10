package my.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	static CountDownLatch latch;

	static class Worker implements Runnable {
		CountDownLatch startLatch;
		
		String data;

		public Worker(CountDownLatch startLatch, String data) {
			this.startLatch = startLatch;
			this.data = data;
		}

		public void run() {
			try {
				startLatch.await();
				System.out.println("Printing Data : " + data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		latch = new CountDownLatch(1);
		Worker worker1 = new Worker(latch, "A");
		Worker worker2 = new Worker(latch, "B");
		Worker worker3 = new Worker(latch, "C");
		Thread t1 = new Thread(worker1);
		Thread t2 = new Thread(worker2);
		Thread t3 = new Thread(worker3);
		System.out.println("Starting the threads...");
		t1.start();
		t2.start();
		t3.start();
		try {
			System.out.println("Sleeping");
			Thread.sleep(2000);
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		System.out.println("Letting the gates open");
		latch.countDown();
	}

}
