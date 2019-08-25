package com.example.demo.repositories;

import com.example.demo.db.automobiles.tables.Auto;
import com.example.demo.db.automobiles.tables.records.AutoRecord;
import com.example.demo.entity.AutoModel;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AutoRepository {
    private Auto auto = Auto.AUTO;

    @Autowired
    private DSLContext dsl;

    @Transactional
    public int insert(AutoModel autoModel){
        AutoRecord authorRecord = dsl.insertInto(auto, auto.BRAND, auto.MODEL)
                .values(autoModel.getBrand(), autoModel.getModel())
                .returning(auto.ID)
                .fetchOne();
        return authorRecord.getValue(auto.ID);
        //id can be null
    }

    @Transactional
    public boolean update(AutoModel autoModel)
    {
        return dsl.update(auto)
                .set(auto.BRAND, autoModel.getBrand())
                .set(auto.MODEL, autoModel.getModel())
                .where(auto.ID.eq(autoModel.getId()))
                .execute() == 1;
    }

    @Transactional
    public boolean delete(int id)
    {
        return dsl.deleteFrom(auto)
                .where(auto.ID.eq(id))
                .execute() == 1;
    }

    @Transactional
    public com.example.demo.db.automobiles.tables.pojos.Auto selectById(int id){
        return dsl.selectFrom(auto)
                .where(auto.ID.eq(id))
                .fetchOneInto(com.example.demo.db.automobiles.tables.pojos.Auto.class);
    }

    @Transactional
    public List<com.example.demo.db.automobiles.tables.pojos.Auto> selectAll()
    {
        return dsl.selectFrom(auto)
                .fetchInto(com.example.demo.db.automobiles.tables.pojos.Auto.class);
    }

}
