package com.esports.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.esports.entities.MatchEntity;

public interface MatchRepository extends JpaRepository<MatchEntity, Long>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update matches set active = false where id = ?1")
	int deleteEnityById(Long id);
	
	@Query("select m from matches m LEFT JOIN FETCH m.matchTeam mt LEFT JOIN FETCH m.matchcontest mc LEFT JOIN FETCH"
			+ " mt.team" )
	List<MatchEntity> findAllEntities();

}
