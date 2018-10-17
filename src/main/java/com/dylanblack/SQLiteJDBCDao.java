package com.dylanblack;
/*
This class will handle all interaction with the database, so it can avoid bogging down main
(com.dylanblack.TrainData). It's main purpose is to connect to the interface, and then query it for the station
names.
 */

import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Repository
@Transactional
public class SQLiteJDBCDao implements MetrolinkDao
{
    //private static Logger log = Logger.getLogger(SQLiteJDBCDao.class.toString());

    @Autowired
    private SessionFactory sessionFactoryBean;

    //Outputs a list of all unique stops from our database.
    public List<String> getAllUniqueStops()
    {
      //Gets our sessionFactory bean.
      ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
      sessionFactoryBean = (SessionFactory) appContext.getBean("sessionFactory");
      sessionFactoryBean.getCurrentSession().beginTransaction();
      //Creates our criteria from our Stop class.
      Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Stop.class);
      //ProjectionList grabs our 'stop_name' column:
      ProjectionList projList = Projections.projectionList();
      projList.add(Projections.property("stop_name"));
      criteria.setProjection(projList);
      //...gets distinct results:
      criteria.setProjection(Projections.distinct(Projections.property("stop_name")));
      //...and then orders it alphabetically (ascending):
      criteria.addOrder(Order.asc("stop_name"));
      List <String>output = criteria.list();
      sessionFactoryBean.getCurrentSession().getTransaction().commit();
      return output;
    }

    //Outputs the next time of a given metrolink station.
    public String getNextTimeOfStop(String stopName) {
      //Gets our sessionFactory bean.
      ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
      sessionFactoryBean = (SessionFactory) appContext.getBean("sessionFactory");
      sessionFactoryBean.getCurrentSession().beginTransaction();
      //Creates our criteria from our Stop class.
      Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(Stop.class);
      //Narrow our results to only the stop we want to check:
      criteria.add(Restrictions.eq("stop_name", stopName));
      //Projectionlist grabs our 'arrival_time' column:
      ProjectionList projList = Projections.projectionList();
      projList.add(Projections.property("arrival_time"));
      criteria.setProjection(projList);
      //Create a comparison String of our current time. (HH:MM:00)
      String timeCheck = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":00";
      //Check for times greater or = to current time.
      criteria.add(Restrictions.ge("arrival_time", timeCheck));
      //order it alphabetically (ascending):
      criteria.addOrder(Order.asc("arrival_time"));
      //limit ourselves to the next result after sorting (next time, or matching current time):
      criteria.setMaxResults(1);
      criteria.uniqueResult();
      String output = criteria.list().get(0).toString();
      sessionFactoryBean.getCurrentSession().getTransaction().commit();
      return output;
    }
}
