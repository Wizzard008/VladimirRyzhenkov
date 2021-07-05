package ru.training.at.hw5.util;

import java.util.Objects;

public class UserItem {
    public String number;
    public String user;
    public String description;

    public UserItem(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserItem userItem = (UserItem) o;
        return number.equals(userItem.number) && user.equals(userItem.user)
            && description.equals(userItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }

    @Override
    public String toString() {
        return "{" + number + " " + user + " " + description + "}";
    }
}
