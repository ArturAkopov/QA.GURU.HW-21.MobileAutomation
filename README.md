# QA.GURU.HW-20.Browserstack
## Домашнее задание №21


### Настроить рабочий стол:   
Вариант 1:   
https://autotest.how/appium-setup-for-local-android-tutorial-md   

Вариант 2:   
Установить android studio https://developer.android.com/studio   
Прописать настройки:
  
Параметры Path:   

Windows:   
%ANDROID_HOME%\tools   
%ANDROID_HOME%\tools\bin   
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\emulator   

Одной строкой, можно скопировать и в командной строке прописать: 
```shell
setx PATH %PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\emulator
```

Mac:  
export ANDROID_HOME=/Users/stanislav/Library/Android/sdk   
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools   
source ~/.bash_profile      
- В Android Studio -> SDK Manager скачать 11 андроид (если не скачан по умолчанию)   
- В AVD Manager скачать образ Pixel 4 для 11 андроида (если не скачан по умолчанию)   
-- Запустить эмулятор телефона, опробовать кнопки и функционал
- Установить node.js - https://nodejs.org/en/download   
- Установить Appium Server https://github.com/appium/appium

Mac:
```shell
sudo npm install -g appium@next
```    
Windows: 
```shell
npm install -g appium
```

- Установить драйвер uiautomator2   
 Mac:
```shell
 sudo appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)
```   
 Windows:
 ```shell
 appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)
```  

- Установить Appium Ispector https://github.com/appium/appium-inspector   
- Запустить Appium Server    
```shell
appium server --base-path /wd/hub
```
  



### Запуск тестов: 
Для запуска тестов на iPhone использовать команду ниже:
```shell
gradlew clean test -Denv=iPhone14ProMax
```

Для запуска тестов на Android использовать команду ниже:
```shell
gradlew clean test -Denv=samsungGalaxyS22Ultra
```
