package bar.graph;

public class ColorRGB implements Item{
    
    public ColorRGB(ColorName name, int intensity){
        this.name = name;
        setIntensity(intensity);
    }

    @Override
    public int getValue() {
        return intensity;
    }
    
    @Override
    public String toString(){
        return name.toString();
    }
    
    final public void setIntensity(int intensity){
        if(intensity > 100)
            this.intensity = 100;
        else if(intensity < 0)
            this.intensity = 0;
        else
            this.intensity = intensity;
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
    
    int intensity;
    ColorName name;
}
