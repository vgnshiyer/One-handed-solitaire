
# One Handed Solitaire
<img width="505" alt="Screenshot 2023-05-29 at 3 28 12 PM" src="https://github.com/vgnshiyer/One-handed-solitaire/assets/39982819/4b6fa0d6-80a8-4272-9bed-cb499d785a53">
<img width="326" alt="Screenshot 2023-05-29 at 3 29 06 PM" src="https://github.com/vgnshiyer/One-handed-solitaire/assets/39982819/f68f51fe-fa88-49ea-aa87-334efb2a7b8d">
<img width="526" alt="Screenshot 2023-05-29 at 3 29 47 PM" src="https://github.com/vgnshiyer/One-handed-solitaire/assets/39982819/28ce22bf-9db7-4346-828e-cace2ff5e3ff">

One-Handed Solitaire is a simple card game that can be played with one hand. The goal of the game is to move all of the cards to the foundation piles. You can only move cards that are one higher or one lower than the card on top of the foundation pile.

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

[1] https://www.javatpoint.com/design-patterns-in-java
[2] https://www.tutorialspoint.com/design_pattern/index.htm
[3] https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial

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
