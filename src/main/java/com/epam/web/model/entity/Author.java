package com.epam.web.model.entity;


public class Author extends BaseEntity {
    private String name;
    private String surname;
    private String image;

    public Author(int id, String name, String surname, String image) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getImage() {
        return image;
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
