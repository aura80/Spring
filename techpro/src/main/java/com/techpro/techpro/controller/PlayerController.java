package com.techpro.techpro.controller;

import com.techpro.techpro.entity.Player;
import com.techpro.techpro.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor                    // to inject through the constructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @GetMapping("/getPlayers")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/getPlayerById/{id}")
    public Optional<Player> getPlayerById(@PathVariable("id") Long id) {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/updatePlayer/{id}")
    public Player updatePlayerById(@PathVariable("id") Long id,     // id specified as a path variable
                                 @RequestBody Player player) {
        return playerService.updatePlayerById(player);          // no need to specify the id here as a parameter, Spring will know ?
    }

    @DeleteMapping("/deletePlayerById/{id}")
    public void deletePlayerById(@PathVariable("id") Long id) {
        playerService.deletePlayerById(id);
    }
}

