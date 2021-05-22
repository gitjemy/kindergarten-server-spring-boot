package com.jems.Kindergarten.services;

import com.jems.Kindergarten.model.Kid;
import com.jems.Kindergarten.repo.KidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KidService {
    private final KidsRepo kidsRepo;

    @Autowired
    public KidService(KidsRepo kidsRepo) {
        this.kidsRepo = kidsRepo;
    }

    public Kid addKid(Kid kid) {
        return kidsRepo.save(kid);
    }

    public List<Kid> getAll() {
        return kidsRepo.findAll();
    }

    public Kid update(Kid kid) {
        kidsRepo.save(kid);
        return kid;
    }

    public void delete(Long id) {
        kidsRepo.deleteById(id);
    }
}
