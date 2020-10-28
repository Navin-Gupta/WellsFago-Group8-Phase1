package com.wf.training.threading.intro;

class MThread extends Thread{
	@Override
	public void run() {
		for(int i = 1;i<=1000;i++) {
			System.out.println("Thread :" + i);
		}
	}
}

public class MyApp {

	public static void main(String[] args) {
		
		MThread thread = new MThread();
		thread.start(); // spawns the thread
		
		for(int i = 1;i<=1000;i++) {
			System.out.println("Main :" + i);
		}
	}

}
