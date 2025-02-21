package com.company;

import java.math.BigDecimal;
import java.util.UUID;

public class Electronics extends Product {
    public Electronics(String name, BigDecimal price, int stock) {
        super(name, price, stock);
    }

    @Override
    public Product clone() {
        return new Electronics(this.getId(), this.getName(), this.getPrice(), 0);
    }

    public Electronics(UUID id, String name, BigDecimal price, int stock) {
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
