package com.epam.web.model.entity;


public class Publisher extends BaseEntity {
    private String title;

//    public Publisher() {}

    public Publisher(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return title != null && title.equals(publisher.title);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + title.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder("Publisher{").append("title=").append(title).append("}").toString();
    }
}
