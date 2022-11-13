package observer.subject.impl;

import java.util.ArrayList;
import java.util.List;
import observer.observer.Observer;
import observer.subject.Subject;

public class WeatherData implements Subject {

  private final List<Observer> observers; // 여러 옵저버들을 담는 컬랙션
  private float temperatures;
  private float humidity;
  private float pressure;

  public WeatherData() {
    observers = new ArrayList<>();
  }

  public void setMeasurements(float temperatures, float humidity, float pressure) {
    this.temperatures = temperatures;
    this.humidity = humidity;
    this.pressure = pressure;

    System.out.println("\n**오늘 날씨 temperatures=" + temperatures +
        ", humidity=" + humidity +
        ", pressure=" + pressure + "**");

    notifyObservers();
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
    for (final Observer observer : observers) {
      // (push: subject -> observer) subject 클래스에서 observer들에게 데이터를 push 해준다.
      // observer.updateByPush(temperatures, humidity, pressure);

      // (pull : observer <- subject) observer들이 각자 subject의 데이터를 pull한다.
      // push보단 pull이 좋다.
      observer.updateByPull();
    }
  }

  public float getTemperatures() {
    return temperatures;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }
}
