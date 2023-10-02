package com.techpro.techpro.service;

import com.techpro.techpro.entity.Player;
import com.techpro.techpro.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor            // to inject through the constructor
public class PlayerService {        // service makes the connection between the UI and the DB

    private final PlayerRepository playerRepository;

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player updatePlayerById(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
