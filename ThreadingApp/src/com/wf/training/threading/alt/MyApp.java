package com.wf.training.threading.alt;

// class MThread extends XYZ,Thread{
class MThread implements Runnable{
	Thread t;
	
	public MThread() {
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		for(int i=1;i<=30;i++){
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
		thread.t.start();
		
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
