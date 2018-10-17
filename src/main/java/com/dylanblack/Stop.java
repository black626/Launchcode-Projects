package com.dylanblack;

import javax.persistence.*;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="metrolink_stops")
public class Stop
{
  //Set up information about our stop through Hibernate:
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "stop_name")
  private String stop_name;
  @Column(name = "arrival_time")
  private String arrival_time;

  public Stop() { }

  @Setter
  public void setStop_name(String stop_name) {
    this.stop_name = stop_name;
  }

  @Setter
  public void setArrival_time(String arrival_time) {
    this.arrival_time = arrival_time;
  }

  @Getter
  public String getStop_name() {
    return stop_name;
  }

  @Getter
  public String getArrival_time() {
    return arrival_time;
  }
}
