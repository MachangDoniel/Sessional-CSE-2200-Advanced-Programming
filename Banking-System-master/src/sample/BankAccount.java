package sample;

public class BankAccount {
    private String depositorName;
    private String typeOfAccount;
    private String AccountNumber;
    private String balance;

    private String Father;
    private String Mother;
    private String ddob;
    private String phone;
    private String Password;
    private String email;
    private String address;
    private String city;
    private String postal;
    private String Bank;


    public BankAccount(String depositorName, String accountNumber, String balance, String father, String mother, String ddob, String phone, String password, String email, String address, String city, String postal,String bank,String accountType) {
        this.depositorName = depositorName;
        this.typeOfAccount = accountType;
        AccountNumber = accountNumber;
        this.balance = balance;
        Father = father;
        Mother = mother;
        this.ddob = ddob;
        this.phone = phone;
        Password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postal = postal;
        this.Bank=bank;

    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFather() {
        return Father;
    }

    public void setFather(String father) {
        Father = father;
    }

    public String getMother() {
        return Mother;
    }

    public void setMother(String mother) {
        Mother = mother;
    }

    public String getDdob() {
        return ddob;
    }

    public void setDdob(String ddob) {
        this.ddob = ddob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
