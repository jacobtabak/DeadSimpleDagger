package me.tabak.deadsimpledagger;

import javax.inject.Inject;

public class DeadSimpleDependency {
  @Inject DeadSimpleApplication mApp;
  @Inject DeadSimpleActivity mActivity;

  // Example of using constructor injection to facilitate field injection
  @Inject public DeadSimpleDependency(DeadSimpleActivity activity) {
    activity.getObjectGraph().inject(this);
  }

  public String stringifyDependencies() {
    return String.format("Application: %s\nActivity: %s", mApp.toString(), mActivity.toString());
  }
}
