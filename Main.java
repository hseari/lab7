package com.company;

import java.util.*;

class Fraction {
    private int num;
    private int den;

    //первая дробь
    public Fraction(int num, int den) throws Exception {
        if (num < 0 || den <= 0) {
            throw new Exception("Некорректный параметр");
        } else {
            this.num = num;
            this.den = den;
        }
    }

    //вторая дробь
    public Fraction() {
        this.num = 1;
        this.den = 1;
    }

    //сумма
    public static String sum(int num, int den, int num2, int den2) {
        int n = num * den2 + num2 * den;
        int d = den * den2;
        int div = Just(n, d);
        n /= div;
        d /= div;
        return "Cумма: " + n + "/" + d;
    }


    //вычитание
    public static String diff(int num, int den, int num2, int den2) {
        int n = num * den2 - num2 * den;
        int d = den * den2;
        int div = Just(n, d);
        n /= div;
        d /= div;
        return "Разность: " + n + "/" + d;
    }

    //умножение
    public static String imp(int num, int den, int num2, int den2) {
        int n = num * num2;
        int d = den * den2;
        int div = Just(n, d);
        n /= div;
        d /= div;
        return "Умножение: " + n + "/" + d;
    }

    //деление
    public static String del(int num, int den, int num2, int den2) {
        int n = num * den2;
        int d = den * num2;
        int div = Just(n, d);
        n /= div;
        d /= div;
        return "Частное: " + n + "/" + d;
    }


    public String toString() {
        return num + "/" + den;
    }

    public static int Just(int a, int b) {
        do {
            if (a > b)
                a %= b;
            else b %= a;
        } while (a * b > 0);
        return a + b;
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первую дробь: ");
        int num = in.nextInt();
        int den = in.nextInt();

        System.out.print("Введите вторую дробь: ");
        int num2 = in.nextInt();
        int den2 = in.nextInt();

        try {
            Fraction f = new Fraction(num, den); //сложение
            System.out.println(f.sum(num, den, num2, den2));

            Fraction t = new Fraction(num, den); //вычитание
            System.out.println(t.diff(num, den, num2, den2));

            Fraction a = new Fraction(num, den); //умножение
            System.out.println(a.imp(num, den, num2, den2));

            Fraction b = new Fraction(num, den); //деление
            System.out.println(b.del(num, den, num2, den2));


        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
    }
}