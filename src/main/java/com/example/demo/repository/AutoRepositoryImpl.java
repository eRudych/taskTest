package com.example.demo.repository;

import com.example.demo.db.automobiles.tables.records.AutoRecord;
import com.example.demo.entity.AutoModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo.db.automobiles.tables.Auto.AUTO;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AutoRepositoryImpl implements AutoRepository {

    private final DSLContext dsl;

    private Long insert(AutoModel autoModel) {
        AutoRecord authorRecord = dsl.insertInto(AUTO, AUTO.BRAND, AUTO.MODEL)
                .values(autoModel.getBrand(), autoModel.getModel())
                .returning(AUTO.ID)
                .fetchOne();
        log.info("Insert into db: {}", autoModel.toString());
        return authorRecord.getValue(AUTO.ID);
    }

    @Override
    public AutoModel create(AutoModel autoModel) {
        log.info("Create auto: {}", autoModel.toString());
        return get(insert(autoModel));
    }

    @Override
    public void update(AutoModel autoModel) {
        log.info("Update auto: {}", autoModel.toString());
        dsl.update(AUTO)
                .set(AUTO.BRAND, autoModel.getBrand())
                .set(AUTO.MODEL, autoModel.getModel())
                .where(AUTO.ID.eq(autoModel.getId())).execute();
    }

    @Override
    public void remove(long id) {
        log.info("Remove auto, id - {}", id);
        dsl.deleteFrom(AUTO)
                .where(AUTO.ID.eq(id)).execute();
    }

    @Override
    public AutoModel get(long id) {
        log.info("Get auto, id - {}", id);
        return dsl.selectFrom(AUTO)
                .where(AUTO.ID.eq(id))
                .fetchOneInto(AutoModel.class);
    }

    @Override
    public List<AutoModel> getAll() {
        log.info("Get auto list");
        return dsl.selectFrom(AUTO)
                .fetchInto(AutoModel.class);
    }
}
