package com.douglashdezt.library.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bookloan")
public class BookLoan {

	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;
	
	@Column(name = "loan_date")
	private Date loanDate;
	
	@Column(name = "exp_date")
	private Date expDate;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_code", nullable = true)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_code", nullable = true)
	private Book book;

	public BookLoan(Date loanDate, Date expDate, Date returnDate, User user, Book book) {
		super();
		this.loanDate = loanDate;
		this.expDate = expDate;
		this.returnDate = returnDate;
		this.user = user;
		this.book = book;
	}
}
