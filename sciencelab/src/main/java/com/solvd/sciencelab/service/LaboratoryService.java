package com.solvd.sciencelab.service;

import com.solvd.sciencelab.Laboratory;
import com.solvd.sciencelab.Order;
import com.solvd.sciencelab.dao.LaboratoryDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaboratoryService {
    LaboratoryDao laboratoryDao = new LaboratoryDao();

    public Laboratory getLaboratoryById(int id) {
        return laboratoryDao.select(id);
    }

    public List<Laboratory> getAllLaboratories() {
        return laboratoryDao.selectAll();
    }

    public List<Laboratory> getAllLaboratoriesByExpCapacity() {
        return laboratoryDao.selectAll().stream()
                .sorted(Comparator.comparing(Laboratory::getExpCapacity))
                .collect(Collectors.toList());
    }

    public void newLaboratory (Laboratory laboratory) {
        laboratoryDao.insert(laboratory);
    }

    public void changeLaboratoryById(Laboratory laboratory, int id) {
        laboratoryDao.update(laboratory, id);
    }

    public void destroyLaboratory (Laboratory laboratory) {
        laboratoryDao.delete(laboratory);
    }
}
