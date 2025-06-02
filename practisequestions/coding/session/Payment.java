package practisequestions.coding.session;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class TransactionSummary {
    int transactionId;
    boolean isSenderEligibleForReward;

    public TransactionSummary(int transactionId, boolean isSenderEligibleForReward) {
        this.transactionId = transactionId;
        this.isSenderEligibleForReward = isSenderEligibleForReward;
    }
}

enum TransactionType {
    P2M, P2P, Self
}

class PaymentHistory {
    int transactionId;
    int senderId;
    int amount;
    int aggregatedAmount;
    TransactionType transactionType;

    public PaymentHistory(int transactionId, int senderId, int amount, int aggregatedAmount, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.amount = amount;
        this.aggregatedAmount = aggregatedAmount;
        this.transactionType = transactionType;
    }

    public int getAggregatedAmount() {
        return aggregatedAmount;
    }
}

class Payment {
    List<PaymentHistory> paymentHistoryList = new ArrayList<>();

    public Payment() {
    }

    TransactionSummary makePayment(int transactionId,
                                   int senderId,
                                   int amount,
                                   TransactionType transactionType) {

        Optional<PaymentHistory> paymentDetails = paymentHistoryList.stream()
                .filter(data -> data.senderId == senderId)
                .sorted(Comparator.comparing(PaymentHistory::getAggregatedAmount).reversed())
                .findFirst();

        int aggregatedAmount = paymentDetails.map(history -> history.aggregatedAmount + amount).orElse(amount);

        PaymentHistory paymentHistory = new PaymentHistory(transactionId, senderId, amount, aggregatedAmount, transactionType);

        paymentHistoryList.add(paymentHistory);

        boolean isSenderEligibleForReward;

        isSenderEligibleForReward = transactionType.name().equals("P2M") && findIsEligibleForReward(aggregatedAmount);

        return new TransactionSummary(transactionId, isSenderEligibleForReward);
    }

    int getNumberOfTransactions(int senderId, TransactionType transactionType) {
        return (int) paymentHistoryList.stream().filter(data -> data.senderId == senderId).count();
    }

    boolean findIsEligibleForReward(int aggregatedAmount) {
        Optional<Integer> first = paymentHistoryList.stream()
                .map(data -> data.aggregatedAmount)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .filter(data -> data <= aggregatedAmount)
                .findFirst();

        return first.isPresent();
    }

    int getTotalAggregatedAmountBasedOnTransactionType(int senderId, TransactionType transactionType) {
        return paymentHistoryList.stream().filter(data -> (data.senderId == senderId && transactionType.name().equals("P2M")))
                .map(data -> data.aggregatedAmount)
                .reduce(0, Integer::sum);
    }

}


class UserTransactionHandler {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());
        Payment payment = new Payment();

        String arr[];

        while (totalNumberOfRequests-- > 0) {
            arr = br.readLine().split(" ");
            int transactionId, senderId, amount, res;
            TransactionType transactionType;
            switch (arr[0]) {
                case "makePayment":
                    transactionId = Integer.parseInt(arr[1]);
                    senderId = Integer.parseInt(arr[2]);
                    amount = Integer.parseInt(arr[3]);
                    transactionType = TransactionType.valueOf(arr[4]);
                    TransactionSummary transactionSummary =
                            payment.makePayment(transactionId, senderId, amount, transactionType);
                    out.print(transactionSummary.transactionId + " " + transactionSummary.isSenderEligibleForReward + "\n");
                    break;
                case "getNumberOfTransactions":
                    senderId = Integer.parseInt(arr[1]);
                    transactionType = TransactionType.valueOf(arr[2]);
                    res = payment.getNumberOfTransactions(senderId, transactionType);
                    out.print(res + "\n");
                    break;
            }

        }
        out.flush();
        out.close();
        System.out.println();
    }
}
