package toilet.solitaire.design.patterns.vgnshiyer.views;

/* Factory method pattern : A pattern which facilitates view object creation */
public class ViewFactory {
    /* gets view name from the user and instantiates the appropriate object */
    public static View getView(String viewName){
        if(viewName == "Dashboard")
            return new DashboardView();
        else if(viewName == "Rule")
            return new RuleView();
        else if(viewName == "Hand")
            return new HandView();
        else if(viewName == "AvailableMoves")
            return new AvailableMovesView();
        else if(viewName == "Shuffle")
            return new ShuffleView();
        return null;
    }
}
