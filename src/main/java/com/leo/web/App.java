package com.leo.web;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       int hash = "Leo".hashCode();
       int n = 20;
       int i = (n - 1) & hash;
       System.out.print(i);
    }
}
