package spring.samples.queryapi.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.samples.dto.CreditCard;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

  private final static List<CreditCard> CREDIT_CARDS = Arrays.asList(
      new CreditCard(1L, "Visa", "1234-1234-1234-1234"),
      new CreditCard(2L, "Mastercard", "5678-5678-5678-5678"),
      new CreditCard(3L, "American Express", "9012-9012-9012-9012")
  );

  @GetMapping
  public List<CreditCard> getCreditCards() {
    return CREDIT_CARDS;
  }

}
