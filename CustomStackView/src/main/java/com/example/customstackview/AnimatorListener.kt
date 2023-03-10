package com.example.customstackview

import android.animation.Animator

abstract class AnimatorListener : Animator.AnimatorListener {

    override fun onAnimationStart(animation: Animator) {}

    override fun onAnimationRepeat(animation: Animator) {}

}