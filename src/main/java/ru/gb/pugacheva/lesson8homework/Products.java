package ru.gb.pugacheva.lesson8homework;

public class Products {


    private final String title;

    private final int id;

    public Products(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products product = (Products) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Math.abs(id); // для наглядности так делаем
        // return Objects.hash(id);
    }

}
