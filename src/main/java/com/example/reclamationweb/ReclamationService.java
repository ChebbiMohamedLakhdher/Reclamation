package com.example.reclamationweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService implements IReclamation {

    @Autowired
    private ReclamationRepositories reclamationRepo;

    @Autowired
    private UserClient userClient;
    @Override
    public List<Reclamation> allReclamation() {
        return reclamationRepo.findAll();
    }

    @Override
    public Reclamation getReclamationById(int id) {
        return reclamationRepo.findById(id).orElse(null);
    }

    @Override
    public Reclamation addReclamation(Reclamation r) {
        return reclamationRepo.save(r);
    }

    @Override
    public Reclamation updateReclamation(int id, Reclamation r) {
        Reclamation existing = reclamationRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setTicketId(r.getTicketId());
            existing.setSubject(r.getSubject());
            existing.setDescription(r.getDescription());
            return reclamationRepo.save(existing);
        }
        return null;
    }

    @Override
    public void deleteReclamation(int id) {
        reclamationRepo.deleteById(id);
    }

    public List<User> getUsersList() {
        return userClient.getUsers();
    }
    public User getUserClient(int id){
        return userClient.getUsers().get(id);
    }
}
