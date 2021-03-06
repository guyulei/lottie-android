package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.Mask;

import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {
  private final List<BaseKeyframeAnimation<?, Path>> maskAnimations;
  private final List<KeyframeAnimation<Integer>> opacityAnimations;
  private final List<Mask> masks;

  public MaskKeyframeAnimation(List<Mask> masks) {
    this.masks = masks;
    this.maskAnimations = new ArrayList<>(masks.size());
    this.opacityAnimations = new ArrayList<>(masks.size());
    for (int i = 0; i < masks.size(); i++) {
      this.maskAnimations.add(masks.get(i).getMaskPath().createAnimation());
      AnimatableIntegerValue opacity = masks.get(i).getOpacity();
      opacityAnimations.add(opacity.createAnimation());
    }
  }

  public List<Mask> getMasks() {
    return masks;
  }

  public List<BaseKeyframeAnimation<?, Path>> getMaskAnimations() {
    return maskAnimations;
  }

  public List<KeyframeAnimation<Integer>> getOpacityAnimations() {
    return opacityAnimations;
  }
}
