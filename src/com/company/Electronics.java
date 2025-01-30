package com.company;

public class Electronics extends Product {
    public Electronics(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Electronics{");
        sb.append("id=").append(this.getId());
        sb.append(", name='").append(this.getName()).append('\'');
        sb.append(", price=").append(this.getPrice());
        sb.append(", stock=").append(this.getStock());
        sb.append('}');
        return sb.toString();
    }
}
