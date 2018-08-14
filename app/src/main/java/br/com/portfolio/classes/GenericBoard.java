package br.com.portfolio.classes;


import java.util.ArrayList;

public abstract class GenericBoard {
    private Integer axis_X;
    private Integer axis_Y;

    public GenericBoard() {
    }

    public GenericBoard(Integer axi_X, Integer axi_Y) {
        setAxis_X(axi_X);
        setAxis_Y(axi_Y);
    }

    public Integer getAxis_X() {
        return axis_X;
    }

    public void setAxis_X(Integer axis_X) {
        this.axis_X = axis_X;
    }

    public Integer getAxis_Y() {
        return axis_Y;
    }

    public void setAxis_Y(Integer axis_Y) {
        this.axis_Y = axis_Y;
    }

    public abstract void initBoardInsertingSquare(Integer axis_X, Integer axis_Y);


}

