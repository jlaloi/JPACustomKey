package fr.julien.jpacustomkey;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookIdGenerator implements IdentifierGenerator {

    private static final String query = "SELECT book_id_seq.NEXTVAL as NEXTVAL from dual";

    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
        Connection connection = sessionImplementor.connection();
        Long nextId = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                nextId = resultSet.getLong("NEXTVAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id = getPrefix() + String.format("%08d", nextId);
        return id;
    }

    private String getPrefix() {
        DateFormat df = new SimpleDateFormat("YYYY");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

}