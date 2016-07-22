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
 *  Project Name    : web
 * 
 *  Package Name    : com.leo.multi.thread
 * 
 *  File Name       : CallableDemo.java
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
public class CallableDemo {
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0;i<10;i++){
			results.add( exec.submit(new TaskWithResult(i)));
		}
		for (Future<String> rs : results){
			try {
				System.out.println(rs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				exec.shutdown();
			}
		}
	}
}
class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id ){
		this.id = id;
	}
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Result of TaskWithResult:"+id;
	}
	
}
