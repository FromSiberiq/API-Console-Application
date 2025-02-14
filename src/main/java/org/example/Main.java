package org.example;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.example.dto.Current;
import org.example.dto.WeatherResponse;
import retrofit2.Response;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Weather API Console Application!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Enter your city (or ctl + c for exit): ");
            String city = scanner.nextLine();
            Response<WeatherResponse> response = Weather.instance()
                    .current(Weather.WEATHER_API_KEY, city)
                    .execute();
            if (response.isSuccessful()) {
                Current current = response.body().getCurrent();
                PrintStream var10000 = System.out;
                Double var10001 = current.getTempC();
                var10000.println("Temperature is " + var10001 + " and if feels like " + current.getFeelslikeC());
            } else {
                System.out.println("Something went wrong. Please try again.");
            }
        }
    }
}