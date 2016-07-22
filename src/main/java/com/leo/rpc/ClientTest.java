/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with AsiaInspection. This 
 * information shall not be distributed or copied without written 
 * permission from the AsiaInspection.
 *
 ***************************************************************************/

package com.leo.rpc;

import com.leo.rpc.service.HelloWorldService;

/***************************************************************************
 *<PRE>
 *  Project Name    : web
 * 
 *  Package Name    : com.leo.rpc
 * 
 *  File Name       : ClientTest.java
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
public class ClientTest {
    public static void main(String[] args) {
        HelloWorldService helloWorldService = (HelloWorldService)RPCProxyClient.getProxy(HelloWorldService.class);
        helloWorldService.sayHello("test");
    }
}
