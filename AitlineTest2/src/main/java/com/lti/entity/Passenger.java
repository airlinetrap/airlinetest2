package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_passenger")
public class Passenger {

	@Id
	@SequenceGenerator(name = "passSeq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passSeq")
	@Column(name = "passenger_id")
	int passengerId;

	@Column(name = "passenger_name")
	String passangerName;

	@Column(name = "passenger_age")
	int passangerAge;

	
	@Column(name = "date_of_travel")
	LocalDate dateOfTravel;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	User user;

	@ManyToOne
	@JoinColumn(name = "flight_id")
	@JsonIgnore
	Flight flight;
	
	@OneToOne(mappedBy="passenger")//,cascade=CascadeType.REMOVE)
	BoardingPass boardingPass;
	
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public int getPassangerAge() {
		return passangerAge;
	}

	public void setPassangerAge(int passangerAge) {
		this.passangerAge = passangerAge;
	}

	
	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public BoardingPass getBoardingPass() {
		return boardingPass;
	}

	public void setBoardingPass(BoardingPass boardingPass) {
		this.boardingPass = boardingPass;
	}
	
	

}
