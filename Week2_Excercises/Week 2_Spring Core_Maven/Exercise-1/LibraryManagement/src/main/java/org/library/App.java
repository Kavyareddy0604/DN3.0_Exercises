package org.library;

import org.library.services.BookServices;
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
         ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
         BookServices obj=context.getBean(BookServices.class);
    }
}
