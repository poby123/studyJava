package threads;

import java.math.BigDecimal;

class Account {
    private BigDecimal balance;

    public Account() {
        this(0);
    }

    public Account(int b) {
        this.balance = new BigDecimal(b);
    }

    public BigDecimal withdraw(BigDecimal target) {
        if (balance.compareTo(target) > 0) {
            balance = balance.subtract(target);
            System.out.println("After withdraw " + target + " \t/\t balance : " + balance);
            return target;
        }
        return new BigDecimal(0);
    }

    public boolean deposit(BigDecimal input) {
        if (input.compareTo(new BigDecimal(0)) >= 0) {
            balance = balance.add(input);
            System.out.println("After deposit " + input + " \t/\t balance : " + balance);
            return true;
        }
        return false;
    }
}