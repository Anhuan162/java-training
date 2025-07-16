package org.user;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.user.annotation_based_configuration.AppConfig;
import org.user.annotation_based_configuration.Student;

public class AnnoDemo {
    public static void main(String[] args) {
        // Load the Spring application context
        // using annotation-based configuration
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Student bean
        Student student = context.getBean(Student.class);

        // Call the cheating() method
        student.cheating();
    }
}
