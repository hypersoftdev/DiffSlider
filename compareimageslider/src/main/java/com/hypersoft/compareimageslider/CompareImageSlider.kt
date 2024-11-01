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
import androidx.core.content.res.TypedArrayUtils.getResourceId
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


            setBackgroundImage(styledAttrs.getResourceId(R.styleable.CompareImageSlider_background_image,0))
            setForegroundImage(styledAttrs.getResourceId(R.styleable.CompareImageSlider_foreground_image,0))
            setSliderIcon(styledAttrs.getResourceId(R.styleable.CompareImageSlider_slider_icon, 0))
            setTextColor(styledAttrs.getColor(R.styleable.CompareImageSlider_textColor, Color.BLACK))
            setTextBackgroundColor(styledAttrs.getResourceId(R.styleable.CompareImageSlider_textBackground, android.R.color.transparent))
            showComparisonText(styledAttrs.getBoolean(R.styleable.CompareImageSlider_showComparisonText, true))
            showComparisonBar(styledAttrs.getBoolean(R.styleable.CompareImageSlider_showComparisonBar, true))
            changeComparisonBarColor(styledAttrs.getColor(R.styleable.CompareImageSlider_comparisonBarColor, Color.WHITE))


        } finally {
            styledAttrs.recycle()
        }



        binding.sbImageSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                setImageWidth(progress)
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



    private fun setBackgroundImage (drawableBackground:Int)
    {
        if (drawableBackground != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableBackground)
            binding.backgroundImage.setImageDrawable(drawable)
        }
    }

    private fun setForegroundImage (drawableForeground:Int)
    {
        if (drawableForeground != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableForeground)
            binding.foregroundImage.setImageDrawable(drawable)
        }
    }

    private fun setSliderIcon (drawableSliderIcon:Int)
    {
        if (drawableSliderIcon != 0) {
            val drawable = AppCompatResources.getDrawable(context, drawableSliderIcon)
            binding.sliderImage.setImageDrawable(drawable)
        }
    }

    private fun setTextColor (textColor:Int)
    {
        binding.beforeAfterLabel.setTextColor(textColor)

    }

    private fun setTextBackgroundColor (textColor:Int)
    {
        binding.beforeAfterLabel.setTextColor(textColor)

    }

    private fun showComparisonText (show:Boolean)
    {
        if(show)
        {
            binding.beforeAfterLabel.visibility=View.VISIBLE
        }else
        {
            binding.beforeAfterLabel.visibility=View.GONE

        }
    }

    private fun showComparisonBar (show:Boolean)
    {
        if(show)
        {
            binding.sliderImage.visibility=View.VISIBLE
            binding.sliderBar.visibility=View.VISIBLE
        }else
        {
            binding.sliderImage.visibility=View.GONE
            binding.sliderBar.visibility=View.GONE

        }
    }

    private fun changeComparisonBarColor (color:Int)
    {
        binding.sliderBar.setBackgroundColor(color)
    }


//    private fun applySettings ()
//    {
//        binding.beforeLabel.setTextColor(textColor)
//        binding.beforeLabel.setBackgroundResource(textBackground)
//    }

    private fun setImageWidth(progress: Int) {
        if (progress <= 0) return
        val lp: ViewGroup.LayoutParams = binding.target.layoutParams
        lp.width = progress
        binding.target.layoutParams = lp
    }


}