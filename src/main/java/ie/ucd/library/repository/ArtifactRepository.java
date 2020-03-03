package ie.ucd.library;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
//	Optional<User> findByIdAndPassword(int id, String password);
}