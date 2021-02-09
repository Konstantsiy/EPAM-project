package com.epam.web.model.entity;


public class Author {
    private String name;
    private String surname;

    public Author() {}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name != null && name.equals(author.name) &&
                surname != null && surname.equals(author.surname);
    }

    @Override
    public int hashCode() {
        int result = 31 * 17;
        result += 31 * 17 + name.hashCode();
        result += 31 * 17 + surname.hashCode();
        return result;
    }
}
