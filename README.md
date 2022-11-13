# habbokt
A Habbo Hotel Private Server Written in Kotlin.

<p align="center">
  <img src="https://github.com/ultraviolet-jordan/habbokt/blob/main/image.jpg?raw=true" alt="Habbo Hotel Registration"/>
</p>

# Autoreloading/Continuous Development
_Since Auto-reload detects changes in output files, you need to rebuild a project. You can do this manually in IntelliJ IDEA or enable continuous build execution in Gradle using the -t command-line option._

- To rebuild a project automatically using Gradle, you can run the build task with the -t option in a terminal:
    ```shell
    ./gradlew -t build
    ```
- Additionally, you can run the following build task with these options to Auto-reload much faster:
  ```shell
  ./gradlew -t build -x test -x jar -x distZip -x distTar
  ```

# Starting the Web-Server
_Running the auto-reload task and the web-server task in Gradle simultaneously is very powerful for development._

- To start the web server using Gradle, you can run the run task in a terminal:
  ```shell
  ./gradlew run
  ```

# Starting the Game-Server
_Coming soon..._