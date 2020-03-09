package ie.ucd.library;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findByOwner(Integer owner);
	List<Loan> findByArtifactAndOwner(int artifactID, Integer owner);
}