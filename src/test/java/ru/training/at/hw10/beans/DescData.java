
package ru.training.at.hw10.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DescData {

    @SerializedName("emoji")
    @Expose
    private Emoji emoji;

    public Emoji getEmoji() {
        return emoji;
    }

    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DescData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("emoji");
        sb.append('=');
        sb.append(((this.emoji == null)?"<null>":this.emoji));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.emoji == null)? 0 :this.emoji.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DescData) == false) {
            return false;
        }
        DescData rhs = ((DescData) other);
        return ((this.emoji == rhs.emoji)||((this.emoji!= null)&&this.emoji.equals(rhs.emoji)));
    }

}
