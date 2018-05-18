package java180518;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("1.����  2.��ȸ  3.���� 4.����");
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.print("���� : ");
			int age = sc.nextInt();
			System.out.print("��ȭ��ȣ : ");
			String tel = sc.next();
			System.out.print("����ȣ : ");
			String memNum = sc.next();

			Member mem = new Member(name, age, tel, memNum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);

		} else if (choice == 2) {

			System.out.print("����ȣ : ");
			String memNum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(memNum);
			System.out.println("�̸�/����/��ȭ��ȣ/����ȣ");
			System.out.println(m.getName() + "/" + m.getAge() + "/" + m.getTel() + "/" + m.getMemnum());

		} else if (choice == 3) {
			System.out.println("����ȣ : ");
			String memNum = sc.next();
			MemberDAO dao = new MemberDAO();
			System.out.println("������ ������ �����ּ���.");
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.print("���� : ");
			int age = sc.nextInt();
			System.out.print("��ȭ��ȣ : ");
			String tel = sc.next();
			System.out.print("����ȣ : ");
			String memnum = sc.next();

			Member m = dao.MemberUpdate(name, age, tel, memnum);

		} else if (choice == 4) {

			System.out.println("����ȣ : ");
			String memNum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.MemberDelete(memNum);

			

		}

	}
}
