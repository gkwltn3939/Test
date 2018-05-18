package java180518;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("1.가입  2.조회  3.수정 4.삭제");
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("전화번호 : ");
			String tel = sc.next();
			System.out.print("고객번호 : ");
			String memNum = sc.next();

			Member mem = new Member(name, age, tel, memNum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);

		} else if (choice == 2) {

			System.out.print("고객번호 : ");
			String memNum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(memNum);
			System.out.println("이름/나이/전화번호/고객번호");
			System.out.println(m.getName() + "/" + m.getAge() + "/" + m.getTel() + "/" + m.getMemnum());

		} else if (choice == 3) {
			System.out.println("고객번호 : ");
			String memNum = sc.next();
			MemberDAO dao = new MemberDAO();
			System.out.println("수정할 내용을 적어주세요.");
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("전화번호 : ");
			String tel = sc.next();
			System.out.print("고객번호 : ");
			String memnum = sc.next();

			Member m = dao.MemberUpdate(name, age, tel, memnum);

		} else if (choice == 4) {

			System.out.println("고객번호 : ");
			String memNum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.MemberDelete(memNum);

			

		}

	}
}
