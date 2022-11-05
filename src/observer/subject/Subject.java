package observer.subject;

import observer.observer.Observer;

public interface Subject {

  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
