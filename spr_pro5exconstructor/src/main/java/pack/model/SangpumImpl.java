package pack.model;

public class SangpumImpl implements SangpumInter {
    private int price, quantity;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int calcMoney() {
        return quantity * price;
    }
}
