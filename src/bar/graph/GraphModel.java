package bar.graph;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GraphModel {
    
    public GraphModel(){
        items = new ArrayList<>();
        listeners = new ArrayList<>();
    }
    
    public void addItem(GraphItem item){
        items.add(item);
    }
    
    public void addChangeListener(ChangeListener listener){
        listeners.add(listener);
    }
    
    public void updated(){
        ChangeEvent event = new ChangeEvent(this);
        for(ChangeListener listener : listeners){
            listener.stateChanged(event);
        }
    }
    
    public Iterator<GraphItem> getItems(){
        return new
            Iterator<GraphItem>()
            {

                @Override
                public boolean hasNext() {
                    return current < items.size();
                }

                @Override
                public GraphItem next() {
                    return items.get(current++);
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
                private int current = 0;
            };
    }

    private ArrayList<GraphItem> items;
    private ArrayList<ChangeListener> listeners;
}
