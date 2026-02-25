package com.example.reclamationweb;

import java.util.List;

public interface IReclamation {
    public List<Reclamation> allReclamation();

    Reclamation getReclamationById(int id);

    Reclamation addReclamation(Reclamation c);

    Reclamation updateReclamation(int id, Reclamation c);

    void deleteReclamation(int id);
}
