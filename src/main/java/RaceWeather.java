import java.util.ArrayList;
import java.util.List;

public class RaceWeather implements Subject
{
	private List<Observer> observers;
	private WeatherType weather;
	
	public RaceWeather(WeatherType weather)
	{
		this.weather = weather;
		observers = new ArrayList<Observer>();
	}
	

	public void changeWeather()
	{
		weather = weather.next();
		weatherChanged();
	}
	
	
	public WeatherType getWeather()
	{
		return weather;
	}


	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}


	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}


	@Override
	public void notifyObservers() {
		for (Observer observer : observers ) {
			observer.update(weather);
		}
		
	}
	public void weatherChanged() {
		notifyObservers();
	}

}
