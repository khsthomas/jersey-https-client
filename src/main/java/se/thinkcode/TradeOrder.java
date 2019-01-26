package se.thinkcode;

import org.json.JSONObject;

public class TradeOrder {
    public static String getOrder() {
        JSONObject jsonToSend = new JSONObject();
        jsonToSend.put("userId", "134256");
        jsonToSend.put("currencyFrom", "EUR");
        jsonToSend.put("currencyTo", "GBP");
        jsonToSend.put("amountSell", 1000);
        jsonToSend.put("amountBuy", 747.10);
        jsonToSend.put("rate", 0.7471);
        jsonToSend.put("timePlaced", "24-JAN-15 10:27:44");
        jsonToSend.put("originatingCountry", "FR");

        return jsonToSend.toString(2);
    }

}
