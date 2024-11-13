[![](https://jitpack.io/v/hypersoftdev/DiffSlider.svg)](https://jitpack.io/#hypersoftdev/DiffSlider)

# DiffSlider

**DiffSlider** This Kotlin library enables intuitive side-by-side image comparison through a
responsive slider interface. Designed to be lightweight and user-friendly, it allows users to
visually compare two images by dragging a slider across the screen. Ideal for showcasing
before-and-after effects, this library is simple to integrate into Android projects and provides
smooth performance for a seamless user experience.

## Gradle Integration

### Step A: Add Maven Repository

In your project-level **build.gradle** or **settings.gradle** file, add the JitPack repository:

```
repositories {
    google()
    mavenCentral()
    maven { url "https://jitpack.io" }
}
```  

### Step B: Add Dependencies

Include the **DiffSlider** library in your **app-level** `build.gradle` file. Replace `x.x.x` with
the latest
version: [![](https://jitpack.io/v/hypersoftdev/DiffSlider.svg)](https://jitpack.io/#hypersoftdev/DiffSlider)

Groovy Version

```
 implementation 'com.github.hypersoftdev:DiffSlider:x.x.x'
```

Kts Version

```
 implementation("com.github.hypersoftdev:DiffSlider:x.x.x")
```

## Implementation

### XML Example:

```
<com.hypersoft.compareimageslider.CompareImageSlider
        android:layout_width="match_parent"
        android:layout_height="250dp"
        app:background_image="@drawable/background"
        app:foreground_image="@drawable/foreground"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:slider_icon="@drawable/ic_seekbar_thumb"
        app:before_text="Before"
        app:after_text="After"
        app:text_size="10dp"
        app:text_color="@color/black"
        app:slider_bar_width="4dp"
        app:slider_bar_color="@color/black"
        />
```


## Available Methods in CompareImageSlider

### 1. `setBackgroundDrawable(int resId)`
Sets the background image for the CompareImageSlider. Use this method to provide the resource ID of the desired drawable.

**Parameters:**
- `resId`: Resource ID of the background drawable.

### 2. `setForegroundDrawable(int resId)`
Sets the foreground image for the CompareImageSlider. Use this method to provide the resource ID of the desired drawable.

**Parameters:**
- `resId`: Resource ID of the foreground drawable.

### 3. `setSliderIcon(int resId)`
Sets the icon for the slider thumb. Use this method to provide the resource ID of the desired drawable for the slider icon.

**Parameters:**
- `resId`: Resource ID of the slider icon drawable.

### 4. `setBeforeText(String text)`
Sets the label text that appears on the left side of the slider.

**Parameters:**
- `text`: The text to display as the "before" label.

### 5. `setAfterText(String text)`
Sets the label text that appears on the right side of the slider.

**Parameters:**
- `text`: The text to display as the "after" label.

### 6. `setTextColor(int color)`
Sets the color for the label text in the CompareImageSlider.

**Parameters:**
- `color`: The color value for the text.

### 7. `setTextSize(float size)`
Sets the size of the label text.

**Parameters:**
- `size`: The desired text size in pixels.

### 8. `setTextBackground(int resId)`
Sets the background drawable for the label text.

**Parameters:**
- `resId`: Resource ID of the drawable to use as the background for the text.

### 9. `setSliderBarColor(int color)`
Sets the color of the slider bar, which appears between the foreground and background images.

**Parameters:**
- `color`: The color value for the slider bar.

### 10. `setSliderBarWidth(int width)`
Sets the width of the slider bar in pixels.

**Parameters:**
- `width`: The desired width in pixels.



## Attribute Summary

| Attribute          | Format    | Description                          |
|--------------------|-----------|--------------------------------------|
| `background_image` | reference | Set background image for comparison. |
| `foreground_image` | reference | Set foreground image for comparison. |
| `slider_icon`      | reference | Change slider thumbnail icon.        |
| `before_text`      | string    | Set before text.                     |
| `after_text`       | string    | Set after text.                      |
| `text_color `      | color     | Set before-after text color.         |
| `text_size`        | dimension | Set before-after text size.          |
| `text_background`  | reference | Change before-after text background. |
| `slider_bar_color` | color     | Change comparison slider bar color.  |
| `slider_bar_width` | dimension | Change comparison slider bar width.  |

## Screen Sample

![screen_demo](https://github.com/user-attachments/assets/72401c0b-0966-496e-981b-464e5bda050d)


# Acknowledgements

This work would not have been possible without the invaluable contributions of **Bilal Ahmed**. His
expertise, dedication, and unwavering support have been instrumental in bringing this project to
fruition.

![Profile](https://github.com/hypersoftdev/ColorPicker/blob/master/screens/profile_image.jpg?raw=true)

We are deeply grateful for **Bilal Ahmed** involvement and his belief in the importance of this
work. His contributions have made a significant impact, and we are honored to have had the
opportunity to collaborate with him.

# LICENSE

Copyright 2023 Hypersoft Inc

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
