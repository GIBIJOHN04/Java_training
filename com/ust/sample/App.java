package com.ust.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
     {
    	ApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");

    	SIM e=(SIM) contex.getBean("airtel");

    	e.calling();

    	e.data();
        
    }
}
