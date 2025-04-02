package com.example.tp1;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hero")
public class Hero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "universe")
    private String universe;

    @Column(name = "strength")
    private Integer strength;
    @Column(name="defense")
    private Integer defense;
    @Column(name="speed")
    private Integer speed;
    @Column(name = "accuracy")
    private Integer accuracy;
    @Column(name = "intelligence")
    private Integer intelligence;
    @Column(name = "luck")
    private Integer luck;


    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getUniverse() {
      return universe;
    }

    public void setUniverse(String universe) {
      this.universe = universe;
    }

    public Integer getStrength() {
      return strength;
    }

    public void setStrength(Integer strength) {
      this.strength = strength;
    }

    public Integer getDefense() {
      return defense;
    }

    public void setDefense(Integer defense) {
      this.defense = defense;
    }

    public Integer getSpeed() {
      return speed;
    }

    public void setSpeed(Integer speed) {
      this.speed = speed;
    }

    public Integer getAccuracy() {
      return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
      this.accuracy = accuracy;
    }

    public Integer getIntelligence() {
      return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
      this.intelligence = intelligence;
    }

    public Integer getLuck() {
      return luck;
    }

    public void setLuck(Integer luck) {
      this.luck = luck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        return id != null ? id.equals(hero.id) : hero.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
      return "Hero{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", universe='" + universe + '\'' +
        ", strength=" + strength +
        ", defense=" + defense +
        ", speed=" + speed +
        ", accuracy=" + accuracy +
        ", intelligence=" + intelligence +
        ", luck=" + luck +
        '}';
    }
}
