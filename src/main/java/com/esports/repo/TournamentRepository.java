package com.esports.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.esports.entities.TournamentEntity;

public interface TournamentRepository extends JpaRepository<TournamentEntity, Long>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update tournament set active = false where id = ?1")
	int deleteEnityById(Long id);

}
