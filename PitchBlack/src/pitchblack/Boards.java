/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitchblack;
import java.util.List;

/**
 *
 * @author QMOtt
 */
abstract class Boards implements Floors {

    List[][] board;

    @Override
    public List[][] getBoard() {
        return board;
    }

    abstract public void addTraps();
}
