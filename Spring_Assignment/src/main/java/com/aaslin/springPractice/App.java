package com.aaslin.springPractice;
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
        System.out.println(" XML CONFIGURATION ");
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        College college=context.getBean("college",College.class);
        college.showCollege();
    }
}
