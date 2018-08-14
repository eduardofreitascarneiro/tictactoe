package br.com.portfolio.classes;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class TicTacToeBoard extends GenericBoard implements Serializable{

    private ArrayList<SquareTicTacToe> squareList;

    public ArrayList<SquareTicTacToe> getSquareList() {
        return squareList;
    }

    public void setSquareList(ArrayList<SquareTicTacToe> squareList) {
        this.squareList = squareList;
    }

    public TicTacToeBoard() {
    }

    public TicTacToeBoard(Integer axis_X, Integer axis_Y) {
        super(axis_X,axis_Y);
        squareList = new ArrayList<>();
        initBoardInsertingSquare(axis_X,axis_Y);
    }

    @Override
    public void initBoardInsertingSquare(Integer axis_X, Integer axis_Y) {
        int index = 0;
        for (Integer x = 0; x < axis_X; x++ ){
            for (Integer y = 0; y < axis_Y; y++ ){
                SquareTicTacToe square = new SquareTicTacToe(x, y, new String(""));
                squareList.add(square);
                Log.i("Lista: ",   "Eixo X"+squareList.get(index).getAxis_x()  +" Eixo Y"+squareList.get(index).getAxis_y()+ " Valor: "+squareList.get(index).getValue());
                index++;
            }
        }
    }



}
