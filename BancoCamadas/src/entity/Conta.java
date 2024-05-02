package entity;

public class Conta {
	
	private int numero;
	private int agencia;
	private double saldo;
	private String titular;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public boolean equals(Object o) {
		if (o != null) {
			if (o != this) {
				if (o instanceof Conta) {
					Conta c = (Conta) o;
					return (c.getNumero() == this.getNumero());					
				}
			} else {
				return true;
			}
			return false;
		}
		return false;
	}

}
