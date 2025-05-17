package patterns.behavioural.observer;

import java.util.*;

// Observer.java
 interface Observer {
	void update(float temperature, float humidity);
}

// Subject.java
 interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}

 class WeatherStation implements Subject {
	private List<Observer> observers = new ArrayList<>();
	private float temperature;
	private float humidity;

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(temperature, humidity);
		}
	}

	public void setMeasurements(float temp, float humidity) {
		this.temperature = temp;
		this.humidity = humidity;
		notifyObservers();
	}
}

 class Display implements Observer {
	private float temperature;
	private float humidity;

	@Override
	public void update(float temperature, float humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("Current conditions: " + temperature + "C and " + humidity + "% humidity");
	}
}
//=============

public class ObserverPatternDemo {
	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		Display display = new Display();

		station.registerObserver(display);
		station.setMeasurements(25.0f, 60.0f);
		station.setMeasurements(26.5f, 55.0f);
	}
}