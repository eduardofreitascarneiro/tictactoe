package br.com.portfolio.classes;

import br.com.portfolio.interfaces.SquareInterface;


public class SquareTicTacToe implements SquareInterface {
//public class SquareTicTacToe extends GenericSquare implements SquareInterface {

    //A especialização do tabuleiro do jodo da velha
    private String value;
    private Integer axis_x;
    private Integer axis_y;

    public Integer getAxis_x() {
        return axis_x;
    }

    public void setAxis_x(Integer axis_x) {
        this.axis_x = axis_x;
    }

    public Integer getAxis_y() {
        return axis_y;
    }

    public void setAxis_y(Integer axis_y) {
        this.axis_y = axis_y;
    }

    public SquareTicTacToe() {
    }

    public SquareTicTacToe(Integer axi_X, Integer axi_Y, String value) {
        setValue(value);
        setAxis_x(axi_X);
        setAxis_y(axi_Y);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("IMPRIMINDO JOGO DA VELHA");
    }
}
