
package ru.training.at.hw10.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Membership {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("idMember")
    @Expose
    private String idMember;
    @SerializedName("memberType")
    @Expose
    private String memberType;
    @SerializedName("unconfirmed")
    @Expose
    private Boolean unconfirmed;
    @SerializedName("deactivated")
    @Expose
    private Boolean deactivated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Boolean getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(Boolean unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public Boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Boolean deactivated) {
        this.deactivated = deactivated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Membership.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("idMember");
        sb.append('=');
        sb.append(((this.idMember == null)?"<null>":this.idMember));
        sb.append(',');
        sb.append("memberType");
        sb.append('=');
        sb.append(((this.memberType == null)?"<null>":this.memberType));
        sb.append(',');
        sb.append("unconfirmed");
        sb.append('=');
        sb.append(((this.unconfirmed == null)?"<null>":this.unconfirmed));
        sb.append(',');
        sb.append("deactivated");
        sb.append('=');
        sb.append(((this.deactivated == null)?"<null>":this.deactivated));
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
        result = ((result* 31)+((this.unconfirmed == null)? 0 :this.unconfirmed.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.memberType == null)? 0 :this.memberType.hashCode()));
        result = ((result* 31)+((this.deactivated == null)? 0 :this.deactivated.hashCode()));
        result = ((result* 31)+((this.idMember == null)? 0 :this.idMember.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Membership) == false) {
            return false;
        }
        Membership rhs = ((Membership) other);
        return ((((((this.unconfirmed == rhs.unconfirmed)||((this.unconfirmed!= null)&&this.unconfirmed.equals(rhs.unconfirmed)))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.memberType == rhs.memberType)||((this.memberType!= null)&&this.memberType.equals(rhs.memberType))))&&((this.deactivated == rhs.deactivated)||((this.deactivated!= null)&&this.deactivated.equals(rhs.deactivated))))&&((this.idMember == rhs.idMember)||((this.idMember!= null)&&this.idMember.equals(rhs.idMember))));
    }

}
