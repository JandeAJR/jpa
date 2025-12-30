package com.udemy.infrastructure.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*
    Esta classe representa o modelo da entidade

    O modelo de entidade deve:

        - Implementar a interface Serializable;
        - Ter os atributos da entidade que representa;
        - Ter construtores;
        - Ter métodos Gettters e Setters;
        - Ter métodos hascode e equals;
        - Ter o método toString;
        - Colocar as anotações para definir a entidade, as colunas e os relacionamentos se tiver;
*/

@Entity
@Table(name = "tb_request")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "pizzaId") // chave estrangeira referenciando o Pizza
    private Pizza pizzaId; // Muitos pedidos podem ser feitos para uma pizza

    @ManyToOne
    @JoinColumn(name = "telephone") // chave estrangeira referenciando o Customer
    private Customer customer; // Muitos pedidos podem ser feitos por um cliente

    public Request() {}

    public Request(LocalDateTime date, Integer amount, Double price, Pizza pizzaId, Customer customer) {
        this.date = date;
        this.amount = amount;
        this.price = price;
        this.pizzaId = pizzaId;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter e Setter para pizzaId
    public Pizza getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Pizza pizzaId) {
        this.pizzaId = pizzaId;
    }

    // Getter e Setter para customer
    public Customer getCustomer() {
       return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", price=" + price +
                ", pizzaId=" + pizzaId +
                ", customer=" + customer +
                '}';
    }
}
