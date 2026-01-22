package com.code.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {

	private String task;
	private boolean done;

}
