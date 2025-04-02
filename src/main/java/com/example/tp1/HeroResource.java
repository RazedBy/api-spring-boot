package com.example.tp1;

import com.example.tp1.Hero;
import com.example.tp1.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Random;
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
    // Validation addition
    if (hero.getName() == null || hero.getName().isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    Hero result = heroService.save(hero);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Hero> getHero(@PathVariable Long id) {
    Optional<Hero> hero = heroService.findById(id);
    return hero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping
  public ResponseEntity<List<Hero>> getAllHeroes() {
    List<Hero> heroes = heroService.findAll();
    if (heroes.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(heroes);
    }
    return ResponseEntity.ok(heroes);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteHero(@PathVariable Long id) {
    if (!heroService.existsById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    heroService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/random")
  public ResponseEntity<Hero> getRandomHero() {
    List<Hero> heroes = heroService.findAll();
    if (heroes.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    Random random = new Random();
    Hero randomHero = heroes.get(random.nextInt(heroes.size()));
    return ResponseEntity.ok(randomHero);
  }
}
