package br.com.portfolio.classes;

public class GenericSquare {
    private Integer axi_X;
    private Integer axi_Y;

    public GenericSquare() {
    }

    public GenericSquare(Integer axi_X, Integer axi_Y) {
        setAxi_X(axi_X);
        setAxi_Y(axi_Y);
    }

    public Integer getAxi_X() {
        return axi_X;
    }

    public void setAxi_X(Integer axi_X) {
        this.axi_X = axi_X;
    }

    public Integer getAxi_Y() {
        return axi_Y;
    }

    public void setAxi_Y(Integer axi_Y) {
        this.axi_Y = axi_Y;
    }
}
