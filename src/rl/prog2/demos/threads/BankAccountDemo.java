package rl.prog2.demos.threads;

/**
 * Demonstrates synchronization problems, such as lost updates and deadlocks.
 * Don't forget to kill the application, because it will never terminate!
 * 
 * @author Ruediger Lunde
 */
public class BankAccountDemo {

	public static void main(String[] args) {
		//startIncrementDemo();
		startDeadlockDemo();
	}
	
	static class BankAccount {
		int balance;

		synchronized void increment() {
			int tmp = balance;
			Thread.yield(); // inserted for demonstration purposes
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance = tmp + 1;
		}

		/*synchronized*/ void transferMoney(BankAccount destination, int amount) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (destination) {
				destination.balance += amount;
				balance -= amount;
			}
		}
	}

	static class IncJob implements Runnable {

		BankAccount account;

		IncJob(BankAccount account) {
			this.account = account;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++)
				account.increment();
			System.out.println("Job finished. Account balance: "
					+ account.balance);
		}
	}

	static void startIncrementDemo() {
		BankAccount account = new BankAccount();
		Thread t1 = new Thread(new IncJob(account));
		Thread t2 = new Thread(new IncJob(account));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final account balance: " + account.balance);
		// the result will sometimes be less than 200!
	}

	static class TransferJob implements Runnable {
		BankAccount accountFrom;
		BankAccount accountTo;

		TransferJob(BankAccount from, BankAccount to) {
			accountFrom = from;
			accountTo = to;
		}

		@Override
		public void run() {
			accountFrom.transferMoney(accountTo, 10);
			System.out.println("Job finished.");
		}
	}

	static void startDeadlockDemo() {
		BankAccount accountA = new BankAccount();
		BankAccount accountB = new BankAccount();
		Thread t1 = new Thread(new TransferJob(accountA, accountB));
		Thread t2 = new Thread(new TransferJob(accountB, accountA));
		t1.start();
		t2.start();
		// Both treads will never finish, no "Job finished."-output expected...
	}
}
