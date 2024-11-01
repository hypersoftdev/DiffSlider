[![](https://jitpack.io/v/hypersoftdev/DiffSlider.svg)](https://jitpack.io/#hypersoftdev/DiffSlider)

# DiffSlider

**DiffSlider** This Kotlin library enables intuitive side-by-side image comparison through a responsive slider interface. Designed to be lightweight and user-friendly, it allows users to visually compare two images by dragging a slider across the screen. Ideal for showcasing before-and-after effects, this library is simple to integrate into Android projects and provides smooth performance for a seamless user experience.

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

Include the **DiffSlider** library in your **app-level** `build.gradle` file. Replace `x.x.x` with the latest version: [![](https://jitpack.io/v/hypersoftdev/DiffSlider.svg)](https://jitpack.io/#hypersoftdev/DiffSlider)

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
        app:slider_icon="@drawable/ic_seekbar_thumb"
        app:showComparisonText="false"
        app:showComparisonBar="true"
        app:showComparisonBar="true"
        app:comparisonBarColor="@color/black"
        app:textBackground="@drawable/image_compare_slider_text_bg"
        app:textColor="@color/black"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />
```


## Attribute Summary

| Attribute            | Format  | Description                          |
|----------------------|---------|--------------------------------------|
| `background_image `  | Int     | Set background image for comparison. |
| `foreground_image`   | Int     | Set foreground image for comparison. |
| `slider_icon`        | Int     | Change slider thumbnail icon.        |
| `showComparisonText` | boolean | Set before after text visibility.    |
| `comparisonBarColor` | color   | Change comparison bar color.         |
| `showComparisonBar ` | boolean | Set comparison bar visibility.       |
| `textBackground`     | Int     | Change before-after text background. |
| `textColor `         | color   | Change before after text color.      |


## Screen Sample
![screen1](https://github.com/user-attachments/assets/830862a7-9ed0-454b-bb52-b606c77cf4e2)


# Acknowledgements

This work would not have been possible without the invaluable contributions of **Bilal Ahmed**. His expertise, dedication, and unwavering support have been instrumental in bringing this project to fruition.

![Profile](https://github.com/hypersoftdev/ColorPicker/blob/master/screens/profile_image.jpg?raw=true)

We are deeply grateful for **Bilal Ahmed** involvement and his belief in the importance of this work. His contributions have made a significant impact, and we are honored to have had the opportunity to collaborate with him.

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
