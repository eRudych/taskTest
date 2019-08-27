package com.example.demo.repositories;

import com.example.demo.db.automobiles.tables.Auto;
import com.example.demo.db.automobiles.tables.records.AutoRecord;
import com.example.demo.entity.AutoModel;
import org.jooq.DSLContext;
import org.jooq.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AutoRepository {
    private final Auto auto = Auto.AUTO;

    @Autowired
    private DSLContext dsl;

    public Long insert(AutoModel autoModel) {
        AutoRecord authorRecord = dsl.insertInto(auto, auto.BRAND, auto.MODEL)
                .values(autoModel.getBrand(), autoModel.getModel())
                .returning(auto.ID)
                .fetchOne();
       return authorRecord.getValue(auto.ID);
    }

    public boolean update(AutoModel autoModel) {
        return dsl.update(auto)
                .set(auto.BRAND, autoModel.getBrand())
                .set(auto.MODEL, autoModel.getModel())
                .where(auto.ID.eq(autoModel.getId()))
                .execute() == 1;
    }

    public boolean delete(long id) {
        return dsl.deleteFrom(auto)
                .where(auto.ID.eq(id))
                .execute() == 1;
    }

    public AutoModel selectById(long id) {
        return dsl.selectFrom(auto)
                .where(auto.ID.eq(id))
                .fetchOneInto(AutoModel.class);
    }

    public List<AutoModel> selectAll() {
        return dsl.selectFrom(auto)
                .fetchInto(AutoModel.class);
    }

}
