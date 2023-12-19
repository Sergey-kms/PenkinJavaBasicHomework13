package ru.java.basic.penkin.hw13;

import java.io.*;
import java.net.*;

public class CalculatorServer {   // в гитхаб vetka1
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8890);
            System.out.println("Сервер запущен и ждет подключения клиента");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Доступные операции: +, -, *, /");

            String operation = in.readLine();
            double operand1 = Double.parseDouble(in.readLine());
            double operand2 = Double.parseDouble(in.readLine());

            double result = 0;

            switch (operation) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
                default:
                    out.println("Неверная операция");
                    break;
            }

            out.println("Результат: " + result);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}