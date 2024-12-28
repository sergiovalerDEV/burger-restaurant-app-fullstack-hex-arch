package model.motorsql;

import java.sql.ResultSet;

public class MotorPostgre extends MotorSQL{
    @Override
    public void connect() {
        url = "jdbc:postgresql://burguer.cibkqkdzlcl0.us-east-1.rds.amazonaws.com:5432/postgres";
        user = "postgres";
        password = "Alberto2024";
        ssl = "false";
        properties.setProperty("user", user);
        System.out.println("no");
        properties.setProperty("password", password);
        properties.setProperty("ssl", ssl);

        System.out.println("conecto");
        super.connect();
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public ResultSet executeQuery(String query) {
        return super.executeQuery(query);
    }

    @Override
    public void executeStatement(String statement) {
        super.executeStatement(statement);
    }
}
