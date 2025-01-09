package service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import model.CryptoCurrency;

@Service
public class CryptoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public CryptoCurrency getCryptoPrice(String coinId) {
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=" + coinId + "&vs_currencies=usd";

        // ניסיון לקבל את המידע
        CryptoCurrency cryptoCurrency = restTemplate.getForObject(url, CryptoCurrency.class);

        if (cryptoCurrency == null) {
            System.out.println("Error: Unable to retrieve data.");
        } else {
            System.out.println("Crypto data retrieved successfully: " + cryptoCurrency);
        }

        return cryptoCurrency;
    }
}
