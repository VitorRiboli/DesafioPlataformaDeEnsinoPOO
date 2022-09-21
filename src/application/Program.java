package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> lesson = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int N = sc.nextInt();
		
		System.out.println();
		for(int i = 0; i < N; i++) {
			System.out.println("Dados da " + (i+1) + "a aula:");
			System.out.print("Conteúdo ou tarefa (C/T)? ");
			char ct = sc.next().charAt(0);
			while (ct != 'C' && ct != 'c' && ct != 'T' && ct != 't') {
				System.out.println("Valor inválido! Tente de Novo");
				ct = sc.next().charAt(0);
			}
			if(ct == 'C' || ct == 'c') {
				System.out.print("Título: ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("URL do vídeo: ");
				String urlVideo = sc.nextLine();
				System.out.print("Duração: ");
				int duration = sc.nextInt();
				
				lesson.add(new Video(title, urlVideo, duration));
			}
			else {
				System.out.print("Título: ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int quantity = sc.nextInt();
				
				lesson.add(new Task(title, description, quantity));
			}		
			System.out.println();
		} 
		
		System.out.println();
		int sum = 0;
		for(Lesson list : lesson) {
			sum += list.duration();
		}
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");
	
		sc.close();

	}

}
