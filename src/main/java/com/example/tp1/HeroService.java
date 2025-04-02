package com.example.tp1;

import com.example.tp1.Hero;
import com.example.tp1.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

  private final HeroRepository heroRepository;

  @Autowired
  public HeroService(HeroRepository heroRepository) {
    this.heroRepository = heroRepository;
  }

  public Hero save(Hero hero) {
    return heroRepository.save(hero);
  }

  public Optional<Hero> findById(Long id) {
    return heroRepository.findById(id);
  }

  public List<Hero> findAll() {
    return heroRepository.findAll();
  }

  public void delete(Long id) {
    heroRepository.deleteById(id);
  }
}
