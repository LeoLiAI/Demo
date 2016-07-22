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
 *  Project Name    : web
 * 
 *  Package Name    : com.leo.multi.thread
 * 
 *  File Name       : LeoTest.java
 * 
 *  Creation Date   : 2016年7月18日
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
public class LeoTest {
	
	public static void main(String[] args){
		NumberCount numberCount = new NumberCount();
		OddThread odd = new OddThread(numberCount);
//		Thread thread_1 = new Thread(odd,"thread_1");
		Thread thread_2 = new Thread(odd,"thread_2");
		Thread thread_3 = new Thread(new EvenThread(numberCount),"thread_3");
		Thread thread_4 = new Thread(new EvenThread(numberCount),"thread_4");
//		thread_1.start();
		thread_2.start();
		thread_3.start();
//		thread_4.start();
		
	}

}
class OddThread implements Runnable{
	private NumberCount numberCount;
	public OddThread(NumberCount numberCount){
		this.numberCount=numberCount;
	}
	public void run() {
		for(int i=0;i<5;i++){
		numberCount.oddOut();
		}
	}
	
}

class EvenThread implements Runnable{
	private NumberCount numberCount;
	public EvenThread(NumberCount numberCount){
		this.numberCount=numberCount;
	}
	public void run() {
		for(int i=0;i<5;i++){
		numberCount.evenOut();
		}
	}
	
}
class NumberCount{
	int i=0;
	public void oddOut(){
		synchronized(this){
			if(i%2!=0&& i<11){
				System.out.println(Thread.currentThread().getName()+":"+i);
				i++;
				this.notifyAll();
			}else{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void evenOut(){
		synchronized(this){
			if(i%2==0&& i<11){
				System.out.println(Thread.currentThread().getName()+":"+i);
				i++;
				this.notifyAll();
			}else{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
