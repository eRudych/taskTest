package com.example.demo.repository;

import com.example.demo.db.automobiles.tables.records.AutoRecord;
import com.example.demo.entity.AutoModel;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo.db.automobiles.tables.Auto.AUTO;

@Repository
@RequiredArgsConstructor
public class AutoRepositoryImpl implements AutoRepository {

    private final DSLContext dsl;

    private Long insert(AutoModel autoModel) {
        AutoRecord authorRecord = dsl.insertInto(AUTO, AUTO.BRAND, AUTO.MODEL)
                .values(autoModel.getBrand(), autoModel.getModel())
                .returning(AUTO.ID)
                .fetchOne();
        return authorRecord.getValue(AUTO.ID);
    }

    @Override
    public AutoModel create(AutoModel autoModel) {
        return selectById(insert(autoModel));
    }

    @Override
    public void update(AutoModel autoModel) {
        dsl.update(AUTO)
                .set(AUTO.BRAND, autoModel.getBrand())
                .set(AUTO.MODEL, autoModel.getModel())
                .where(AUTO.ID.eq(autoModel.getId()));
    }

    @Override
    public void delete(long id) {
        dsl.deleteFrom(AUTO)
                .where(AUTO.ID.eq(id));
    }

    @Override
    public AutoModel selectById(long id) {
        return dsl.selectFrom(AUTO)
                .where(AUTO.ID.eq(id))
                .fetchOneInto(AutoModel.class);
    }

    @Override
    public List<AutoModel> selectAll() {
        return dsl.selectFrom(AUTO)
                .fetchInto(AutoModel.class);
    }

}
