package model.motorsql;

public class FactoryMotorSQL {

    final static String MOTORMYSQL = "MOTORMYSQL";
    final static String MOTORPOSTGRE = "MOTORPOSTGRE";
    static MotorSQL myInstance;
    public static MotorSQL getInstance(String type){
        switch (type){
            case MOTORMYSQL:
                myInstance = new MotorMySQL();
                return myInstance;
            case MOTORPOSTGRE:
                myInstance = new MotorPostgre();
                    return myInstance;
            default:
                return null;
        }
    };
}
