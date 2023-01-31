# habbokt
A Habbo Hotel Private Server Written in Kotlin.

# Dependencies

- Gradle 7.6
- Kotlin 1.7.10
- Java SDK 18

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

# Adobe Flash Player Compatible Browser
_Please note that Adobe Flash is no longer supported on modern browsers due to security issues. Use this browser at your own risk!_
  ```
  https://archive.org/details/basilisk-portable-with-flash
  ```

# Starting the Web Server
_Running the auto-reload task and the web-server task in Gradle simultaneously is very powerful for development._

- To start the web server using Gradle, you can run the run task in a terminal:
  ```shell
  ./gradlew :web:run
  ```

# Starting the Game Server
- To start the game server using Gradle, you can run the run task in a terminal:
  ```shell
  ./gradlew :game:run
  ```
  *Note: The game server relies on the web-server to be online for now.*

<p align="center">
  <img src="https://github.com/ultraviolet-jordan/habbokt/blob/main/assets/registration.jpg?raw=true" alt="Habbo Hotel Registration"/>
</p>

<p align="center">
  <img src="https://github.com/ultraviolet-jordan/habbokt/blob/main/assets/navigation.jpg?raw=true" alt="Habbo Hotel Navigation"/>
</p>

<p align="center">
  <img src="https://github.com/ultraviolet-jordan/habbokt/blob/main/assets/room.jpg?raw=true" alt="Habbo Hotel Room"/>
</p>
