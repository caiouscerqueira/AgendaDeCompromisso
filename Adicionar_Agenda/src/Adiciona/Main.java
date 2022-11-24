package Adiciona;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		int dia = 0;
		int mes = 0;
		int ano = 0;
		boolean sai = false;
		boolean ano_bissexto = false;
		byte identifica_dia_mes = 0; // 0 = mes com 31 dias; 1 = mes com 30 dias; 2 = fevereiro (28 ou 29 dias)
	
		
		System.out.print("Digite um nome: ");
		Scanner nome_scan = new Scanner(System.in);
		String nome = nome_scan.nextLine();
		
		Agenda c = new Agenda(nome);
		
		while(sai == false) {
			System.out.print("Indique um ano: ");
			Scanner ano_scan = new Scanner(System.in);
			try {
				ano = ano_scan.nextInt();
				if(ano % 4 == 0) {
					ano_bissexto = true;
				}
				sai = true;
			}catch (InputMismatchException e){
				System.out.println("Erro: Você deve inserir um número!");
			}
		}
		
		sai = false;
		while(sai == false) {
			System.out.println("Janeiro = 0; Fevereiro = 1; Março = 2; Abril = 3; Maio = 4; Junho = 5; Julho = 6; Agosto = 7; Setembro = 8; Outubro = 9; Novembro = 10; Dezembro = 11");
			System.out.print("Indique um mês: ");
			
			Scanner mes_scan = new Scanner(System.in);
			try {
				mes = mes_scan.nextInt();
				if(mes >= 0 && mes <= 11) {
					// meses com 31 dias
					if(mes == 0 || mes == 2 || mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11) {
						identifica_dia_mes = 0;
						sai = true;
					// meses com 30 dias	
					}else if(mes == 3 || mes == 5 || mes == 8 || mes == 10) {
						identifica_dia_mes = 1;
						sai = true;
					// Fevereiro (28 ou 29 dias)
					}else if(mes == 1) {
						identifica_dia_mes = 2;
						sai = true;
					}
				}else {
					System.out.println("Erro: O mês está entre 0 e 11!");
				}
			}catch (InputMismatchException e){
				System.out.println("Erro: Você deve inserir um número!");
			}
		}
		
		sai = false;
		while(sai == false) {
			System.out.print("Indique um dia: " );
			Scanner dia_scan = new Scanner(System.in);
			try {
				dia = dia_scan.nextInt();
				if(identifica_dia_mes == 0) { // 31 dias
					if(dia >= 1 && dia <= 31){
						sai = true;
					}else{
						System.out.println("Erro: O dia está entre 1 e 31");
					}
				}else if(identifica_dia_mes == 1) { // 30 dias
					 if(dia >= 1 && dia <= 30){
						 sai = true;
					 }else{
						 System.out.println("Erro: O dia está entre 1 e 30");
					 }
				}else if (identifica_dia_mes == 2 && ano_bissexto == false) { // 28 dias
					if(dia >= 1 && dia <= 28){
						sai = true;
					}else{
						System.out.println("Erro: O dia está entre 1 e 28");
					}
				}else if (identifica_dia_mes == 2 && ano_bissexto == true) { // 29 dias
					if(dia >= 1 && dia <= 29){
						sai = true;
					}else{
						System.out.println("Erro: O dia está entre 1 e 29");
					}
				}
			}catch (InputMismatchException e){
				System.out.println("Erro: Você deve inserir um número!");
			}
		}

		System.out.print("Escreva uma descrição: ");
		Scanner desc_scan = new Scanner(System.in);
		String descricao = desc_scan.nextLine();
		
		c.adicionar(ano,mes,dia,descricao);
		c.exibeCalendario();
		
	}
}