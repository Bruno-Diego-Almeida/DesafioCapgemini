import java.util.Scanner;	

public class Escadinha {

	public static void main(String[] args) {


			System.out.print("Informe quantos degraus terá a escada: ");
			Scanner sc = new Scanner(System.in);
			int quantidadeDegraus = sc.nextInt();

			int quantidadeEspaco = 0;
			for (int i = 0; i < quantidadeDegraus; i++) {

				quantidadeEspaco = quantidadeDegraus - (i + 1);

				// Imprime a quantidade de espaços antes do '*' para posiciona-lo a diretira da
				// tela
				for (int j = 0; j < quantidadeEspaco; j++) {
					System.out.print(" ");
				}

				for (int j = 0; j < quantidadeDegraus - quantidadeEspaco; j++) {
					System.out.print("*");
				}

				System.out.println();

				quantidadeEspaco = 0;
			}
		}

	}