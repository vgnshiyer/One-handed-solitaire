package toilet.solitaire.design.patterns.vgnshiyer.models.services;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;

public class AsciiText {
    public static String WELCOME = 
    ColorCodes.PURPLE +
    "\n\n\n" +
    "  _____     _ _      _     ____        _ _ _        _           \n" +
    " |_   _|__ (_) | ___| |_  / ___|  ___ | (_) |_ __ _(_)_ __ ___  \n" +
    "   | |/ _ \\| | |/ _ \\ __| \\___ \\ / _ \\| | | __/ _` | | '__/ _ \\ \n" +
    "   | | (_) | | |  __/ |_   ___) | (_) | | | && (_| | | | |  __/ \n" + 
    "   |_|\\___/|_|_|\\___|\\__| |____/ \\___/|_|_|\\__\\__,_|_|_|  \\___|  \n\n\n" + 
    ColorCodes.RESET;

    public static String SUPERWIN = 
    ColorCodes.GREEN +
    "\n\n\n" +
    "___ _                 ____  _   _ ____  _____ ____   __        _____ _   _ _ _ \n" +
    "|_ _| |____    __ _  / ___|| | | |  _ \\| ____|  _ \\  \\ \\      / /_ _| \\ | | | |\n" +
    "| || __/ __|  / _` | \\___ \\| | | | |_) |  _| | |_) |  \\ \\ /\\ / / | ||  \\| | | |\n" +
    "| || |_\\__ \\ | (_| |  ___) | |_| |  __/| |___|  _ <    \\ V  V /  | || |\\  |_|_|\n" +
    "|___|\\__|___/ \\__,_| |____/ \\___/|_|   |_____|_| \\_\\    \\_/\\_/  |___|_| \\_(_|_)\n\n\n" +
    ColorCodes.RESET;

    public static String WIN = 
    ColorCodes.YELLOW + 
    "\n\n\n" +
    "__   _____  _   _  __        _____ _   _ \n" +
    "\\ \\ / / _ \\| | | | \\ \\      / /_ _| \\ | |\n" +
    " \\ V / | | | | | |  \\ \\ /\\ / / | ||  \\| |\n" +
    "  | || |_| | |_| |   \\ V  V /  | || |\\  |\n" +
    "  |_| \\___/ \\___/     \\_/\\_/  |___|_| \\_|\n\n\n" +
    ColorCodes.RESET;

    public static String LOSE =
    ColorCodes.RED +
    "\n\n\n" +
    "__   _____  _   _   _     ___  ____  _____ \n" +
    "\\ \\ / / _ \\| | | | | |   / _ \\/ ___|| ____|\n" +
    " \\ V / | | | | | | | |  | | | \\___ \\|  _|  \n" +
    "  | || |_| | |_| | | |__| |_| |___) | |___ \n" +
    "  |_| \\___/ \\___/  |_____\\___/|____/|_____|\n\n\n" +
    ColorCodes.RESET;
}
