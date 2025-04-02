package com.example.tp1;

import com.example.tp1.Hero;
import com.example.tp1.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/heroes")
public class HeroResource {

  private final HeroService heroService;

  public HeroResource(HeroService heroService) {
    this.heroService = heroService;
  }

  @PostMapping
  public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
    Hero result = heroService.save(hero);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Hero> getHero(@PathVariable Long id) {
    Optional<Hero> hero = heroService.findById(id);
    return hero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Hero> getAllHeroes() {
    return heroService.findAll();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteHero(@PathVariable Long id) {
    heroService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
