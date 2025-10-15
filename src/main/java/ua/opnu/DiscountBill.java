package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends ua.opnu.java.inheritance.bill.GroceryBill {
    private boolean regularCustomer;
    private double discountAmount;
    private int discountCount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() != 0) {
            discountAmount += i.getDiscount();
            discountCount++;
        }
    }

    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

    public int getDiscountCount() {
        if (!regularCustomer){
            return 0;
        }
        return discountCount;
    }

    public double getDiscountAmount() {
        if (!regularCustomer){
            return 0;
        }
        return discountAmount;
    }

    public double getDiscountPercent() {
        if (!regularCustomer){
            return 0;
        }
        if(super.getTotal()==0){
            throw new IllegalArgumentException("You can't divide by zero: the bill is empty");
        }
        return (discountAmount / super.getTotal()) * 100;
    }
}
