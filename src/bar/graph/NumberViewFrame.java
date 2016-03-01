package bar.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NumberViewFrame extends JFrame{
    
    public NumberViewFrame(GraphModel m){
        model = m;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        for(Iterator i = model.getItems() ; i.hasNext() ; ){
            final GraphItem item = (GraphItem)i.next();
            
            JPanel numberPanel = new JPanel();
            JLabel numberLabel = new JLabel(item.toString());
            final JTextField numberField = new JTextField(String.valueOf(item.getValue()), 5);
            numberLabel.setForeground(item.getColor());
            
            numberField.addActionListener(new
                ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent a) {    
                        try{
                            item.setValue(Integer.valueOf(numberField.getText()));
                            model.updated();
                        }catch(Exception e){
                            numberField.setText("Error");
                        }
                    }
                    
                });
            
            numberPanel.add(numberLabel);
            numberPanel.add(numberField);
            add(numberPanel);
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    
    private GraphModel model;
}
