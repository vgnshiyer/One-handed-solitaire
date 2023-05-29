package toilet.solitaire.design.patterns.vgnshiyer.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* enum which defines the suits */
public enum Suits {
    Hearts(0),
    Diamonds(1),
    Clubs(2),
    Spades(3);

    private int value;
    public static List<String> values = new ArrayList<>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));
    public static List<Character> shortValues = new ArrayList<>(Arrays.asList('H', 'D', 'C', 'S'));

    private Suits(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static Suits fromValue(int value) {
        switch (value) {
            case 0:
                return Hearts;
            case 1:
                return Diamonds;
            case 2:
                return Clubs;
            case 3:
                return Diamonds;
            default:
                return null;
        }
    }
}
