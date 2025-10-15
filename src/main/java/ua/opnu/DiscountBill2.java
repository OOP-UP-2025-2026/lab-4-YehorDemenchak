package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private GroceryBill bill;

    private boolean regularCustomer;
    private double discountAmount;
    private int discountCount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item i) {
        bill.add(i);
        if (regularCustomer && i.getDiscount() != 0) {
            discountAmount += i.getDiscount();
            discountCount++;
        }
    }

    public double getTotal() {
        return bill.getTotal() - discountAmount;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public int getDiscountCount() {
        if (!regularCustomer) {
            return 0;
        }
        return discountCount;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) {
            return 0;
        }
        return discountAmount;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) {
            return 0;
        }
        if (bill.getTotal() == 0) {
            throw new IllegalArgumentException("You can't divide by zero: the bill is empty");
        }
        return (discountAmount / bill.getTotal()) * 100;
    }
}