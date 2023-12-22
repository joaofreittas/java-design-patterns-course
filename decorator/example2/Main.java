package decorator.example2;

public class Main {

    public static void main(String[] args) {
        var sumNumbers = new SumNumbers();
        var sumAndSubtractNumbers = new SumAndSubtractNumbers(sumNumbers);
        var sumAndSubtractAndMultiplyNumbers = new SumAndSubtractAndMultiplyNumbers(sumAndSubtractNumbers);


        sumAndSubtractAndMultiplyNumbers.calculate(1, 2);
    }
}


interface CalculateNumbers {
    void calculate(int x, int y);
}

final class SumNumbers implements CalculateNumbers {

    public void calculate(int x, int y) {
        System.out.println("somando " + x + " + " + y + " = " + (x + y));
    }
}

class SumAndSubtractNumbers implements CalculateNumbers {

    private CalculateNumbers calculateNumbers;

    public SumAndSubtractNumbers(final CalculateNumbers calculateNumbers) {
        this.calculateNumbers = calculateNumbers;
    }

    public void calculate(int x, int y) {
        calculateNumbers.calculate(x, y);
        System.out.println("subtraindo " + x + " - " + y + " = " + (x - y));
    }
}

class SumAndSubtractAndMultiplyNumbers implements CalculateNumbers {

    private CalculateNumbers calculateNumbers;

    public SumAndSubtractAndMultiplyNumbers(final CalculateNumbers calculateNumbers) {
        this.calculateNumbers = calculateNumbers;
    }

    public void calculate(int x, int y) {
        calculateNumbers.calculate(x, y);
        System.out.println("multiplicando " + x + " * " + y + " = " + (x * y));
    }
}