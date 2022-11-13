package observer;

import observer.observer.impl.CurrentConditionDisplay;
import observer.observer.impl.ForecastDisplay;
import observer.observer.impl.StatisticsDisplay;
import observer.subject.impl.WeatherData;

public class ObserverPattern {

  /**
   * **오늘 날씨 temperatures=80.0, humidity=65.0, pressure=30.4** [CurrentConditionDisplay] 현재 상태 : 온도80.0F, 습도 65.0%, 기압 30.4 [StatisticsDisplay] 일기 예보 통계 : 온도 80.0F, 습도 65.0%, 기압 30.399999618530273
   * [ForecastDisplay] 일기 예보 : 온도 92.0F, 습도 65.0%, 기압 30.4
   * <p>
   * <p>
   * **오늘 날씨 temperatures=82.0, humidity=70.0, pressure=29.2** [CurrentConditionDisplay] 현재 상태 : 온도82.0F, 습도 70.0%, 기압 29.2 [StatisticsDisplay] 일기 예보 통계 : 온도 81.0F, 습도 67.5%, 기압 29.800000190734863
   * [ForecastDisplay] 일기 예보 : 온도 94.299995F, 습도 70.0%, 기압 29.2
   * <p>
   * <p>
   * **오늘 날씨 temperatures=78.0, humidity=90.0, pressure=22.4** [CurrentConditionDisplay] 현재 상태 : 온도78.0F, 습도 90.0%, 기압 22.4 [StatisticsDisplay] 일기 예보 통계 : 온도 80.0F, 습도 75.0%, 기압 27.333333333333332
   * [ForecastDisplay] 일기 예보 : 온도 89.7F, 습도 90.0%, 기압 22.4
   */
  public static void main(String[] args) {
    final WeatherData weatherData = new WeatherData();

    final CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
    final StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    final ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 22.4f);
    
  }
}
