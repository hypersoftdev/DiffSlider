package com.hypersoft.compareimageslider

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.hypersoft.compareimageslider.databinding.CompareImageSliderBinding

class CompareImageSlider @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: CompareImageSliderBinding
    private var scaleFactor = 1.0f
    private val scaleGestureDetector: ScaleGestureDetector

    init {
        init(attrs)
        scaleGestureDetector = ScaleGestureDetector(context, ScaleListener())
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun init(attrs: AttributeSet?) {
        binding = CompareImageSliderBinding.bind(View.inflate(context, R.layout.compare_image_slider, this))

        val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CompareImageSlider)
        try {


            setBackgroundDrawable(styledAttrs.getResourceId(R.styleable.CompareImageSlider_background_image, 0))
            setForegroundDrawable(styledAttrs.getResourceId(R.styleable.CompareImageSlider_foreground_image, 0))
            setSliderIcon(styledAttrs.getResourceId(R.styleable.CompareImageSlider_slider_icon, 0))
            setBeforeText(styledAttrs.getString(R.styleable.CompareImageSlider_before_text))
            setAfterText(styledAttrs.getString(R.styleable.CompareImageSlider_after_text))
            setTextColor(styledAttrs.getColor(R.styleable.CompareImageSlider_text_color, binding.beforeTv.currentTextColor))
            setTextSize(styledAttrs.getDimension(R.styleable.CompareImageSlider_text_size, binding.beforeTv.textSize))
            setTextBackground(styledAttrs.getResourceId(R.styleable.CompareImageSlider_text_background, 0))
            setSliderBarColor(styledAttrs.getColor(R.styleable.CompareImageSlider_slider_bar_color,ContextCompat.getColor(context, android.R.color.white)))
            setSliderBarWidth(styledAttrs.getDimensionPixelSize(R.styleable.CompareImageSlider_slider_bar_width, binding.sliderBar.layoutParams.width))


        } finally {
            styledAttrs.recycle()
        }

        adjustLayoutDimensions()

        binding.sliderImage.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    val intrinsicWidth = binding.backgroundImage.drawable?.intrinsicWidth
                    val intrinsicHeight = binding.backgroundImage.drawable?.intrinsicHeight

                    val imageViewWidth = binding.backgroundImage.width
                    val imageViewHeight = binding.backgroundImage.height

                    val drawnWidth = (imageViewHeight.toFloat() / intrinsicHeight!! * intrinsicWidth!!).toInt()
                    val difference = imageViewWidth - drawnWidth

                    val newProgress = event.rawX.toInt().coerceIn(difference / 2, drawnWidth + (difference / 2))

                    setImageWidth(newProgress)
                }
            }

            true
        }

        binding.root.setOnTouchListener { _, event ->
            scaleGestureDetector.onTouchEvent(event)
            true
        }

        binding.root.setOnTouchListener { _, event ->
            scaleGestureDetector.onTouchEvent(event)
            true
        }
    }

    private fun adjustLayoutDimensions() {
        binding.backgroundImage.post {
            binding.foregroundImage.layoutParams.height = binding.backgroundImage.height
            binding.foregroundImage.layoutParams.width = binding.backgroundImage.width
            binding.sliderBar.layoutParams.height = binding.backgroundImage.height

            setImageWidth(binding.backgroundImage.width / 2)
        }
    }

    private fun setImageWidth(progress: Int) {
        if (progress <= 0) return
        val lp: ViewGroup.LayoutParams = binding.target.layoutParams
        lp.width = progress
        binding.target.layoutParams = lp
        requestLayout()
    }

    fun setBackgroundImage(bitmap: Bitmap) {
        binding.backgroundImage.setImageBitmap(bitmap)
        binding.backgroundImage.post {
            adjustLayoutDimensions()
        }
    }

    fun setForegroundImage(bitmap: Bitmap) {
        binding.foregroundImage.setImageBitmap(bitmap)
        binding.foregroundImage.post {
            adjustLayoutDimensions()
        }
    }

    fun setBackgroundDrawable (drawableBackground:Int)
    {
        if (drawableBackground != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableBackground)
            binding.backgroundImage.setImageDrawable(drawable)
        }
    }

    fun setForegroundDrawable (drawableForeground:Int)
    {
        if (drawableForeground != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableForeground)
            binding.foregroundImage.setImageDrawable(drawable)
        }
    }


    fun setSliderIcon (drawableSliderIcon:Int)
    {
        if (drawableSliderIcon != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableSliderIcon)
            binding.sliderImage.setImageDrawable(drawable)
        }
    }

    fun setBeforeText(text: String?) {
        binding.beforeTv.text = text
    }

    fun setAfterText(text: String?) {
        binding.afterTv.text = text
    }

    fun setTextColor(color: Int) {
        binding.beforeTv.setTextColor(color)
        binding.afterTv.setTextColor(color)
    }

    fun setTextSize(size: Float) {
        binding.beforeTv.textSize = size
        binding.afterTv.textSize = size
    }

    fun setTextBackground(resId: Int) {
        if(resId  !=0)
        {
            binding.beforeTv.setBackgroundResource(resId)
            binding.afterTv.setBackgroundResource(resId)
        }
    }

    fun setSliderBarColor(color: Int) {
        binding.sliderBar.setBackgroundColor(color)
    }

    fun setSliderBarWidth(width: Int) {
        val sliderBarLayoutParams = binding.sliderBar.layoutParams
        sliderBarLayoutParams.width = width
        binding.sliderBar.layoutParams = sliderBarLayoutParams
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {

            scaleFactor *= detector.scaleFactor
            scaleFactor = scaleFactor.coerceIn(1.0f, 3.0f)
            binding.backgroundImage.scaleX = scaleFactor
            binding.backgroundImage.scaleY = scaleFactor
            binding.foregroundImage.scaleX = scaleFactor
            binding.foregroundImage.scaleY = scaleFactor

            return true
        }
    }
}
