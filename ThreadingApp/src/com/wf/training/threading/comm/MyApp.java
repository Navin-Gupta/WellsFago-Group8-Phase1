package com.wf.training.threading.comm;


class Box{
	private int count;
	public Box() {
		this.count = 0;
	}
	
	public void put() {
		this.count++;
		System.out.println("Produced : " + this.count);
	}
	public void get() {
		this.count--;
		System.out.println("Consumed : " + this.count);
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
