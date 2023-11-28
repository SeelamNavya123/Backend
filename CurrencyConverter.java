import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Get user input for base and target currencies
        String baseCurrency = getUserInput("Enter base currency code (e.g., USD): ");
        String targetCurrency = getUserInput("Enter target currency code (e.g., EUR): ");

        // Get user input for amount to convert
        double amount = Double.parseDouble(getUserInput("Enter amount to convert: "));

        // Fetch exchange rate from API
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != -1) {
            // Perform conversion
            double convertedAmount = amount * exchangeRate;

            // Display result
            System.out.println(amount + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Failed to fetch exchange rate. Please try again later.");
        }
    }

    private static String getUserInput(String message) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String apiKey = "YOUR_API_KEY"; // Replace with your actual API key
        String urlString = "https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=" + apiKey;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString();
            double exchangeRate = Double.parseDouble(jsonResponse.split("\"" + targetCurrency + "\":")[1].split(",")[0]);

            return exchangeRate;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
