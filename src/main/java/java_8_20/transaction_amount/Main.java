package java_8_20.transaction_amount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    int customerId;
    double amount;

    // Constructor
    public Transaction(int customerId, double amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }
}
public class Main {
    public static void main(String[] args) {
        // Sample data
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 100.0),
                new Transaction(2, 150.0),
                new Transaction(1, 200.0),
                new Transaction(3, 50.0),
                new Transaction(2, 300.0),
                new Transaction(3, 400.0),
                new Transaction(2, 50.0)
        );

        Map<Integer, Double> map = transactions.stream().collect(Collectors.groupingBy(
                transaction -> transaction.getCustomerId(),
                Collectors.summingDouble(Transaction::getAmount)
        ));

        System.out.println(map);

        Map.Entry<Integer, Double> customerWithHighestTransaction = map.entrySet().stream().max(Comparator.comparingDouble(e -> e.getValue())).get();

        System.out.println(customerWithHighestTransaction.getKey()+":"+customerWithHighestTransaction.getValue());
    }
}
//Given a list of Transaction objects, find the customerId that has the highest total transaction amount. Print the customerId and the total amount spent.