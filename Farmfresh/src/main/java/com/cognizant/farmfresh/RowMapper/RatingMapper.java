package com.cognizant.farmfresh.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cognizant.farmfresh.model.Rating;

public class RatingMapper implements RowMapper<Rating> {
	public Rating mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Rating rating = new Rating();
	     rating.setCname(rs.getString("cname"));
	     rating.setRateService(rs.getInt("rateService"));
	     rating.setEmail(rs.getString("email"));
	     rating.setFname(rs.getString("fname"));
	     rating.setCons(rs.getString("cons"));
	     rating.setPros(rs.getString("pros"));
	     rating.setComments(rs.getString("comments"));
	     
	      return rating;
	   }
}
