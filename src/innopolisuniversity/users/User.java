package innopolisuniversity.users;

public abstract class User {
    
    protected final String name;
    protected final String login;
    protected final String password;
    protected int id;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;

        return getId() == ((User)obj).getId();
    }
}
