package bar.graph;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

/**
 *
 * @author Emmanuel
 */
public class BarIcon implements Icon{

    public BarIcon(int iconWidth, int iconHeight, int barMaxValue, int barValue, Color color){
        this.iconHeight = iconHeight;
        this.iconWidth = iconWidth;
        this.barMaxValue = barMaxValue;
        this.barValue = barValue;
        this.color = color;
        calculateBarHeight();
    }
    
    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int x, int y) {
        Graphics2D g2 = (Graphics2D) grphcs;
        
        Rectangle2D.Double bar = new Rectangle2D.Double(x + (0.05 * iconWidth), y + (iconHeight - barHeight) , iconWidth - (2 * 0.05 * iconWidth), barHeight);
        g2.setColor(color);
        g2.fill(bar);
    }

    @Override
    public int getIconWidth() { return iconWidth;}

    @Override
    public int getIconHeight() { return iconHeight;}
    
    public void setBarValue(int barValue){
        this.barValue = barValue;
        calculateBarHeight();
    }
 
   
    private void calculateBarHeight(){
        barHeight = barValue * iconHeight / barMaxValue;
    }
    
    private final int iconWidth;
    private final int iconHeight;
    private int barHeight;
    private int barValue;
    private final int barMaxValue;
    private final Color color;
}
