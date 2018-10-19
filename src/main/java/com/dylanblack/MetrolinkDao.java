package com.dylanblack;/*
com.dylanblack.MetrolinkDao interface is designed to handle instantiation and modification of our com.dylanblack.SQLiteJDBCDao
class.
 */

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Component
public interface MetrolinkDao
{
    ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context" +
      ".xml");
    SessionFactory sessionFactoryBean = (SessionFactory) appContext.getBean("sessionFactory");

    List<String> getAllUniqueStops();
    String getNextTimeOfStop(String stopName);
}
