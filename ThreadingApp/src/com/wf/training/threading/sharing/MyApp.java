package com.wf.training.threading.sharing;

// Thread Safe
class Resource{
	private int arr[];
	
	public void fun() {
		// this.arr
		//-------------------------
		//------------------------
		// granular locking
		synchronized(this) {
			//------------------------c-Thread Safe
			//------------------------c-Thread Safe
		}
		//------------------------
		//------------------------
	}
	
	synchronized public void changeArray() {
		this.arr = new int[100];
	}
	
	// lock the method, so that it shall not be called simul...
	public void manageArray(String name, int size, int init) {
	//synchronized public void manageArray(String name, int size, int init) {	
		// allot the size
		this.arr = new int[size];
		
		// initialize the array
		for(int i=0;i<size;i++)
			this.arr[i] = init + i;
		
		// display array content
		for(int i=0;i<arr.length;i++) {
			System.out.println(name + " : " + arr[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class MThread extends Thread{
	Resource resource;
	String name;
	int size;
	int init;
	
	public MThread(Resource resource, String name, int size, int init) {
		this.resource = resource;
		this.name = name;
		this.size = size;
		this.init = init;
	}
	
	@Override
	public void run() {
		synchronized(this.resource) {
			this.resource.manageArray(name, size, init);
			// ----------------------
			// ----------------------
		}
	}
	
}

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource resource = new Resource();
		
		MThread thread1 = new MThread(resource, "First", 10, 100);
		MThread thread2 = new MThread(resource, "Second", 15, 500);
		
		thread1.start();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();
	}

}











