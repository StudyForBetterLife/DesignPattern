package observer.observer.impl;

import observer.observer.DisplayElement;
import observer.observer.Observer;
import observer.subject.impl.WeatherData;

/**
 * 현재 얻은 기상 측정값을 나타내는 디스플레이
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

  private float temperatures;
  private float humidity;
  private float pressure;
  private final WeatherData weatherData; // 옵저버는 주제(subject)를 알고 있다.

  public CurrentConditionDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this); // CurrentConditionDisplay 를 구독한다.
  }

  @Override
  public void display() {
    System.out.println("[CurrentConditionDisplay]\n현재 상태 : 온도" + temperatures +
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
