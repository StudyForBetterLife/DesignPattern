package observer.observer.impl;

import java.util.ArrayList;
import java.util.List;
import observer.observer.DisplayElement;
import observer.observer.Observer;
import observer.subject.impl.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {

  private final List<Float> temperatureData;
  private final List<Float> humidityData;
  private final List<Float> pressureData;
  private final WeatherData weatherData; // 옵저버는 주제(subject)를 알고 있다.

  public StatisticsDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    this.temperatureData = new ArrayList<>();
    this.humidityData = new ArrayList<>();
    this.pressureData = new ArrayList<>();
    weatherData.registerObserver(this);
  }

  private double getStatistics(List<Float> data) {
    return (data.isEmpty()) ? 0d : data.stream().mapToDouble(i -> i).sum() / data.size();
  }

  @Override
  public void display() {
    System.out.println("[StatisticsDisplay]\n일기 예보 통계 : 온도 " + getStatistics(temperatureData) +
        "F, 습도 " + getStatistics(humidityData) +
        "%, 기압 " + getStatistics(pressureData));
  }

  @Override
  public void updateByPush(float temp, float humidity, float pressure) {
    temperatureData.add(temp);
    humidityData.add(humidity);
    pressureData.add(pressure);
    display();
  }

  @Override
  public void updateByPull() {
    temperatureData.add(weatherData.getTemperatures());
    humidityData.add(weatherData.getHumidity());
    pressureData.add(weatherData.getPressure());
    display();
  }
}
