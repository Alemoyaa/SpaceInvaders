
package Main;

public class Monster extends Actor{
    
    protected int vx;
    
    public Monster(Stage stage){
        super(stage);
        setSpriteName("bicho.gif");
    }
    
    @Override
    public void act(){
        x += vx;
        if (x<0 || x > Stage.WIDTH)
            vx = -vx;
    }
    
    public int getVx() { return vx;}
    public void setVx(int i) { this.vx = i;}
    
}
