package org.example.app.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TaskMapper implements ResultSetMapper<Task>
{
  public Task map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    return new Task(r.getInt("id"), r.getString("todo"));
  }
}