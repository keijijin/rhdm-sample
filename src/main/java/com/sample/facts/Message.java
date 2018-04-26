package com.sample.facts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    public static final int HELLO = 0;
    public static final int GOODBYE = 1;

    private String message;
	private int status;
}
