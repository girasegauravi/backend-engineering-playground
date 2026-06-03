package com.javaruntime.streams.streamsexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum TransactionType {

    UPI,
    CREDIT_CARD,
    DEBIT_CARD,
    NET_BANKING
}

class Transaction {

    private String transactionId;
    private double amount;
    private TransactionType transactionType;

    public Transaction(
            String transactionId,
            double amount,
            TransactionType transactionType
    ) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return transactionId;
    }

    @Override
    public String toString() {

        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}

public class Main {
    /*
    Method creates and returns transactions
*/
    public static List<Transaction> getAllTransactions() {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("TXN101", 500, TransactionType.UPI));
        transactions.add(new Transaction("TXN102", 8500, TransactionType.CREDIT_CARD));
        transactions.add(new Transaction("TXN103", 1200, TransactionType.DEBIT_CARD));
        transactions.add(new Transaction("TXN104", 15000, TransactionType.NET_BANKING));
        transactions.add(new Transaction("TXN105", 7000, TransactionType.UPI));
        return transactions;
    }

    public static void main(String[] args) {
        List<Transaction> allTransactions = getAllTransactions();

        //Imperative way we are telling it how to do
        List<Transaction> upiTransactions = new ArrayList<>();

        for (Transaction transaction : allTransactions) {
            if (transaction.getTransactionType() == TransactionType.UPI) {
                upiTransactions.add(transaction);
            }
        }

        Collections.sort(
                upiTransactions,
                (t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount())
        );

        System.out.println("UPI Transactions sorted by amount DESC:");
        for (Transaction transaction : upiTransactions) {
            System.out.println(transaction);
        }

        //Streams declarative we are telling it what to do
        List<String> sortedUPTTransaction = getAllTransactions().stream()
                .filter(transaction -> transaction.getTransactionType() == TransactionType.UPI)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getId)
                .toList();
        System.out.println("Sorted using stream:");
        System.out.println(sortedUPTTransaction);
    }
}
