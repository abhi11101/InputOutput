package org.example.SerializationDeserialization;

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer level;
    private Integer points;
    private User userDetails;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "Player{" +
                "level=" + level +
                ", points=" + points +
                ", userDetails=" + userDetails +
                '}';
    }
}
