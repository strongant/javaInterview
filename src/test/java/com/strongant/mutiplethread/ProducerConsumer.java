package com.strongant.mutiplethread;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ProducerConsumer {
	public static void main(String args[]) {
		Vector sharedQueue = new Vector();
		int size = 4;
		Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
		Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
		prodThread.start();
		consThread.start();
	}
}

class Producer implements Runnable {

	private final Vector sharedQueue;
	private final int SIZE;

	public Producer(Vector sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() {
		synchronized(sharedQueue) {
			for (int i = 0; i < 7; i++) {
				try {
					//wait if queue is full
					while (sharedQueue.size() == SIZE) {
						System.out.println("Queue is full, producer is waiting...");
						sharedQueue.wait();
					}

					System.out.println("Produced: " + i);
					//producing element and notify consumers
					sharedQueue.add(i);
					sharedQueue.notifyAll();
				} catch (InterruptedException ex) {
					Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

}

class Consumer implements Runnable {

	private final Vector sharedQueue;
	private final int SIZE;

	public Consumer(Vector sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() {
		while (true) {
			synchronized(sharedQueue) {
				try {
					while (sharedQueue.isEmpty()) {
						System.out.println("queue is empty, consume waiting...");
						sharedQueue.wait();
					}

					Integer i = (Integer) sharedQueue.remove(0);
					System.out.println("consumer get: " + i);

					sharedQueue.notifyAll();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}