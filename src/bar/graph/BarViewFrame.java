package bar.graph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BarViewFrame extends JFrame{
    
    public BarViewFrame(GraphModel m){
        model = m;
        
        setLayout(new FlowLayout());

        for(Iterator i = model.getItems() ; i.hasNext() ; ){
            final GraphItem item = (GraphItem)i.next();
 
            JPanel barPanel = new JPanel(new BorderLayout());
            final BarIcon barIcon = new BarIcon(MAX_BAR_WIDTH, MAX_BAR_HEIGHT, item.getMaxValue(), item.getValue(), item.getColor());
            final JLabel barLabel = new JLabel(barIcon);
            barPanel.add(barLabel, BorderLayout.CENTER);
            barPanel.add(new JLabel(item.toString(), SwingConstants.CENTER), BorderLayout.SOUTH);
            add(barPanel);
            
            MouseListener mouseListener = new
                MouseListener(){

                    @Override
                    public void mouseClicked(MouseEvent me) {}

                    @Override
                    public void mousePressed(MouseEvent me) {
                        System.out.println(me.getY());
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {}

                    @Override
                    public void mouseEntered(MouseEvent me) {}

                    @Override
                    public void mouseExited(MouseEvent me) {}
                    
                };
            
            barLabel.addMouseListener(mouseListener);
            
            ChangeListener listener = new
                ChangeListener(){

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        barIcon.setBarValue(item.getValue());
                        barLabel.repaint();
                    }    
                };
            model.addChangeListener(listener);
        }
 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private final GraphModel model;
    private final static int MAX_BAR_WIDTH = 200;
    private final static int MAX_BAR_HEIGHT = 800;
}
