package me.tabak.deadsimpledagger;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import javax.inject.Inject;

public class DeadSimpleView extends TextView {
  @Inject DeadSimpleDependency dependency;

  @Inject public DeadSimpleView(DeadSimpleActivity activity) {
    this ((Context) activity);
    activity.getObjectGraph().inject(this);

    // Set the text of this view to prove that the dependencies were satisfied
    setText(dependency.stringifyDependencies());
  }

  public DeadSimpleView(Context context) {
    super(context);
  }

  public DeadSimpleView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

}
