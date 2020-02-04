package com.carmel.materialactivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import Model.JsonModel;

public class BaseWatch {
    @SerializedName("watches")
    @Expose
    private List<JsonModel> watches = new ArrayList<>();

    public List<JsonModel> getWatches() {
        return watches;
    }

    public void setWatches(List<JsonModel> watches) {
        this.watches = watches;
    }
}
