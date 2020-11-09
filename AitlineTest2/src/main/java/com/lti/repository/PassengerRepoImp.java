package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.PassengerDto;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;

@Repository
public class PassengerRepoImp implements PassengerRepo {
@PersistenceContext
EntityManager em;
	@Override
	@Transactional
	public int addApassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		Passenger p=em.merge(passenger);
		
		return p.getPassengerId();
	}
	@Override
	public Passenger findPassengerById(int passengerId) {
		// TODO Auto-generated method stub
		return em.find(Passenger.class, passengerId);
	}
	@Override
	public List<Passenger> viewPassenger(int userId, int flightId) {
		// TODO Auto-generated method stub
		TypedQuery<Passenger> passenger=em.createQuery("select p from Passenger p where p.user.userId = :uId and p.flight.flightNo = :fId",Passenger.class); 
		passenger.setParameter("uId", userId);
		passenger.setParameter("fId", flightId);
		return passenger.getResultList();
	}

}
