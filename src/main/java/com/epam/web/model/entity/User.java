package com.epam.web.model.entity;

public class User extends BaseEntity {
    private String username;
    private int age;
    private String email;
//    private UserRole role;
//    private boolean isActive;

//    public User() {}

    public User(int id, String username, int age, String email) {
        super(id);
        this.username = username;
        this.age = age;
        this.email = email;
//        this.role = role;
//        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

//    public UserRole getRole() {
//        return role;
//    }
//
//    public void setRole(UserRole role) {
//        this.role = role;
//    }
//
//    public boolean isActive() {
//        return isActive;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  age == user.age &&
                !username.isEmpty() && username.equals(user.username) &&
//                role.equals(user.role) &&
//                isActive == user.isActive() &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result =  31 * 17 + username.hashCode();
        result += 31 * 17 + Integer.hashCode(age);
        result += 31 * 17 + email.hashCode();
//        result += 31 * 17 + role.hashCode();
//        result += isActive ? 123 : 321;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("User{username=")
                .append(username).append(", ")
                .append("age=").append(age).append(", ")
                .append("email=").append(email).append("}");
//                .append("role=").append(role).append(", ")
////                .append("isActive=").append(isActive).append("}");
        return result.toString();
    }
}
