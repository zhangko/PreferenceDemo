package greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import greendao.Department;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DEPARTMENT.
*/
public class DepartmentDao extends AbstractDao<Department, Long> {

    public static final String TABLENAME = "DEPARTMENT";

    /**
     * Properties of entity Department.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ParentID = new Property(1, String.class, "parentID", false, "PARENT_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Code = new Property(3, String.class, "code", false, "CODE");
        public final static Property Abbreviation = new Property(4, String.class, "abbreviation", false, "ABBREVIATION");
        public final static Property IsCompany = new Property(5, Integer.class, "isCompany", false, "IS_COMPANY");
    };


    public DepartmentDao(DaoConfig config) {
        super(config);
    }
    
    public DepartmentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DEPARTMENT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'PARENT_ID' TEXT," + // 1: parentID
                "'NAME' TEXT," + // 2: name
                "'CODE' TEXT," + // 3: code
                "'ABBREVIATION' TEXT," + // 4: abbreviation
                "'IS_COMPANY' INTEGER);"); // 5: isCompany
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DEPARTMENT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Department entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String parentID = entity.getParentID();
        if (parentID != null) {
            stmt.bindString(2, parentID);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(4, code);
        }
 
        String abbreviation = entity.getAbbreviation();
        if (abbreviation != null) {
            stmt.bindString(5, abbreviation);
        }
 
        Integer isCompany = entity.getIsCompany();
        if (isCompany != null) {
            stmt.bindLong(6, isCompany);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Department readEntity(Cursor cursor, int offset) {
        Department entity = new Department( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // parentID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // code
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // abbreviation
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5) // isCompany
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Department entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setParentID(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCode(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAbbreviation(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsCompany(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Department entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Department entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
