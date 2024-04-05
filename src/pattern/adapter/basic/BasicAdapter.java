package pattern.adapter.basic;

import pattern.adapter.simple.Rectangle;

public class BasicAdapter implements BasicTarget {

    private BasicAdaptee basicAdaptee;

    public BasicAdapter(BasicAdaptee basicAdaptee) {
        this.basicAdaptee = basicAdaptee;
    }

    @Override
    public int getNumber() {
        return basicAdaptee.getA() + basicAdaptee.getB();
    }
}
