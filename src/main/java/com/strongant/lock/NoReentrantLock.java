package com.strongant.lock;


import sun.misc.Lock;

/**
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class NoReentrantLock {

	public static void main(String[] args) throws InterruptedException {
		//Count count = new Count();
		//count.print();

		// 重入锁
		ReentrantLock reentrantLock = new ReentrantLock();
		reentrantLock.lock();
		System.out.println(reentrantLock.isLocked);
		reentrantLock.lock();
		System.out.println(reentrantLock.lockedCount);
	}
}

/**
 * 不可重入锁(也叫做自旋锁)
 * 当调用print()方法时，获得了锁，这时就无法再调用doAdd()方法，
 * 这时必须先释放锁才能调用，所以称这种锁为不可重入锁，也叫自旋锁。
 */
class Count{
	Lock lock = new Lock();
	public void print() throws InterruptedException {
		lock.lock();
		doAdd();
		lock.unlock();
	}
	public void doAdd() throws InterruptedException {
		lock.lock();
		lock.unlock();
	}
}

class ReentrantLock{
	boolean isLocked = false;
	Thread  lockedBy = null;
	int lockedCount = 0;
	public synchronized void lock()
			throws InterruptedException{
		Thread thread = Thread.currentThread();
		while(isLocked && lockedBy != thread){
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = thread;
	}
	public synchronized void unlock(){
		if(Thread.currentThread() == this.lockedBy){
			lockedCount--;
			if(lockedCount == 0){
				isLocked = false;
				notify();
			}
		}
	}
}
