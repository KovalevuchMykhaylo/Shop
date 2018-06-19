package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ShopingCart extends Base {

    @OneToMany(mappedBy = "shopingCart")
    private List<User> users = new ArrayList<>();

    @ManyToMany
    private List<Item> items = new ArrayList<>();

    @Column(name = "_count")
    private int count;

    public void add(Item e) {
        items.add(e);
        count = items.size();
    }

    public void remove(Item e) {
        items.remove(e);
        count = items.size();
    }

    public void removeAll(List<Item> items) {
        items.removeAll(items);
        count = items.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
