package structural;

class Order {
    private double totalAmount;

    public Order(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

class RegularCustomer implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.1;
    }
}

class VipCustomer implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.2;
    }
}

class DiscountDecorator extends Order {
    DiscountStrategy discountStrategy;
    public DiscountDecorator(double totalAmount, DiscountStrategy discountStrategy) {
        super(totalAmount);
        this.discountStrategy = discountStrategy;
    }

    public double totalAmountApplyDiscount() {
        return getTotalAmount() - discountStrategy.applyDiscount(getTotalAmount());
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        DiscountDecorator discountDecorator = new DiscountDecorator(1000, new VipCustomer());
        System.out.println("Total amount is: " + discountDecorator.totalAmountApplyDiscount());
    }
}
