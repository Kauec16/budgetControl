package org.BudgetControl.model;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Expanses {
    private int id;
    private String description;
    private double price;

    public Expanses() {
    }

    public Expanses(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expanses expanses = (Expanses) o;
        return getId() == expanses.getId() && Double.compare(price, expanses.price) == 0 && Objects.equals(getDescription(), expanses.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getValue());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return this.price;
    }

    public void setValue(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Expanses{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
