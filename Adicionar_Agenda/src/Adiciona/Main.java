package Adiciona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Calendar;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		int dia = 0;
		int mes = 0;
		int ano = 0;
		
		Agenda c = new Agenda("Pedro");
		
		System.out.print("Indique um dia: ");
		Scanner dia_scan = new Scanner(System.in);
		try {
			dia = dia_scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Erro: Você deve inserir um número!");
		}
		System.out.print("Indique um mês: ");
		Scanner mes_scan = new Scanner(System.in);
		try {
			mes = mes_scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Erro: Você deve inserir um número!");
		}
		System.out.print("Indique um ano: ");
		Scanner ano_scan = new Scanner(System.in);
		try {
			ano = ano_scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Erro: Você deve inserir um número!");
		}
		c.adicionar(ano,mes,dia,"Copa do mundo 2022");
		System.out.println(c.getCalendario());
		System.out.println(c.getNome());
		System.out.println(c.getDescricao());
		
	}
}
