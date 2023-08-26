package org.mvc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mvc.model.Doctor;
import org.springframework.jdbc.core.RowMapper;
public class RowMapperImpl implements RowMapper<Doctor> {
  @Override
  public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
    // TODO It will convert the result-set into objects
    Doctor doctor = new Doctor();
    doctor.setId(rs.getInt(1));
    doctor.setName(rs.getString(2));
    doctor.setEmail(rs.getString(3));
    doctor.setSpecialist(rs.getString(4));
    doctor.setCity(rs.getString(5));
    doctor.setCountry(rs.getString(6));
    return doctor;
  }
  
}