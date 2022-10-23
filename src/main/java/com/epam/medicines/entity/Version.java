package com.epam.medicines.entity;

public class Version {
    private String version_type;
    private Certificate certificate=new Certificate();
    private MedicinePackage medicinePackage=new MedicinePackage();
    private Dosage dosage=new Dosage();

    public Version() {
    }

    public Version(Certificate certificate, MedicinePackage medicinePackage, Dosage dosage) {
        this.certificate = certificate;
        this.medicinePackage = medicinePackage;
        this.dosage = dosage;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public MedicinePackage getMedicinePackage() {
        return medicinePackage;
    }

    public void setMedicinePackage(MedicinePackage medicinePackage) {
        this.medicinePackage = medicinePackage;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public String getVersion_type() {
        return version_type;
    }

    public void setVersion_type(String version_type) {
        this.version_type = version_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (certificate != null ? !certificate.equals(version.certificate) : version.certificate != null) return false;
        if (medicinePackage != null ? !medicinePackage.equals(version.medicinePackage) : version.medicinePackage != null)
            return false;
        return dosage != null ? dosage.equals(version.dosage) : version.dosage == null;
    }

    @Override
    public int hashCode() {
        int result = certificate != null ? certificate.hashCode() : 0;
        result = 31 * result + (medicinePackage != null ? medicinePackage.hashCode() : 0);
        result = 31 * result + (dosage != null ? dosage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Version{");
        sb.append("certificate=").append(certificate);
        sb.append(", medicinePackage=").append(medicinePackage);
        sb.append(", dosage=").append(dosage);
        sb.append('}');
        return sb.toString();
    }
}
