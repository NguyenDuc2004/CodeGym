public class Contact {
    private String phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDate;
    private String email;

    public Contact(String phoneNumber, String group, String fullName, String gender, String address, String birthDate, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }


    public String getPhoneNumber() { return phoneNumber; }
    public String getFullName() { return fullName; }


    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setGroup(String group) { this.group = group; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setEmail(String email) { this.email = email; }

    @Override

    public String toString() {
        return String.format("| %-15s | %-12s | %-20s | %-10s | %-25s | %-12s | %-25s |",
                phoneNumber, group, fullName, gender, address, birthDate, email);
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                phoneNumber, group, fullName, gender, address, birthDate, email);
    }
}