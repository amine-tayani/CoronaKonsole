package api;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CovidApiTest {

	public static void main(String[] args)
            throws InterruptedException  {
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\t+-------------------------------------------------------+");
		System.out.println("\t\t\t| Covid-19 pandemic live Statistics | Search By Country | ");
        System.out.println("\t\t\t+-------------------------------------------------------+");
        System.out.print("Search Country : ");
        String country = input.nextLine();
        OkHttpClient client = new OkHttpClient();
        Gson g = new Gson();
        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/country?format=json&name="+country)
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "5316c7c3fdmsha43e3c3cdf20a3ep15530ajsnd4ad011927a2")
                .build();

		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
               if (response.body() == null){
                   System.out.println(country+" doesn't exist ");
               }
               else {
                   System.out.print("loading ");
                   for (int i=0;i<10;i++) {
                       Thread.sleep(700);
                       System.out.print(".");
                   }
                    Gson gson = new Gson();
                   String res = response.body().string();
                   Covid[] enums = gson.fromJson(res, Covid[].class);
                   for (Covid item:enums
                        ) {

                       System.out.println(item);

                   }

               }
            }
			else{
			    System.out.println("Api call fails");
            }

		} catch (IOException e) {
			System.out.println("you maybe check your network first");
		}

	}

}
