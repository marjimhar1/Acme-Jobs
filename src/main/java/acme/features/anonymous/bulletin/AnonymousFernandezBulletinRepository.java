
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.FernandezBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousFernandezBulletinRepository extends AbstractRepository {

	@Query("select s from FernandezBulletin s")
	Collection<FernandezBulletin> findMany();
}
