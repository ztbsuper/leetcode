package coach.merchant;

/**
 * Created by Marvin on 16/5/17.
 */
public class Good {
    private GoodType goodType;

    public Good(GoodType goodType) {
        this.goodType = goodType;
    }

    public GoodType getGoodType() {
        return goodType;
    }
}
