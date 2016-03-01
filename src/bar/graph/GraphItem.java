package bar.graph;

import java.awt.Color;

public interface GraphItem {
    int getValue();
    void setValue(int value);
    int getMaxValue();
    void setMaxValue(int maxValue);
    int getValuePercentage();
    Color getColor();
    void setColor(Color color);
    @Override
    String toString();
}
