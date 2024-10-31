package com.hypersoft.compareimageslider

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.hypersoft.compareimageslider.databinding.CompareImageSliderBinding


class CompareImageSlider @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: CompareImageSliderBinding


    init {
        init(attrs)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun init(attrs: AttributeSet?) {
        binding = CompareImageSliderBinding.bind(
            View.inflate(
                context,
                R.layout.compare_image_slider,
                this
            )
        )

        val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CompareImageSlider)
        try {



            val drawableBackground =
                styledAttrs.getResourceId(R.styleable.CompareImageSlider_background_image, 0)
            if (drawableBackground != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableBackground)
                binding.backgroundImage.setImageDrawable(drawable)
            }

            val drawableForeground =
                styledAttrs.getResourceId(R.styleable.CompareImageSlider_foreground_image, 0)
            if (drawableForeground != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableForeground)
                binding.foregroundImage.setImageDrawable(drawable)
            }

            val drawableSliderIcon =
                styledAttrs.getResourceId(R.styleable.CompareImageSlider_slider_icon, 0)
            if (drawableSliderIcon != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableSliderIcon)
                binding.sliderImage.setImageDrawable(drawable)
            }

            val textColor = styledAttrs.getColor(R.styleable.CompareImageSlider_textColor, Color.BLACK)
            val textBackground = styledAttrs.getResourceId(R.styleable.CompareImageSlider_textBackground, android.R.color.transparent)

            binding.beforeLabel.setTextColor(textColor)
            binding.beforeLabel.setBackgroundResource(textBackground)

        } finally {
            styledAttrs.recycle()
        }



        binding.sbImageSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                setImageWidth(progress)
                setTextPosition(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })



        binding.backgroundImage.post {
            val height = binding.backgroundImage.height
            val width = binding.backgroundImage.width
            binding.foregroundImage.layoutParams.height = height
            binding.foregroundImage.layoutParams.width = width
            binding.sbImageSeek.max = width
            binding.sbImageSeek.progress = width / 2
            binding.sliderBar.layoutParams.height = height
        }


    }




    private fun setImageWidth(progress: Int) {
        if (progress <= 0) return
        val lp: ViewGroup.LayoutParams = binding.target.layoutParams
        lp.width = progress
        binding.target.layoutParams = lp
    }

    private fun setTextPosition (progress: Int)
    {

//        if(progress< (binding.sbImageSeek.max)/2)
//        {
//            val beforeLabelParams = binding.beforeLabel.layoutParams as MarginLayoutParams
//            beforeLabelParams.marginEnd = progress
//            binding.beforeLabel.layoutParams = beforeLabelParams
//        }else
//        {
//            val beforeLabelParams = binding.beforeLabel.layoutParams as MarginLayoutParams
//            beforeLabelParams.marginStart = progress
//            binding.beforeLabel.layoutParams = beforeLabelParams
//        }

//        val beforeLabelParams = binding.beforeLabel.layoutParams as MarginLayoutParams
//        beforeLabelParams.marginStart = progress - binding.beforeLabel.width/2 - binding.sliderBar.width
//        binding.beforeLabel.layoutParams = beforeLabelParams


    }

}