package org.example;

import org.example.helpers.ResponseHelper;

public class TestBase extends CoreTest {

    protected final ResponseHelper responseHelper = new ResponseHelper();
    protected final DataHelper dataHelper = new DataHelper();
    protected final Checker checker = new Checker();
    protected final ApiUserMethods apiUserMethods = new ApiUserMethods();
}
