package com.solvd.sciencelab.service;

import com.solvd.sciencelab.LabSize;
import com.solvd.sciencelab.Laboratory;
import com.solvd.sciencelab.Order;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.dao.LaboratoryDao;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaboratoryService {
    LaboratoryDao laboratoryDao = new LaboratoryDao();
    LabSizeDao labSizeDao = new LabSizeDao();

    public Laboratory getLaboratoryById(long id) {
        Laboratory lab = new Laboratory();
        try {
            lab = laboratoryDao.select(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lab;
    }

    public Laboratory getLabByLabSizeId(long id) {
        LabSize ls = new LabSize();
        Laboratory l = new Laboratory();
        try {
            ls = labSizeDao.select(id);
            l = laboratoryDao.select(id);
            l.setLabsize(ls);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
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
