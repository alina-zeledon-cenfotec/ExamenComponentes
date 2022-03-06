package main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import bean.WriterBeanWithDependency;

public class Main {

    public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");
    BeanFactory factory = context;
    WriterBeanWithDependency test = (WriterBeanWithDependency) factory
            .getBean("WriterBeanWithDependency");
        test.menu();
    }
}

