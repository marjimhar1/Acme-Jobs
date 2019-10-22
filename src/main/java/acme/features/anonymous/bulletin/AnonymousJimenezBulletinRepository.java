
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.JimenezBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousJimenezBulletinRepository extends AbstractRepository {

	@Query("select s from JimenezBulletin s")
	Collection<JimenezBulletin> findMany();

}
