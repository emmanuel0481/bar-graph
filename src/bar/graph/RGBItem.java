package bar.graph;

import java.awt.Color;

public final class RGBItem implements GraphItem{
    
    public RGBItem(ColorName name, int value){
        this.name = name;
        maxValue = 255;
        setValue(value);
        setColor();
    }

    @Override
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return name.toString();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setValue(int value) {
        if(value < 0)
            this.value = 0;
        else if(value > maxValue)
            this.value = maxValue;
        else
            this.value = value;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public void setMaxValue(int maxValue) {
        if(maxValue < 0)
            this.maxValue = 0;
        this.maxValue = maxValue;
    }
    
    private void setColor(){
        if(name == ColorName.RED)
            color = Color.RED;
        else if(name == ColorName.GREEN)
            color = Color.GREEN;
        else
            color = Color.BLUE;
    }

    @Override
    public int getValuePercentage() {
        return value / maxValue * 100;
    }
    
    public enum ColorName{
        RED("RED"),
        GREEN("GREEN"),
        BLUE("BLUE");
        
        private ColorName(final String name){
            this.name = name;
        }
        
        @Override
        public String toString(){
            return name;
        }
        
        private final String name;
    }
    
    private int value;
    private int maxValue;
    private final ColorName name;
    private Color color;
}
