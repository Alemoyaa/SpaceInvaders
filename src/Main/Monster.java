
package Main;

public class Monster extends Actor{
    
    protected int vx;
    
    public Monster(Stage stage){
        super(stage);
        setSpriteNames(new String[] {"bicho0.gif","bicho1.gif"});
        
        setFrameSpeed(35);// utilizar la misma variable para hacer otros cálculos basados en la base de tiempos común
    }
    
    @Override
    public void act(){
        super.act();
        
        x += vx;
        if (x<0 || x > Stage.WIDTH)
            vx = -vx;
    }
    
    public int getVx() { return vx;}
    public void setVx(int i) { this.vx = i;}
    
    public void collision(Actor a){
        if(a instanceof Bullet || a instanceof Bomb)
        remove();
    }
}
