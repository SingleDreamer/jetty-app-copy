package org.example.app.resources;

import java.util.Iterator;

import org.example.app.api.TaskMapper;
import org.example.app.api.Task;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TaskMapper.class)
public interface MyDAO {
	
	public static final String TASK_DB_URL  = "jdbc:mysql://192.168.99.100:3306/task";
	public static final String TASK_DB_USER = "myuser";
	public static final String TASK_DB_PASS = "mysecretpassword";

	@SqlQuery("SELECT LAST_INSERT_ID()")
	int getLatestId(); 
	
//	@SqlUpdate("DROP TABLE IF EXISTS Tasks")
//	void deleteTaskTable(); 
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS"
			+ "Tasks(id INT PRIMARY KEY AUTO_INCREMENT, todo TEXT) ENGINE=InnoDB")
	//@SqlUpdate("CREATE TABLE Tasks(id INT PRIMARY KEY, todo TEXT) ENGINE=InnoDB")
	  void createTaskTable();

//	  @SqlUpdate("INSERT INTO Tasks(id, todo) VALUES(:id, :todo)")
//	  void insert(@Bind("id") int id, @Bind("todo") String todo);
	@SqlUpdate("INSERT INTO Tasks(todo) VALUES(:todo)")
	  void insert(@Bind("todo") String todo);
	  
	  @SqlUpdate("UPDATE Tasks SET todo = :todo WHERE id = :id")
	  void update(@Bind("id") int id, @Bind("todo") String todo);
	  
	  @SqlUpdate("DELETE FROM Tasks WHERE id = :id")
	  void delete(@Bind("id") int id);

	  @SqlQuery("SELECT todo FROM Tasks WHERE id = :id")
	  String findById(@Bind("id") int id);
	  
	  @SqlQuery("SELECT * FROM Tasks")
	  Iterator<Task> getAll();

	  /**
	   * close with no args is used to close the connection
	   */
	  void close();
}
