package ru.appline.Logic;

public class SideRange {
    private String side;
    private int rangeStart;
    private int rangeEnd;


    public SideRange(String side, int rangeStart, int rangeEnd) {
        this.side = side;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }
}
