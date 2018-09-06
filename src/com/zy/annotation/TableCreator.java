package com.zy.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        //1.获取表名
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("No DBTable annotations in class " + className);
            return null;
        }
        String tableName = dbTable.name();
        //2.处理字段
        List<String> columnDefs = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getDeclaredAnnotations().length > 0) {
                Annotation[] annos = field.getDeclaredAnnotations();
                if (annos[0] instanceof SQLString) {
                    columnDefs.add(getStringColumn(annos[0], field));
                } else if (annos[0] instanceof SQLInteger) {
                    columnDefs.add(getIntegerColumn(annos[0], field));
                }
            }
        }
        //3.构建表
        StringBuilder sqlCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefs) {
            sqlCommand.append("\n   " + columnDef + ",");
        }
        return sqlCommand.substring(0, sqlCommand.length() - 1) + ");";
    }

    public static String getStringColumn(Annotation anno, Field field) {
        SQLString sqlStr = (SQLString) anno;

        String columnName = "";
        if (sqlStr.name().equals("")) {
            columnName = field.getName().toUpperCase();
        } else {
            columnName = sqlStr.name();
        }
        return columnName + " VARCHAR (" +
                sqlStr.value() + ")" + getConstraints(sqlStr.constraint());
    }

    public static String getIntegerColumn(Annotation anno, Field field) {
        SQLInteger sqlInt = (SQLInteger) anno;

        String columnName = "";
        if (sqlInt.name().equals("")) {
            columnName = field.getName().toUpperCase();
        } else {
            columnName = sqlInt.name();
        }
        return columnName + " INT" + getConstraints(sqlInt.constraint());
    }

    public static String getConstraints(Constraints con) {
        String constarints = "";
        if (!con.allowNull()) {
            constarints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constarints += " PRAMARY KEY";
        }
        if (con.unique()) {
            constarints += " UNIQUE";
        }
        return constarints;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String[] arg = {"com.zy.annotation.Member"};
        for (String className : arg) {
            System.out.println("Table Creation SQL for " +
                    className + " is :\n" + createTableSql(className));
        }
    }
}