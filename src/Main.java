import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате 'a операция b':");
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода. Правильный формат: 'a операция b'");
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        String operation = parts[1];

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10");
        }

        switch (operation) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("На ноль делить нельзя");
                }
                return String.valueOf(a / b);
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operation);
        }
    }
}