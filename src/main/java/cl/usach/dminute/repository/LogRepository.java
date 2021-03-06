package cl.usach.dminute.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.LoggDminute;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<LoggDminute, Serializable>{

}
