package com.epam.medicines.entity;

public class Dosage {
    private int amount;
    private String period;

    public Dosage() {

    }

    public Dosage(int amount, String period) {
        this.amount = amount;
        this.period = period;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dosage dosage = (Dosage) o;

        if (amount != dosage.amount) return false;
        return period != null ? period.equals(dosage.period) : dosage.period == null;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dosage{");
        sb.append("amount=").append(amount);
        sb.append(", period='").append(period).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
