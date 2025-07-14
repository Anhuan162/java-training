package org.user;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.user.spring_beans_factory_demo.Student;
@SpringBootApplication
public class DemoApplication
{
    public static void main(String[] args)
    {
        BeanFactory factory = new ClassPathXmlApplicationContext("bean-factory-demo.xml");
        Student student = (Student) factory.getBean("student");

        System.out.println(student);
    }
}
