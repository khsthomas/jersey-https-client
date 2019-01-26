package se.thinkcode;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static se.thinkcode.JerseyHttpClientFactory.getJerseyHTTPSClient;

public class CurrencyTradeTest {

    @Test
    public void currency_trade_jersey() throws Exception {
        String actual = post();

        assertThat(actual).doesNotContain("requested resource could not be found");
        assertThat(actual.length()).isEqualTo(24);
    }

    private String post() throws Exception {
        String url = "https://currencytrade-spray.herokuapp.com";

        String payload = TradeOrder.getOrder();
        Entity<String> tradeOrder = Entity.entity(payload, MediaType.APPLICATION_JSON);

        Client client = getJerseyHTTPSClient();

        try {
            return client
                    .target(url)
                    .path("v1")
                    .path("trade")
                    .request()
                    .post(tradeOrder)
                    .readEntity(String.class);
        } finally {
            client.close();
        }
    }
}