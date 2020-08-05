package Java_Level3.Lesson5;

public class Lambda {
    public static void main(String[] args) {
        Operationable operationSum;
        operationSum = (x, y) -> x + y;

        Operationable operationSub;
        operationSub = (x, y) -> x - y;

        Operationable operationMult;
        operationMult = (x, y) -> x * y;

        Operationable operationDiv;
        operationDiv = (x, y) -> x / y;

        int resultSum = operationSum.calculate(10,20);
        int resultSub = operationSub.calculate(20,10);
        int resultMult = operationMult.calculate(7,7);
        int resultDiv = operationDiv.calculate(20,5);

        System.out.println(resultSum);
        System.out.println(resultSub);
        System.out.println(resultMult);
        System.out.println(resultDiv);
    }
}

interface Operationable{
    int calculate(int x, int y);

}
