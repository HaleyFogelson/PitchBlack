/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitchblack;

import java.util.ArrayList;
import java.util.List;

public class PitchBlack implements Floors {
    
    List[][]Board;
    Floors currentFloor;
    FloorOne stateOne;
    FloorTwo stateTwo;
    FloorThree stateThree;

    public PitchBlack() {
        stateOne = new FloorOne();
        stateTwo = new FloorTwo(stateOne.getBoard());
        stateThree = new FloorThree(stateTwo.getBoard());
        currentFloor = stateOne;
        Board = currentFloor.getBoard();
    }

    class FloorOne extends Boards {

        List[][] board;

        public FloorOne() {
            board = new List[9][9];
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    board[y][x] = new ArrayList();
                }
            }
            addTraps();
        }

        @Override
        public void addTraps() {
            int traps = 1;
            while (traps <= 25) {
                int y = (int) (Math.random() * 9);
                int x = (int) (Math.random() * 9);
                if (traps <= 24) {
                    if (Math.random() <= .50) {
                        board[y][x].add(new Slowness());
                    }
                    board[y][x].add(new Speed());
                } else {
                    board[y][x].add(new InverrtSpeech());
                }
                traps++;
            }
        }
    }

    class FloorTwo extends Boards {

        List[][] board;

        public FloorTwo(List[][] board) {
            this.board = board;
            addTraps();
        }

        @Override
        public void addTraps() {
            int traps = 1;
            while (traps <= 25) {
                int y = (int) (Math.random() * 9);
                int x = (int) (Math.random() * 9);
                if (traps <= 24) {
                    board[y][x].add(new Teleport());
                }
                board[y][x].add(new ShowBoard());
            }
        }
    }

    class FloorThree extends Boards {

        List[][] board;

        public FloorThree(List[][] board) {
            this.board = board;
            addTraps();
        }

        @Override
        public void addTraps() {
            int traps = 1;
            while (traps <= 25) {
                int y = (int) (Math.random() * 9);
                int x = (int) (Math.random() * 9);
                if (Math.random() <= .50) {
                    board[y][x].add(new Teleport());
                } else {
                    if (Math.random() <= .50) {
                        board[y][x].add(new Slowness());
                    }
                    board[y][x].add(new Speed());
                }
                traps++;
            }
        }
    }
    @Override
    public List[][] getBoard() {
        return currentFloor.getBoard();
    }
}
