package com.phase3phaseend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue
	private Integer TaskID;
	//private Integer userID;
	private String taskName;

    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date startDate;

    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date endDate;
	private String taskdesc;
	private String email;
	private String severity;
	
	
}
