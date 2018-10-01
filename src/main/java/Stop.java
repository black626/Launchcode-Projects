public class Stop
{
  //Stops need to have a name, and stop description for the object.
  private String stop_name;
  private String stopArrival_Time;

  //Basic, plain constructor.
  public Stop(){}

  //setter method for our stop_name.
  public void setStop_name(String input)
  {
    stop_name = input;
  }

  //setter method for our stop_description.
  public void setStopArrival_Time(String input){stopArrival_Time = input;}

  //getter method for our stop_name.
  public String getStop_name()
  {
    return stop_name;
  }

  //getter method for our stop_description.
  public String getStopArrival_Time(){ return stopArrival_Time;}
}
