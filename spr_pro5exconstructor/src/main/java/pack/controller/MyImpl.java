package pack.controller;

import pack.model.SangpumInter;

import java.util.Scanner;

public class MyImpl implements MyInter {
    private String product;
    private SangpumInter sangpumInter;

    public MyImpl(SangpumInter sangpumInter) {
        this.sangpumInter = sangpumInter;
    }

    @Override
    public void inputData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("상품명 : ");
            product = scanner.next();
            System.out.print("수량 : ");
            sangpumInter.setQuantity(scanner.nextInt());
            System.out.print("단가 : ");
            sangpumInter.setPrice(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("MyImpl err : " + e);
        }
    }

    @Override
    public void showResult() {
        System.out.println("상품 " + product + " : 금액은 " + sangpumInter.calcMoney() + "원 입니다.");
    }
}
