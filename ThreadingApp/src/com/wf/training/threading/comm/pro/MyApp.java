package com.wf.training.threading.comm.pro;


class Box{
	private int count;
	public Box() {
		this.count = 0;
	}
	
	synchronized public void put() {
		if(this.count > 0) {
			// already a product in box
			// wait till we get a call from Consumer
			try {
				// wait();
				wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(this.count > 0) {}
		// put the product
		this.count++;
		System.out.println("Produced : " + this.count);
		// give a call back to Consumer
		notify();
	}
	synchronized public void get() {
		if(count == 0) {
			// no product in box
			// wait till we get a call from Producer
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		// get the product
		this.count--;
		System.out.println("Consumed : " + this.count);
		// give a call back to Producer
		notify();
	}
}

class Producer extends Thread{
	Box box;
	
	public Producer(Box box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		while(true) {
			// produce a product
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// put the product in box
			this.box.put();
		}
	}
}

class Consumer extends Thread{
	Box box;
	
	public Consumer(Box box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		while(true) {
			// get the product in box
			this.box.get();
			
			// consuming a product
			try {
				Thread.sleep(120);
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
		Box box = new Box();
		
		Producer producer = new Producer(box);
		Consumer consumer = new Consumer(box);
		
		producer.start();
		consumer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Testing Done...");
	}

}
