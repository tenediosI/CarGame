
public class CautiousDriving implements DrivingBehavior
    {
	private RaceWeather raceWeather;
	private WeatherType weather;
	public CautiousDriving(RaceWeather raceWeather) {
		this.raceWeather = raceWeather;
	}
	public int driveCar() {
		weather = raceWeather.getWeather();
		if (weather == WeatherType.DRY) {
			return 10;
		}
		else if (weather == WeatherType.MISTY){
			return 10;
		}
		else {
			return 10;
		}
	}

}
