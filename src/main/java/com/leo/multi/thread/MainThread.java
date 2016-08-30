/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with AsiaInspection. This 
 * information shall not be distributed or copied without written 
 * permission from the AsiaInspection.
 *
 ***************************************************************************/

package com.leo.multi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/***************************************************************************
 *<PRE>
 *  Project Name    : web
 * 
 *  Package Name    : com.leo.multi.thread
 * 
 *  File Name       : MainThread.java
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
public class MainThread {
	public static void main(String[] args){
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
//			Thread thread = new Thread(new MsgPrint());
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}

class MsgPrint implements Runnable{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public MsgPrint(){
		System.out.println(Thread.currentThread().getName()+":start");
	}
	
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"LiftOff")+")";
	}
	public void run() {
		for (int i = 0;i<3;i++){
			System.out.println("正在输出消息:"+i);
			
		}
		System.out.println(Thread.currentThread().getName()+":end");
	}
	
}

class LiftOff implements Runnable{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff(){
		
	}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"LiftOff")+")";
	}
	public void run() {
		while(countDown-- >0){
			System.out.println(status());
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				Thread.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}