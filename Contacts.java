package readingfromexcel;

public class Contacts {
    private String name;
    private Number phoneNumber;
    private String address;
    private String profession;
    private Double age;
    
    public Contacts(String name, Number phoneNumber,String address, Double age, String profession){
        setName(name);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setAge(age);
        setProfession(profession);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    public Contacts(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Number phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }
  public int numberOfProperties(){
      return 5;
  }    
}
