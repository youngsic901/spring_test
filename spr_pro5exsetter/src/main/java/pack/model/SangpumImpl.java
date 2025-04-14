package pack.model;

public class SangpumImpl implements SangpumInter {
    private int quantity, price;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int calcMoney() {
        return quantity * price;
    }
}
