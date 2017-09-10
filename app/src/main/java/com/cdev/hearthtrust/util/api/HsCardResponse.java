package com.cdev.hearthtrust.util.api;

import com.cdev.hearthtrust.models.HsCard;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class HsCardResponse {
    HsCard card;

    public HsCardResponse() {
    }

    public static HsCardResponse[] parseJSON(String response) {


        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response, HsCardResponse[].class);
    }
}
