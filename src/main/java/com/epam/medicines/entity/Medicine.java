package com.epam.medicines.entity;

import java.util.List;

public class Medicine {
    private String name;
    private String pharm;
    private List<Analogs> analogsList;
    private String group;
    private Version version=new Version();

    public Medicine() {

    }
    public Medicine(Version version){
        this.version=version;
    }
    public Medicine(String name, String pharm, List<Analogs> analogsList, String group, Version version) {
        this.name = name;
        this.pharm = pharm;
        this.analogsList = analogsList;
        this.group = group;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public List<Analogs> getAnalogsList() {
        return analogsList;
    }

    public void setAnalogsList(List<Analogs> analogsList) {
        this.analogsList = analogsList;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (name != null ? !name.equals(medicine.name) : medicine.name != null) return false;
        if (pharm != null ? !pharm.equals(medicine.pharm) : medicine.pharm != null) return false;
        if (analogsList != null ? !analogsList.equals(medicine.analogsList) : medicine.analogsList != null)
            return false;
        if (group != null ? !group.equals(medicine.group) : medicine.group != null) return false;
        return version != null ? version.equals(medicine.version) : medicine.version == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pharm != null ? pharm.hashCode() : 0);
        result = 31 * result + (analogsList != null ? analogsList.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("name='").append(name).append('\'');
        sb.append(", pharm='").append(pharm).append('\'');
        sb.append(", analogsList=").append(analogsList);
        sb.append(", group='").append(group).append('\'');
        sb.append(", version=").append(version);
        sb.append('}');
        sb.append("\n");

        return sb.toString();
    }

}
