package com.example.aiimsproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateStatus {
    @SerializedName("id")
    @Expose
    private Long[] id;

    public Long[] getId() {
        return id;
    }

    public void setId(Long[] id) {
        this.id = id;
    }
}
