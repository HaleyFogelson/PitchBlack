/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitchblack;

/**
 *
 * @author PicklEllie
 */
public class Player {
    private int x, y;
    private int speed;
    public Player(){
        
    }
    public void moveUp(){
        if (y>0)
            y=y-speed;
        
    }
    public void moveDown(){
        if (y<800)
            y=y+speed;
        
    }
    public void moveLeft(){
        if (x>0)
            x=x-speed;
        
        
    }
    public void moveRight(){
        if (x<800)
            x=x+speed;
        
        
    }
}
