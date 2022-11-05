package observer.observer.impl;

import observer.observer.DisplayElement;
import observer.observer.Observer;
import observer.subject.impl.WeatherData;

/**
 * 측정치를 바탕으로 기상 예보를 하는 디스플레이
 */
public class ForecastDisplay implements Observer, DisplayElement {

  private float temperatures;
  private float humidity;
  private float pressure;
  private final WeatherData weatherData; // 옵저버는 주제(subject)를 알고 있다.

  public ForecastDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  private float forecastTemp() {
    if (temperatures < 0) {
      return -1;
    }

    return temperatures * 1.15F;
  }

  @Override
  public void display() {
    System.out.println("[ForecastDisplay]\n일기 예보 : 온도 " + forecastTemp() +
        "F, 습도 " + humidity +
        "%, 기압 " + pressure);
  }

  @Override
  public void updateByPush(float temp, float humidity, float pressure) {
    this.temperatures = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    display();
  }

  @Override
  public void updateByPull() {
    this.temperatures = weatherData.getTemperatures();
    this.humidity = weatherData.getHumidity();
    this.pressure = weatherData.getPressure();
    display();
  }
}
