package me.tabak.deadsimpledagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// Application scoped module
@Module(
    injects = {
        DeadSimpleApplication.class,
    },
    complete = false
)
public class DeadSimpleApplicationModule {
  private final DeadSimpleApplication mApplication;

  public DeadSimpleApplicationModule(DeadSimpleApplication application) {
    mApplication = application;
  }

  @Provides @Singleton
  DeadSimpleApplication provideApplication() {
    return mApplication;
  }
}
