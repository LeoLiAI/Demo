/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with AsiaInspection. This 
 * information shall not be distributed or copied without written 
 * permission from the AsiaInspection.
 *
 ***************************************************************************/

package com.leo.rpc;

import java.lang.reflect.Method;

/***************************************************************************
 *<PRE>
 *  Project Name    : web
 * 
 *  Package Name    : com.leo.rpc
 * 
 *  File Name       : RPCProxyClient.java
 * 
 *  Creation Date   : 2016年7月6日
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
public class RPCProxyClient implements java.lang.reflect.InvocationHandler{
    private Object obj;
    public RPCProxyClient(Object obj){
        this.obj=obj;
    }
    /**
     * 得到被代理对象;
     */
    public static Object getProxy(Object obj){
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new RPCProxyClient(obj));
    }

    /**
     * 调用此方法执行
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //结果参数;
        Object result = new Object();
        // ...执行通信相关逻辑
        // ...
        return result;
    }
}