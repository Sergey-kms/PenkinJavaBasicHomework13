package ru.java.basic.penkin.hw13;

import java.io.*;
import java.net.*;

public class CalculatorClient {    // в гитхаб vetka1
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8890);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String serverMessage = in.readLine();
            System.out.println("Сервер: " + serverMessage);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введите операцию (+, -, *, /): ");
            String operation = userInput.readLine();
            out.println(operation);

            System.out.print("Введите первое число: ");
            double operand1 = Double.parseDouble(userInput.readLine());
            out.println(operand1);

            System.out.print("Введите второе число: ");
            double operand2 = Double.parseDouble(userInput.readLine());
            out.println(operand2);

            String result = in.readLine();
            System.out.println("Сервер: " + result);

            in.close();
            out.close();
            userInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}