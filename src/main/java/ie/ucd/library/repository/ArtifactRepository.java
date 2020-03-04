package ie.ucd.library;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
	Optional<Artifact> findById(int id);
	List<Artifact> findByOwner(Integer owner);
}