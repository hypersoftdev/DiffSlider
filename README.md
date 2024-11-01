[![](https://jitpack.io/v/hypersoftdev/DiffSlider.svg)](https://jitpack.io/#hypersoftdev/DiffSlider)

# DiffSlider

**DiffSlider** is a customizable Android library designed to enhance user interaction by providing an intuitive draggable color picker. This view allows users to select colors from the underlying layout dynamically, making it perfect for applications that require color customization, such as design tools and art applications.

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

Include the **ColorPicker** library in your **app-level** `build.gradle` file. Replace `x.x.x` with the latest version: [![](https://jitpack.io/v/hypersoftdev/DiffSlider.svg)](https://jitpack.io/#hypersoftdev/DiffSlider)

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
  <com.hyeprsoft.picker.ColorPickerView
        android:id="@+id/color_picker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:strokeColor="@color/white"
        app:changeStrokeColor="true"
        app:strokeWidth="15dp"
        app:circleRadius="40dp"
        />
```

### Java/Kotlin

### 1. Attach Listener to get real time information

Implement OnColorChangeListener in your activity/fragment where you are using ColorPickerView and implement its method.

```
  -> fun onColorChanged(color: Int)
  -> fun onHexColorChanged(hexColor: String)

```

### 2. Change ColorPickerView color

Apply your desire color to colorpickerview:


```
val color = ContextCompat.getColor(this,R.color.black)
colorPicker.setStrokeColor(color)

```

### 3. Set ColorPickerView Radius

Change Radius the view: ( min 30f & max 200f)

```
 colorPicker.setCircleRadius(50f)

```


## Attribute Summary

| Attribute                        | Format    | Description                                        |
|----------------------------------|-----------|----------------------------------------------------|
| `strokeColor `                   | color     | Set stroke color of the colorpickerview.           |
| `changeStrokeColor`              | boolean   | Change real time stroke color during picking color |
| `strokeWidth`                    | dimension | Change stroke width of colorpickerview.            |
| `circleRadius`                   | dimension | Change circle radius.                              |
| `outerCircleColor`               | color     | Change outerCircle Color.                          |


## Screen Sample
![Sample](https://github.com/hypersoftdev/ColorPicker/blob/master/screens/screengif.gif?raw=true)

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
