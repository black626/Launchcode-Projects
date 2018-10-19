package com.dylanblack;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="metrolink_stops")
public class Stop
{
  //Set up information about our stop through Hibernate:
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "trip_headsign")
  private String trip_headsign;
  @Column(name = "stop_name")
  private String stop_name;
  @Column(name = "route_color")
  private int route_color;
  @Column(name = "route type")
  private int route_type;
  @Column(name = "stop_sequence")
  private int stop_sequence;
  @Column(name = "arrival_time")
  private String arrival_time;
  @Column(name = "departure_time")
  private String departure_time;
  @Column(name = "service_id")
  private String service_id;
}
