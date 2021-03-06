package com.example.learncustomview.custom

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView
import com.example.learncustomview.R

/**
 * Created by Linh Pham on 5/31/2022.
 **/
@SuppressLint("Recycle", "CustomViewStyleable")
class RotationImage(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {
    private var _animator: ObjectAnimator? = null

    init {
        setImageResource(R.drawable.sun)
    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelAnimation()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        createAnimationRotation()
    }

    private fun createAnimationRotation() {
        _animator = ObjectAnimator.ofFloat(this, "rotation", 0f, -360f)
        _animator?.repeatCount = ObjectAnimator.INFINITE
        _animator?.interpolator = LinearInterpolator()
        _animator?.duration = 3600
        _animator?.start()
    }

    private fun cancelAnimation() {
        _animator?.cancel()
    }
}