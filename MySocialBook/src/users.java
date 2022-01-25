public class users {

    private int id ;
    private String name;
    private String username;
    private String password;
    private String age;
    private String school;




    public users(int id, String name, String username, String password, String age, String school) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.school = school;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {

        this.school = school;
    }
    public String toString(){
        return "Name : "+name+"\nUsername : "+ username+"\nPassword : "+password+ "\nAge : "+ age + "\nSchool : "+ school;
    }

}

