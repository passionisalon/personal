package com.kyuho.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name="PopularSearch")
@Entity(name="PopularSearch")
@NoArgsConstructor
@AllArgsConstructor
public class PopularSearchEntity {
	@Id
	private String popularTerm;
    private int popularSearchCount;
}	// end class
