package com.example.tp1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class HeroDTO {

  private Long id;

  @Size(max = 300, message = "Le nom du héros ne peut pas dépasser 300 caractères.")
  private String name;

  @Size(max = 300, message = "L'univers du héros ne peut pas dépasser 300 caractères.")
  private String universe;

  @Min(value = 0, message = "La force doit être au moins de 0.")
  @Max(value = 100, message = "La force ne peut pas dépasser 100.")
  private Integer strength;

  @Min(value = 0, message = "La défense doit être au moins de 0.")
  @Max(value = 100, message = "La défense ne peut pas dépasser 100.")
  private Integer defense;

  @Min(value = 0, message = "La vitesse doit être au moins de 0.")
  @Max(value = 100, message = "La vitesse ne peut pas dépasser 100.")
  private Integer speed;

  @Min(value = 0, message = "L'exactitude doit être au moins de 0.")
  @Max(value = 100, message = "L'exactitude ne peut pas dépasser 100.")
  private Integer accuracy;

  @Min(value = 0, message = "L'intelligence doit être au moins de 0.")
  @Max(value = 100, message = "L'intelligence ne peut pas dépasser 100.")
  private Integer intelligence;

  @Min(value = 0, message = "La chance doit être au moins de 0.")
  @Max(value = 100, message = "La chance ne peut pas dépasser 100.")
  private Integer luck;

  // Constructeur sans argument
  public HeroDTO() {}

  // Constructeur avec arguments
  public HeroDTO(Long id, String name, String universe, Integer strength, Integer defense,
                 Integer speed, Integer accuracy, Integer intelligence, Integer luck) {
    this.id = id;
    this.name = name;
    this.universe = universe;
    this.strength = strength;
    this.defense = defense;
    this.speed = speed;
    this.accuracy = accuracy;
    this.intelligence = intelligence;
    this.luck = luck;
  }

  // Getters et setters
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
}
