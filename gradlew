#!/bin/sh
exec sh -c 'echo "Installing Gradle..." && gradlew_download_url="https://raw.githubusercontent.com/gradle/gradle/v8.5/gradlew" && curl -Ls $gradlew_download_url | sh'
