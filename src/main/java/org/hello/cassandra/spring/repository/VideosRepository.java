package org.hello.cassandra.spring.repository;

import java.util.UUID;
import org.hello.cassandra.spring.entity.Videos;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
public interface VideosRepository extends CassandraRepository<Videos>{
	@Query("SELECT * FROM videos WHERE videoid=?0")
	public Videos findByID(UUID videoID);
	
	@Query("SELECT * FROM videos WHERE name=?0")
	public Videos findByname(String name);
}
