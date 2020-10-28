package com.wf.training.threading.daemon;

class MThread extends Thread{
	@Override
	public void run() {
		int i = 1;
		while(true) {
			System.out.println("Thread :" + i++);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MThread thread = new MThread();
		// set daemon
		thread.setDaemon(true);
		thread.start();
		
		for(int i=1;i<=10;i++) {
			System.out.println("Main : " + i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("Main Terminated");
	}

}
