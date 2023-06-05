package com.douglashdezt.library.models.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = {"bookLoans"})
@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "publish_date")
	private Date publishDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category", nullable = true)
	private Category category;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BookLoan> bookLoans;

	public Book(String isbn, String title, Date publishDate, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publishDate = publishDate;
		this.category = category;
	}
}
