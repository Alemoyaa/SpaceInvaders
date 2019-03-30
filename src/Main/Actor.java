/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Actor {
    protected int x,y;
    protected int width, height;
    protected String spriteName;
    protected Stage stage;
    protected SpriteCache spriteCache;
    
    public Actor(Stage stage){
        this.stage = stage;
        spriteCache = stage.getSpriteCache();
    }
    
    public void paint (Graphics2D g){
        g.drawImage(spriteCache.getSprite(spriteName), x,y, stage);
    }
    
    public int getX(){ return x; }
    public void setX(int i){ x=i; }
    
    public int getY(){ return y; }
    public void setY(int i){ y=i; }
    
    public String getSpriteName() { return spriteName; }
    public void setSpriteName(String string){
        spriteName = string;
        BufferedImage image = spriteCache.getSprite(spriteName);
        height = image.getHeight();
        width = image.getWidth();
    }
    
    public int getHeight() { return height; }
    public int getWidth()  { return width; }
    
    public void setHeight(int i) { this.height = i; }
    public void setWidth(int i)  { this.width  = i; }
    
    public void act(){}
}
