import { Pessoa } from "./Pessoa";

export class PessoaJuridica extends Pessoa {
    public cnpj: string;

	/**
	 * Está sendo considerado a Incrição Estadual no Formato de Minas Gerais.
	 * Format: "###.###.###/####"
	 */
	public inscricaoEstadual: string;

	public razaoSocial: string;

	public nomeFantasia: string;
}