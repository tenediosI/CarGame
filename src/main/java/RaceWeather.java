public class RaceWeather
{
	private WeatherType weather;
	
	public RaceWeather(WeatherType weather)
	{
		this.weather = weather;
	}
	

	public void changeWeather()
	{
		weather = weather.next();
	}
	
	
	public WeatherType getWeather()
	{
		return weather;
	}
}
