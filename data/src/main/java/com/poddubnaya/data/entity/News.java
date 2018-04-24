package com.poddubnaya.data.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "News")
public class News {

    @SerializedName("created")
    @Expose
    private long created;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("team")
    @Expose
    private String team;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("objectId")
    @Expose
    @PrimaryKey()
    @NonNull
    private String objectId;

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
