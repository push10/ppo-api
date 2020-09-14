package com.ppo.assignment.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ppo.assignment.model.Content;

@Repository
public class ContentJdbcRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	JdbcTemplate jdbcTemplate;

	class ContentRowMapper implements RowMapper<Content> {
		@Override
		public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
			Content content = new Content();
			content.setId(rs.getLong("id"));
			content.setTitle(rs.getString("title"));
			content.setDescription(rs.getString("description"));
			return content;
		}

	}

	public List<Content> findAll() {
		return jdbcTemplate.query("select * from content", new ContentRowMapper());
	}

	public Content findById(long id) {
		return jdbcTemplate.queryForObject("select * from content where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Content>(Content.class));
	}
	public List<Content> findAllByTitle(String title, String offset) {
		logger.info("fetching content by matching "+title);
		
		return jdbcTemplate.query("select * from content where upper(title) like ? limit 10 offset ?", new String[]{"%"+title.toUpperCase()+"%", offset}, new ContentRowMapper());
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from content where id=?", new Object[] { id });
	}

	public int insert(Content content) {
		return jdbcTemplate.update("insert into content (id, title, description) " + "values(?,  ?, ?)",
				new Object[] { content.getId(), content.getTitle(), content.getDescription() });
	}

	public int update(Content content) {
		return jdbcTemplate.update("update content " + " set title = ?, description = ? " + " where id = ?",
				new Object[] { content.getTitle(), content.getDescription(), content.getId() });
	}

}
