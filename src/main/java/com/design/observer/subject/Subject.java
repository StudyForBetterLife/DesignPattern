package com.design.observer.subject;

import com.design.observer.observer.Observer;

public interface Subject {

  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
