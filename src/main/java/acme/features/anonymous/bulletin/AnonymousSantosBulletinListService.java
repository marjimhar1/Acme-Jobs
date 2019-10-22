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

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.SantosBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSantosBulletinListService implements AbstractListService<Anonymous, SantosBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousSantosBulletinRepository repository;


	@Override
	public boolean authorise(final Request<SantosBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<SantosBulletin> request, final SantosBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nombre", "apellido", "descripcion", "fecha");

	}

	@Override
	public Collection<SantosBulletin> findMany(final Request<SantosBulletin> request) {
		assert request != null;

		Collection<SantosBulletin> result;

		result = this.repository.findMany();

		return result;
	}

}
