package me.tabak.deadsimpledagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// Activity scoped module.
@Module(
    injects = {
        DeadSimpleActivity.class,
        DeadSimpleView.class,
        DeadSimpleDependency.class
    },
    addsTo = DeadSimpleApplicationModule.class
)
public class DeadSimpleActivityModule {
  private final DeadSimpleActivity mActivity;

  public DeadSimpleActivityModule(DeadSimpleActivity activity) {
    mActivity = activity;
  }

  @Provides @Singleton
  DeadSimpleActivity provideActivity() {
    return mActivity;
  }
}
