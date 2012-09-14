package com.oasis.tmsv5.dao;

import org.springframework.stereotype.Component;

import com.oasis.tmsv5.model.TestModel;
@Component
public class TestModelDAOImpl extends BaseDAO<TestModel> implements TestModelDAO {

    @Override
    protected String getStatementNamespace() {
        return "com.oasis.tmsv5.dao.TestModelDAO";
    }

}
