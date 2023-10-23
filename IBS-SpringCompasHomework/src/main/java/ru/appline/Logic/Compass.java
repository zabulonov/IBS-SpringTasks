package ru.appline.Logic;

public class Compass {

    private SideRange[] sideRanges = new SideRange[8];

    public Compass()
    {
        super();
    }

    public Compass(SideRange[] sideRanges)
    {
        this.sideRanges = sideRanges;
    }

    public String Side(int a)
    {
        for (SideRange sideRange : sideRanges)
            if(a<=sideRange.getRangeEnd() && a>= sideRange.getRangeStart())
                return sideRange.getSide();
        return "Side do not exist";
    }

}
