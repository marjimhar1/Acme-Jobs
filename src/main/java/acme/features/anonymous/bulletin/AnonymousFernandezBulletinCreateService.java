
package acme.features.anonymous.bulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.FernandezBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousFernandezBulletinCreateService implements AbstractCreateService<Anonymous, FernandezBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousFernandezBulletinRepository repository;


	@Override
	public boolean authorise(final Request<FernandezBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public FernandezBulletin instantiate(final Request<FernandezBulletin> request) {
		assert request != null;

		FernandezBulletin result;
		Date fecha;

		fecha = new Date(System.currentTimeMillis() - 1);

		result = new FernandezBulletin();
		result.setUsuario("juan");
		result.setDireccion("Calle guapa 7");
		result.setComentario("jejeje");
		result.setFecha(fecha);

		return result;
	}

	@Override
	public void unbind(final Request<FernandezBulletin> request, final FernandezBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "usuario", "direccion", "comentario");

	}

	@Override
	public void bind(final Request<FernandezBulletin> request, final FernandezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<FernandezBulletin> request, final FernandezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<FernandezBulletin> request, final FernandezBulletin entity) {
		assert request != null;
		assert entity != null;

		Date fecha;

		fecha = new Date(System.currentTimeMillis() - 1);
		entity.setFecha(fecha);
		this.repository.save(entity);

	}

}
