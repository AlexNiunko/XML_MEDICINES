package com.epam.medicines.entity;

public class MedicinePackage {
    private String type;
    private int amount;
    private int price;

    public MedicinePackage() {

    }

    public MedicinePackage(String type, int amount, int price) {
        this.type = type;
        this.amount = amount;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicinePackage aMedicinePackage = (MedicinePackage) o;

        if (amount != aMedicinePackage.amount) return false;
        if (price != aMedicinePackage.price) return false;
        return type != null ? type.equals(aMedicinePackage.type) : aMedicinePackage.type == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + amount;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MedicinePackage{");
        sb.append("type='").append(type).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
