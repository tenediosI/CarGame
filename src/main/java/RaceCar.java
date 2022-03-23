
public class RaceCar implements Observer {
	
	private int metersTravelled = 0;
	private String manufacturer;
	private String carName;
	private RaceWeather raceWeather;
	private WeatherType weather;
	private DrivingBehavior drivingBehavior;

	
	public RaceCar(String manufacturer, String carName, RaceWeather raceWeather, DrivingBehavior drivingBehavior) 
	{
		this.raceWeather = raceWeather;
		this.manufacturer = manufacturer;
		this.carName = carName;
		this.drivingBehavior = drivingBehavior;
		raceWeather.registerObserver(this);
		
	}

	public void driveCar()
	{
		metersTravelled += drivingBehavior.driveCar();
	}
	
	public void changeDrivingBehaviour(DrivingBehavior drivingBehavior)
	{
		this.drivingBehavior = drivingBehavior;
	}

	
	public String getStatus()
	{
		return carName + " built by " + manufacturer + " has travelled " + metersTravelled +" meters";
	}

	@Override
	public void update(WeatherType weather) {
		this.weather = weather;
		
	}
	public int getMetersTravelled(){
		return metersTravelled;
	}
	public String getNameAndMake() {
		return carName + ", " + manufacturer;
	}
	
	

}
