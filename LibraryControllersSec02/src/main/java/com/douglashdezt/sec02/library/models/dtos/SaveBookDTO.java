package com.douglashdezt.sec02.library.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveBookDTO {
	private String isbn;
	private String title;
	private String owner;
	
	public SaveBookDTO(String isbn, String title, String owner) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "SaveBookDTO [isbn=" + isbn + ", title=" + title + ", owner=" + owner + "]";
	}
	
	
}
