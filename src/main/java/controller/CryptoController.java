package controller;

import service.CryptoService;
import model.CryptoCurrency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/")
    public String getCrypto(Model model) {
        // שואל את המידע על המחיר של הביטקוין
        CryptoCurrency crypto = cryptoService.getCryptoPrice("bitcoin");

        if (crypto != null) {
            // שולח את המידע לדף ה-HTML רק אם יש נתונים
            model.addAttribute("crypto", crypto);
        } else {
            // שולח הודעה אם לא הצלחנו לקבל נתונים
            model.addAttribute("error", "Unable to retrieve cryptocurrency data.");
        }

        return "index";
    }
}
