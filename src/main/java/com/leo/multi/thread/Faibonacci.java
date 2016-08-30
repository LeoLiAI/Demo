/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with AsiaInspection. This 
 * information shall not be distributed or copied without written 
 * permission from the AsiaInspection.
 *
 ***************************************************************************/

package com.leo.multi.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/***************************************************************************
 *<PRE>
 *  Project Name    : Demo
 * 
 *  Package Name    : com.leo.multi.thread
 * 
 *  File Name       : Faibonacci.java
 * 
 *  Creation Date   : 2016年7月22日
 * 
 *  Author          : Leo
 * 
 *  Purpose         : TODO
 * 
 * 
 *  History         : TODO
 * 
 *</PRE>
 ***************************************************************************/
public class Faibonacci {
	public static void main(String[] args){
		FaibonacciT ft = new FaibonacciT(18);
		
//		 new Thread(new FaibonacciT(18)).start();
//		 new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
//		new Thread(new FaibonacciT(18)).start();
		
//		Thread t1 = new Thread(new FaibonacciT(18));
//		Thread t2 = new Thread(new FaibonacciT(18));
//		Thread t3 = new Thread(new FaibonacciT(18));
//		Thread t4 = new Thread(new FaibonacciT(18));
//		Thread t5 = new Thread(new FaibonacciT(18));
//		Thread t6 = new Thread(new FaibonacciT(18));
//		Thread t7 = new Thread(new FaibonacciT(18));
//		Thread t8 = new Thread(new FaibonacciT(18));
//		Thread t9 = new Thread(new FaibonacciT(18));
//		Thread t0 = new Thread(new FaibonacciT(18));
//		
		ExecutorService es = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> fs = new ArrayList<Future<Integer>>();
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));fs.add(es.submit(new FaibonacciT(18)));
		fs.add(es.submit(new FaibonacciT(18)));
		for (Future<Integer> f:fs){
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		es.shutdown();
//		t0.start();
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
//		t8.start();
//		t9.start();
		
	}
}

class FaibonacciT implements Callable{
	private int i ;
	public FaibonacciT(int i ){
		this.i=i;
	}
	
	@Override
	public Object call() throws Exception {
		int re = 0;
		int[] arrInt = new int[i];
		if(i>2){
			arrInt[0]=0;
			arrInt[1]=1;
			for(int j=2;j<arrInt.length;j++){
				arrInt[j]=arrInt[j-1]+arrInt[j-2];
			}
		}
		
		for(int j=0;j<arrInt.length;j++){
			re=re+arrInt[j];
		}
		
		return re;
	}
	
}

