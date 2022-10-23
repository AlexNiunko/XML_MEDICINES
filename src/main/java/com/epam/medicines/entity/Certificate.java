package com.epam.medicines.entity;

public class Certificate {
    private String number;
    private String dateOfIssue;
    private String expiration;
    private String organization;

    public Certificate() {

    }


    public Certificate(String number, String dateOfIssue, String expiration, String organization) {
        this.number = number;
        this.dateOfIssue = dateOfIssue;
        this.expiration = expiration;
        this.organization = organization;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getNumber() {
        return number;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getOrganization() {
        return organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Certificate that = (Certificate) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(that.dateOfIssue) : that.dateOfIssue != null) return false;
        if (expiration != null ? !expiration.equals(that.expiration) : that.expiration != null) return false;
        return organization != null ? organization.equals(that.organization) : that.organization == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (dateOfIssue != null ? dateOfIssue.hashCode() : 0);
        result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Certificate{");
        sb.append("number='").append(number).append('\'');
        sb.append(", dateOfIssue='").append(dateOfIssue).append('\'');
        sb.append(", expiration='").append(expiration).append('\'');
        sb.append(", organization='").append(organization).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
