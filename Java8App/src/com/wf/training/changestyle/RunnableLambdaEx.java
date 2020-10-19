package com.wf.training.changestyle;

public class RunnableLambdaEx {

	public static void main(String args[]) {
		Runnable runLambda = () ->{
				// Thread activity 
		};
		
		new Thread(runLambda).start();
	}
}
