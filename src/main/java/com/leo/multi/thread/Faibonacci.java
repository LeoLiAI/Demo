/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with AsiaInspection. This 
 * information shall not be distributed or copied without written 
 * permission from the AsiaInspection.
 *
 ***************************************************************************/

package com.leo.multi.thread;

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
		
		Thread t1 = new Thread(ft);
		Thread t2 = new Thread(ft);
		Thread t3 = new Thread(ft);
		Thread t4 = new Thread(ft);
		Thread t5 = new Thread(ft);
		Thread t6 = new Thread(ft);
		Thread t7 = new Thread(ft);
		Thread t8 = new Thread(ft);
		Thread t9 = new Thread(ft);
		Thread t0 = new Thread(ft);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
	}
}

class FaibonacciT implements Runnable{
	private int i ;
	public FaibonacciT(int i ){
		this.i=i;
	}
	@Override
	public void run() {
		int[] arrInt = new int[i];
		if(i>2){
			arrInt[0]=0;
			arrInt[1]=1;
			for(int j=2;j<arrInt.length;j++){
				arrInt[j]=arrInt[j-1]+arrInt[j-2];
			}
		}
		
		for(int j=0;j<arrInt.length;j++){
			System.out.println(Thread.currentThread().getName()+":"+arrInt[j]);
		}
	}
	
}

