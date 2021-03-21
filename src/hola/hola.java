package hola;

import java.util.Scanner;

public class hola {

	static Scanner Leer = new Scanner(System.in);

	public static void main(String[] args) {

		String menu;

		Ong ong = new Ong();
		do {
			System.out.println("*****************************************");
			System.out.println("   Bienvenidos a la gestión de la ONG");
			System.out.println("*****************************************");
			System.out.println("");
			System.out.println("1.Agregar empleado ");
			System.out.println("2. Imprimir empleado ");

			menu = Leer.nextLine();
			switch (menu) {

			case "1":

				ong.AgregarEmpleado();

				break;
			case "2":

				ong.imprimirEmpleados();
				break;

			case "10":
				main(null);
				break;
			}

		} while (menu != "10");
	}

}