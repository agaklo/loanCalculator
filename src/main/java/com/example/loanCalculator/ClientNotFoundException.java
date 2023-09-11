package com.example.loanCalculator;

class ClientNotFoundException  extends RuntimeException {
	ClientNotFoundException(String id) {
		super("Could not find client " + id);
	}
}

