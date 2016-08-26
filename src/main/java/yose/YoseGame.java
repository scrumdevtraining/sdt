package yose;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.List;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import com.google.gson.Gson;

public class YoseGame {

	public static void main(String[] args) {
		port(getHerokuAssignedPort());

		Gson gson = new Gson();

		get("/", (request, response) -> {
			response.type("text/html");

			return new ModelAndView(new Object(), "index.ftl");
		}, new FreeMarkerEngine());

		get("/readMe/", (request, response) -> {
			response.type("text/html");

			return new ModelAndView(new Object(), "readMe.ftl");
		}, new FreeMarkerEngine());

		get("/contactMe/", (request, response) -> {
			response.type("text/html");

			return new ModelAndView(new Object(), "contact-me-link.ftl");
		}, new FreeMarkerEngine());

		get("/astroport", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "astroport-name.ftl");
        }, new FreeMarkerEngine());

		get("/ping", (request, response) -> {
			response.type("application/json");

			return new Status(true);
		}, gson::toJson);

		get("/primeFactors", (request, response) -> {
			response.type("application/json");

			String stNumber = request.queryParams("number");
			System.out.println("result:" +stNumber);
			
			List<Integer> arrStr = new ArrayList<>();
			
			int power = 1;
			int input = 0;
			
			try{
				input = Integer.parseInt(stNumber);
			}catch (NumberFormatException ex){
				return new DecompositionError(stNumber+"","not a number");
			}
			
			while(power <= input/2){
				power = power*2;
				arrStr.add(2);
			}

				return new Decomposition(input,arrStr);
			}, gson::toJson);

	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on
						// localhost)
	}

	public static double pow(double x, int pow) {
		if (x == 0)
			return 1;
		return pow > 0 ? getPositivePower(x, pow) : 1 / getPositivePower(x,
				-pow);
	}

	private static double getPositivePower(double x, int pow) {
		assert x != 0;
		if (pow == 0)
			return 1;

		int currentPow = 1;
		double value = x;
		while (currentPow <= pow / 2) {
			value = value * value;
			currentPow = currentPow * 2;
		}

		return value * getPositivePower(x, pow - currentPow);
	}

}
