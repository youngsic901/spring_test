package pack.model;

public class SangpumImpl implements SangpumInter {
    @Override
    public int calcMoney(int quantity, int price) {
        return quantity * price;
    }
}
