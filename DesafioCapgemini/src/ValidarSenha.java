import java.util.Scanner;

public class ValidarSenha {

	public static void main(String[] args) {

		System.out.print("Informe a senha: ");
		Scanner sc = new Scanner(System.in);
		String senha = sc.next();

		char[] caracteresEspeciais = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' };

		boolean senhaOk = true;

		int tamanhoSenha = senha.length();

		String padraoSenha = "";

		if (tamanhoSenha < 6) {
			senhaOk = false;
		}

		boolean achouNumero = false;
		boolean achouMaiuscula = false;
		boolean achouMinuscula = false;
		boolean achouSimbolo = false;
		for (char c : senha.toCharArray()) {
			if (c >= '0' && c <= '9') {
				achouNumero = true;
				senhaOk = true;
			} else if (c >= 'A' && c <= 'Z') {
				achouMaiuscula = true;
				senhaOk = true;
			} else if (c >= 'a' && c <= 'z') {
				achouMinuscula = true;
				senhaOk = true;
			} else {

				// Procura no array de caracteres especiais se acha
				for (int i = 0; i < caracteresEspeciais.length; i++) {
					if (achouSimbolo == false) {
						if (caracteresEspeciais[i] == c) {
							achouSimbolo = true;
							senhaOk = true;
						}
					}
				}

			}
		}

		// Valida se o padr�o de senha ta ok
		if (achouNumero == false) {
			padraoSenha += "9";
			senhaOk = false;
		}
		if (achouMaiuscula == false) {
			padraoSenha += "Y";
			senhaOk = false;
		}
		if (achouMinuscula == false) {
			padraoSenha += "b";
			senhaOk = false;
		}
		if (achouSimbolo == false) {
			padraoSenha += "#";
			senhaOk = false;
		}
		// Se a senha for por exemplo Ya3, vai faltar um caracter especial
		//  ainda  3 caracteres para completar o minimo de 6, ent�o
		// aqui �
		// concatenado um caracter especial e mais duas letras 'a' ao final, seguindo esse exemplo
		if (tamanhoSenha < 6) {
			for (int j = 0; j < (5 - padraoSenha.length()); j++) {
				padraoSenha += "a";
			}
			senhaOk = false;
		}

		System.out.println();

		if (senhaOk) {
			System.out.println("Senha cadastrada com sucesso :-)");
		} else {			
			System.out.println("Sua senha (" + senha + ") n�o atende aos requisitos");
			System.out.println("Voc� pode tornar a senha segura adicionando " + (6 - tamanhoSenha)
					+ " caracteres, por exemplo: " + senha + padraoSenha);

			System.out.println();

			System.out
					.println("###############    Sua senha tem que seguir o padr�o abaixo    #######################");
			System.out.println("� Possui no m�nimo 6 caracteres.");
			System.out.println("� Cont�m no m�nimo 1 digito.");
			System.out.println("� Cont�m no m�nimo 1 letra em min�sculo.");
			System.out.println("� Cont�m no m�nimo 1 letra em mai�sculo.");
			System.out.println("� Cont�m no m�nimo 1 caractere especial. Os caracteres especiais s�o: !@#$%^&*()-+");
			System.out
					.println("######################################################################################");
		}

	}

}