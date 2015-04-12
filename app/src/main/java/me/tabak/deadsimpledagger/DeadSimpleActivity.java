package me.tabak.deadsimpledagger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.ObjectGraph;


public class DeadSimpleActivity extends ActionBarActivity {
  private ObjectGraph objectGraph;

  // DeadSimpleView's Context dependency is satisfied by the activity-scoped object graph
  @Inject DeadSimpleView view;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DeadSimpleApplication app = (DeadSimpleApplication) getApplication();

    // Set this activity's Object Graph to be the application's plus the activity's
    objectGraph = app.getObjectGraph().plus(new DeadSimpleActivityModule(this));
    objectGraph.inject(this);

    ViewGroup container = (ViewGroup) findViewById(R.id.container);
    container.addView(view);
  }

  // Gets the activity-scoped Object graph
  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }
}
