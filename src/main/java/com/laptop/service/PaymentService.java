package com.laptop.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.laptop.dto.payment.PaymentDTO;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentService {

    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());

    public static String generatePaymentLink(PaymentDTO paymentDTO) throws IOException {

        Dotenv dotenv = Dotenv.load();

        Gson gson = new Gson();
        String json = gson.toJson(paymentDTO);

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder().url("https://accept.paymob.com/v1/intention/").method("POST", body)
                .addHeader("Authorization", dotenv.get("PAYMENT_SECRET_KEY"))
                .addHeader("Content-Type", "application/json").build();

        try (Response response = client.newCall(request).execute()) {

            JsonObject clientSecret = JsonParser.parseString(response.body().string()).getAsJsonObject();

            return "https://accept.paymob.com/unifiedcheckout/?" +
                    "publicKey=" +
                    dotenv.get("PAYMENT_PUBLIC_KEY") +
                    "&clientSecret=" +
                    clientSecret.get("client_secret").getAsString();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
