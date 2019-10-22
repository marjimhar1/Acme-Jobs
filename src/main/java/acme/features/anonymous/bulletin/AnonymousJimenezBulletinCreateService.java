
package acme.features.anonymous.bulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.JimenezBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousJimenezBulletinCreateService implements AbstractCreateService<Anonymous, JimenezBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousJimenezBulletinRepository repository;


	@Override
	public boolean authorise(final Request<JimenezBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public JimenezBulletin instantiate(final Request<JimenezBulletin> request) {
		assert request != null;

		JimenezBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new JimenezBulletin();
		result.setNickname("Juanito Makande");
		result.setMensaje("Niña voladora");
		result.setFecha_presente(moment);

		return result;
	}

	@Override
	public void unbind(final Request<JimenezBulletin> request, final JimenezBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nickname", "mensaje");

	}

	@Override
	public void bind(final Request<JimenezBulletin> request, final JimenezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<JimenezBulletin> request, final JimenezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<JimenezBulletin> request, final JimenezBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setFecha_presente(moment);
		this.repository.save(entity);

	}

}
