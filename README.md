

# One Handed Solitaire

**CLI Version**

<img width="505" alt="Screenshot 2023-05-29 at 3 28 12 PM" src="https://github.com/vgnshiyer/One-handed-solitaire/assets/39982819/4b6fa0d6-80a8-4272-9bed-cb499d785a53">

![ezgif-1-816499368b](https://github.com/vgnshiyer/One-handed-solitaire/assets/39982819/e153fa54-59cd-469b-9589-fd9667b114e2)


**GUI Version**

![ezgif-1-b3a2c99d83](https://github.com/vgnshiyer/One-handed-solitaire/assets/39982819/97f7f353-5cbe-40af-a32f-aabb80800942)


One-Handed Solitaire is a simple card game that can be played with one hand. The goal of the game is to move as many number of the cards as possible to the foundation piles. The lesser cards you have in your hand at the end of the game, the higher your score is.

There are three different sets of rules that you can choose from:

-   **Basic Rules:**
    -   If the first and fourth cards in a row are of the same suit, remove the middle two cards.
    -   If the first and fourth cards in a row are of the same rank, remove all four cards.
-   **Intermediate Rules:**
    -   If two adjacent cards are of the same rank, remove the pair.
-   **House Rules:**
    -   If the first and fourth cards in a row are of the same suit and the third and fourth cards in a row are of the same rank, remove the last three cards.
    -   To win the game, you must have at most four cards in hand. A super win occurs when you remove all four cards or have 1 card in hand.

To choose the rules that you want to play with, use the menu at the start of the game.

# References

[1] https://www.javatpoint.com/design-patterns-in-java \
[2] https://www.tutorialspoint.com/design_pattern/index.htm \
[3] https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial

The Application features interactive visual controls and is built using Java design patterns and Gradle, following a test driven development approach.

# Before you begin

## Requirements

- JDK17 or lower
- Gradle

### Build from Source

**MacOS/Linux**
```
./gradlew build
```
For gui version
```
./gradlew build -Dclass="gui"
```

**Windows**
```
./gradlew.bat build
```
For gui version
```
./gradlew.bat build -Dclass="gui"
```
### Dry build

**MacOS/Linux**
```
./gradlew shadowJar
```
For gui version
```
./gradlew shadowJar -Dclass="gui"
```
**Windows**
```
./gradlew.bat shadowJar
```
For gui version
```
./gradlew.bat shadowJar -Dclass="gui"
```

**Run the custom-built jar file**

- Replace `<VERSION>` with the version you built (see the `gradle.properties`file)
```
java -jar ./app/build/libs/app-0.1.0.jar
```

**If you have make installed, run**

Build & run
```
make run
```
For gui version
```
make rungui
```
Test
```
make test
```
