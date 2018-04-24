package com.poddubnaya.domain.entity;


public class NewsDomain implements Comparable<NewsDomain>{

    private long created;
    private String text;
    private String team;
    private String title;
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

    public NewsDomain(long created, String text, String team, String title, String objectId) {
        this.created = created;
        this.text = text;
        this.team = team;
        this.title = title;
        this.objectId = objectId;
    }

    @Override
    public int compareTo(NewsDomain o) {
        if(this.created==o.created)
            return 0;
        if(this.created>o.created) return -1;
        return 1;
    }
}
