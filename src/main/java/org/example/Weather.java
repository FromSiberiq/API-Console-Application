package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Weather {
    public static final String HOST = "https://api.weatherapi.com";
    public static final String WEATHER_API_KEY = "5b44643b61e1433fafb44049251402";
    private static WeatherAPI api;

    public Weather() {
    }

    private static WeatherAPI init() {
        Gson gson = (new GsonBuilder()).setLenient().create();
        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(WeatherAPI.class);
    }

    public static WeatherAPI instance() {
        if (api == null) {
            api = init();
        }

        return api;
    }
}
