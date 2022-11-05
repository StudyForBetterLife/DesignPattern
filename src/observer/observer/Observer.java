package observer.observer;

public interface Observer {

  void updateByPush(float temp, float humidity, float pressure); // subject -> observer (push)

  void updateByPull(); // observer <- subject (pull)
}
