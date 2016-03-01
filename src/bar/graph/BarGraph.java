package bar.graph;

public class BarGraph {

    public static void main(String[] args) {
        
        final GraphModel model = new GraphModel();

        //create items
        GraphItem[] items = {
            new RGBItem(RGBItem.ColorName.RED, 0),
            new RGBItem(RGBItem.ColorName.GREEN, 0),
            new RGBItem(RGBItem.ColorName.BLUE, 0),
        };
        
        //add items to the model
        for(GraphItem item : items){
            model.addItem(item);
        }
        
        //create bar view
        BarViewFrame barView = new BarViewFrame(model);
        
        //create number view
        NumberViewFrame numberView = new NumberViewFrame(model);

    }
    
}
