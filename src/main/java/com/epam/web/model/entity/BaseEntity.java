package com.epam.web.model.entity;

import com.epam.web.model.dao.BaseDao;

public abstract class BaseEntity {
    protected int id;

    protected BaseEntity() {}

    protected BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
