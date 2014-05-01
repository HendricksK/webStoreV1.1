/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendricks.musicstoreweb2.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kurvin
 */
@Entity
public class PurchaseCD {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Double price;
    private String name;

    private PurchaseCD() {
    }

    ;
    
    private PurchaseCD(PurchaseCD item) {
        this.ID = item.ID;
        this.price = item.price;
        this.name = item.name;
    }

    private PurchaseCD(Builder item) {
        this.ID = item.ID;
        this.price = item.price;
        this.name = item.name;
    }

    public static class Builder {

        private Long ID;
        private Double price;
        private String name;

        public Builder(Double price) {
            this.price = price;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder PurchaseCD(PurchaseCD item) {
            this.ID = item.ID;
            this.price = item.price;
            this.name = item.name;
            return this;
        }

        public PurchaseCD build() {
            return new PurchaseCD(this);
        }

    }

    public Long getID() {
        return ID;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PurchaseCD other = (PurchaseCD) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

}
