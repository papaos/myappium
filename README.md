# myappium

java-client-6.1.0.jarは
driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
がNULLになるので、java-client-5.0.0.jarがよい
https://repo1.maven.org/maven2/io/appium/java-client/5.0.0/

appium 1.9.1 はfindelementで暴走するがv1.7.2でうまく動いた
npm uninstall -g appium
npm install -g appium@1.7.2 --no-shrinkwrap
npm install -g appium-doctor

今のところJunit4がいろいろ使えそう。
