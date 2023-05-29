package toilet.solitaire.design.patterns.vgnshiyer.models.services;

import java.util.*;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;

public class CardDisplay implements Command {
    private static final String[] HAND = {".------..------..------..------.",
                                          "|*.--. ||*.--. ||*.--. ||*.--. |",
                                          "| :**: || :**: || :**: || :**: |",
                                          "| :**: || :**: || :**: || :**: |",
                                          "| '--'*|| '--'*|| '--'*|| '--'*|",
                                          "`------'`------'`------'`------'"};
    private static final Map<Character, String[]> SUIT_MAP = new HashMap<>();
    static {
        SUIT_MAP.put('H', new String[]{"(\\/)", ":\\/:"});
        SUIT_MAP.put('S', new String[]{":/\\:", "(__)"});
        SUIT_MAP.put('C', new String[]{":():", "()()"});
        SUIT_MAP.put('D', new String[]{":/\\:", ":\\/:"});
    }

    private List<Character> ranks;
    private List<Character> suits;

    public CardDisplay(List<Character> ranks, List<Character> suits) {
        this.ranks = ranks;
        this.suits = suits;
    }

    @Override
    public void execute() {
        if (ranks.size() != 4) {
            return;
        }
        String[][] hand = new String[6][HAND[0].length()];

        // Initialize hand array
        for (int i = 0; i < HAND.length; i++) {
            hand[i] = HAND[i].split("");
        }

        int col1 = 1, col2 = 6;
        int col = 2, row = 2;
        for (int i = 0; i < 4; i++) {
            char rank = ranks.get(i);
            // suits
            String[] suit = SUIT_MAP.get(suits.get(i));
            for (int r = 0; r <= 1; r++) {
                for (int c = 0; c <= suit[r].length() - 1; c++) {
                    hand[row + r][col + c] = String.valueOf(suit[r].charAt(c));
                }
            }

            // ranks
            hand[1][col1] = String.valueOf(rank);
            hand[4][col2] = String.valueOf(rank);

            col += 8;
            col1 += 8;
            col2 += 8;
        }

        for (String[] s : hand) {
            for (String ch : s) {
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }
}

