package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {

    private static final int VERSION = 1;

    /*部门结构*/

    private static final String DEPARTMENT = "Department";

  //  private static final String ID = "_staffID";

    private static final String PARENT_ID = "parentID";

    private static final String NAME = "name";

    private static final String CODE = "code";

    private static final String ABBREVIATION = "abbreviation";

    private static final String IS_COMPANY = "isCompany";

    /*职员信息*/

    private static final String STAFF = "Staff";

    private static final String DEPARTMENT_ID = "departmentID";

    private static final String DEPARTMENT_CODE = "departmentCode";

    private static final String MOBILE = "mobile";

    private static final String TELEPHONE = "telephone";

    private static final String EMAIL = "email";

    private static final String GENDER = "gender";

    private static final String IS_MAINDEPARTMENT = "isMainDepartment";

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(VERSION, "greendao");
        addDepartment(schema);
        addStaff(schema);
        new DaoGenerator().generateAll(schema, "./app/src/main/java");
    }

    private static void addDepartment(Schema schema) {
        Entity department = schema.addEntity(DEPARTMENT);
        department.addIdProperty();
      //  department.addStringProperty(ID);
        department.addStringProperty(PARENT_ID);
        department.addStringProperty(NAME);
        department.addStringProperty(CODE);
        department.addStringProperty(ABBREVIATION);
        department.addIntProperty(IS_COMPANY);
    }

    private static void addStaff(Schema schema) {
        Entity staff = schema.addEntity(STAFF);
        staff.addIdProperty();
       // staff.addStringProperty(ID);
        staff.addStringProperty(NAME);
        staff.addStringProperty(CODE);
        staff.addStringProperty(DEPARTMENT_ID);
        staff.addStringProperty(DEPARTMENT_CODE);
        staff.addStringProperty(MOBILE);
        staff.addStringProperty(TELEPHONE);
        staff.addStringProperty(EMAIL);
        staff.addIntProperty(GENDER);
        staff.addIntProperty(IS_MAINDEPARTMENT);
    }
}
