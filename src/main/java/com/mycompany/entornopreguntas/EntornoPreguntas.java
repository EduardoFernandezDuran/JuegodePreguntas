/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.entornopreguntas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class EntornoPreguntas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Preguntas y respuestas
        String[] preguntas = {
            "¿Cuál es la capital de Francia?",
            "¿En qué año se fundó la ONU?",
            "¿Quién escribió 'Cien años de soledad'?",
            "¿Cuál es el río más largo del mundo?",
            "¿Cuántos continentes hay en el mundo?"
        };

        String[] respuestas = {
            "parís",
            "1945",
            "gabriel garcía márquez",
            "amazonas",
            "7"
        };

        // Barajamos las preguntas
        int[] indicesPreguntas = barajarPreguntas(preguntas.length, random);

        // Iniciar el juego
        System.out.println("¡Bienvenido al juego de cultura general!");
        System.out.println("Responde correctamente a 5 preguntas.");

        int puntaje = 0;
        int preguntasTotales = 5;

        for (int i = 0; i < preguntasTotales; i++) {
            int indice = indicesPreguntas[i];
            System.out.println("\nPregunta " + (i + 1) + ": " + preguntas[indice]);
            System.out.print("Respuesta: ");
            String respuestaUsuario = scanner.nextLine().toLowerCase();

            if (respuestaUsuario.equalsIgnoreCase(respuestas[indice])) {
                System.out.println("¡Correcto!");
                puntaje++;
            } else {
                System.out.println("Respuesta incorrecta. La respuesta correcta es: " + respuestas[indice]);
            }
        }

        // Mostrar resultados
        System.out.println("\n¡Juego terminado!");
        System.out.println("Puntaje final: " + puntaje + "/" + preguntasTotales);

        scanner.close();
    }

    // Método para barajar las preguntas
    private static int[] barajarPreguntas(int length, Random random) {
        int[] indices = new int[length];
        for (int i = 0; i < length; i++) {
            indices[i] = i;
        }

        for (int i = length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap
            int temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
        }

        return indices;
    }
}

