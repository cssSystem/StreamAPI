public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2); // -> 3
        int b = calc.minus.apply(1, 1); // -> 0
        int c = calc.devide.apply(a, b);    //На ноль делить нельзя, решение в классе Calculator
        //решение : проверка что неравен нулю, иначе 0

        calc.println.accept(c);
    }
}