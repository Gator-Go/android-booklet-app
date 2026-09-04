# Android Booklet App

Prototype. Factory-generated Booklet app from droid-builder.

Catalog: https://sw-builder.com/appstore/android/apps/android-booklet-app.html

Builder: https://github.com/Gator-Go/droid-builder

## Build (Unix)

Prerequisites: Git, Groovy, JDK, Android SDK.

Expected sibling directories:

    ~/android/droid-builder
    ~/android/android-booklet-app

```bash
cd ~/android/android-booklet-app
git pull
./android-booklet-build.sh

## Layout:

android-booklet-app/
├── android-booklet-build.sh
├── Extender/
│   ├── BookletExtender.groovy
│   ├── logo.png
│   ├── ldpi-logo.png
│   ├── mdpi-logo.png
│   ├── hdpi-logo.png
│   ├── xhdpi-logo.png
│   └── xxhdpi-logo.png
└── options/
    ├── APP_ENUMS.xml
    ├── APP_NAMES.xml
    └── APP_TABLES.xml

## Note:

The template/, build/, and booklet/ dirs appear after a build. They come from
droid-builder.

DroidBuilder.groovy is copied in from droid-builder at build time.
Edit it in the builder repo, not here.