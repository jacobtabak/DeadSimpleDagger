package me.tabak.deadsimpledagger;

import android.app.Application;

import dagger.ObjectGraph;

public class DeadSimpleApplication extends Application {
  private ObjectGraph objectGraph;

  @Override public void onCreate() {
    super.onCreate();
    // Initialize the object graph with the application-scoped module
    objectGraph = ObjectGraph.create(new DeadSimpleApplicationModule(this));
    objectGraph.inject(this);
  }

  // Gets an instance of the object graph which can be used to inject dependencies
  // You can also call .plus() on this object graph to add other modules to the graph.
  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }
}
