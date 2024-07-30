public class FinancialForecastTool {

    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base Case: if periods are 0, return the current value
        if (periods == 0) {
            return currentValue;
        }

        // Recursive Case: calculate the value for one period and recurse
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static double calculateFutureValueIterative(double currentValue, double growthRate, int periods) {
        double futureValue = currentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double initialValue = 1000; // Example initial value
        double growthRate = 0.05; // Example growth rate (5%)
        int periods = 10; // Number of periods

        double futureValueRecursive = calculateFutureValue(initialValue, growthRate, periods);
        double futureValueIterative = calculateFutureValueIterative(initialValue, growthRate, periods);

        System.out.println("Future Value (Recursive): " + futureValueRecursive);
        System.out.println("Future Value (Iterative): " + futureValueIterative);
    }
}
