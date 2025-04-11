package pack.controller;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyProcess implements MyInter{
	private MoneyInter moneyInter;
	private int re[];
	
	public MyProcess(MoneyInter moneyInter) {
		this.moneyInter = moneyInter;
	}
	
	@Override
	public void inputMoney() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.print("금액 입력 : ");
			int myMoney = scanner.nextInt();
			re = moneyInter.calcMoney(myMoney);
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e);
		} finally {
			if(scanner != null) scanner.close();
		}
	}
	
	@Override
	public void showMoney() {
		StringBuffer sb = new StringBuffer();
		sb.append("만원:" + re[0] + "\n");
		sb.append("천원:" + re[1] + "\n");
		sb.append("백원:" + re[2] + "\n");
		sb.append("십원:" + re[3] + "\n");
		sb.append("일원:" + re[4] + "\n");
		System.out.println(sb.toString());
	}
}
