package JavaGUI;


public class Student {

    private String fullName, gender;
    private int age;
    private String email, phone;


    public Student() {
    }

    public Student(String fullName, String gender, int age, String email, String phone) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return fullName + ", " + gender + ", " + age + ", " + email + ", " + phone;
    }

}
