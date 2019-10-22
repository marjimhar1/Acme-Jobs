/*
 * AnonymousUserAccountCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.bulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.SantosBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSantosBulletinCreateService implements AbstractCreateService<Anonymous, SantosBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousSantosBulletinRepository repository;


	@Override
	public boolean authorise(final Request<SantosBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public SantosBulletin instantiate(final Request<SantosBulletin> request) {
		assert request != null;

		SantosBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new SantosBulletin();
		result.setNombre("Antonio");
		result.setApellido("Rodriguez");
		result.setDescripcion("¡Hola!");
		result.setFecha(moment);

		return result;
	}

	@Override
	public void unbind(final Request<SantosBulletin> request, final SantosBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nombre", "apellido", "descripcion");

	}

	@Override
	public void bind(final Request<SantosBulletin> request, final SantosBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<SantosBulletin> request, final SantosBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<SantosBulletin> request, final SantosBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setFecha(moment);
		this.repository.save(entity);

	}

}
