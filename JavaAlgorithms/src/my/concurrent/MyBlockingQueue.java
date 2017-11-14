package my.concurrent;

import java.util.ArrayList;
import java.util.List;

public class MyBlockingQueue {

	Integer MAX_SIZE = 3;

	List<String> queue = new ArrayList<String>(MAX_SIZE);

	public void put(String element) throws InterruptedException {
		synchronized (queue) {
			if (queue.size() >= MAX_SIZE) {
				queue.wait();
			}
			queue.add(element);
			// System.out.println("Queue Size : " + queue.size());
			queue.notifyAll();
		}
	}

	public String get() throws InterruptedException {
		String returnObj;
		synchronized (queue) {
			if (queue.size() == 0) {
				queue.wait();
			}
			returnObj = queue.remove(0);
			// System.out.println("Queue Size : " + queue.size());
			queue.notifyAll();
		}
		return returnObj;
	}

	public synchronized int size() {
		return queue.size();
	}

	public static void main(String[] args) {
		MyBlockingQueue queue = new MyBlockingQueue();

		Thread producer = new Thread(new Runnable() {
			Integer counter = 0;

			@Override
			public void run() {
				try {
					while (true) {
//						System.out.println("Putting : " + ++counter);
						queue.put(counter.toString());
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("Queue Size : " + queue.size());
						String res = queue.get();
//						System.out.println("Getting : " + res);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		producer.start();
		consumer.start();
	}

}