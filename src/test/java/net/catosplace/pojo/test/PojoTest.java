package net.catosplace.pojo.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.affirm.Affirm;

public class PojoTest {

    // Configured for expectation, so we know when a class gets added or removed.
    private static final int EXPECTED_CLASS_COUNT = 1;

    // The package to test
    private static final String POJO_PACKAGE = "net.catosplace.pojo";

    private List<PojoClass> pojoClasses;
    private PojoValidator pojoValidator;

    @Before
    public void prepareValidator() {
        pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new FilterPackageInfo());
        pojoValidator = new PojoValidator();
    }

    @Test
    public void ensureExpectedPojoCount() {
        Affirm.affirmEquals("Classes added / removed?", EXPECTED_CLASS_COUNT, pojoClasses.size());
    }

    @Test
    public void testPojoStructureAndBehaviour() {
        for (PojoClass pojoClass : pojoClasses) {
            pojoValidator.runValidation(pojoClass);
        }
    }

}
